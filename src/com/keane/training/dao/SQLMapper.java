package com.keane.training.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ResultMapper;
import com.keane.training.domain.Category;
import com.keane.training.domain.Orderlist;
import com.keane.training.domain.Product;
import com.keane.training.domain.User;

public class SQLMapper {
	
	public static final String INSERTUSER=
			"insert into user values(?,?,?,?,?,?,?,?,?,?)";
	public static final String FETCHUSERLOGIN = 
			"select userId, pass,name,role_type from user where role_type='customer' and userId = ? and pass = ?";
	public static final String FETCHADMINLOGIN = 
			"select userId, pass,name,role_type from user where role_type = 'admin' and userId = ? and pass = ?";
	
	public static final String INSERTPRODUCT = 
			"insert into product values(?,?,?,?,?)";
	public static final String FETCHALLPRODUCT=
		"select * from product";
	public static final String INSERTORDER=
		"insert into orderlist (uId,prodId,requestdate,qty) values(?,?,?,?)";
	
	
	public static final String FETCHUSER = 
			"select * from user where role_type='customer'";
//	public static final String FETCHALLORDERLIST = 
//			"select name,emailId,productName,qty,city,requestdate,rate,totalprice=(qty*rate) from orderlist o inner join user u on o.uID = u.userId inner join product p on o.productId = p.prodId";
	
	public static final String FETCHALLORDERLIST = 
			"select * from cart";
	public static final String FETCHORDER =
			"select orderID,prodId,qty,uID,requestdate from orderlist where orderId = ?";
	
	public static final String UPDATEORDER = 
			"update orderlist set qty = ? where orderId = ? and uId = ?";
	public static final String DELETEORDER = 
			"delete from orderlist where uId = ? and orderId=? ";
	public static final String VIEWORDERBYUSER = 
			"select orderId , productName , requestDate,qty, qty*productprice as total_price from orderlist inner join  product on orderlist.prodId = product.productId where uId = ?";
	
	public static final String FETCHCATEGORYID =
			"select * from product where catId = ?";
	//try something different
	public static final String FETCHCATEGORY1 = 
			"select * from product where catId = 1";
	public static final String FETCHCATEGORY2 = 
			"select * from product where catId = '3'";
	public static final String FETCHCATEGORY3 = 
			"select * from product where catId = 2";
	//
	
	public static final String FETCHCATEGORY=
			"select * from category";
	public static final String INSERTCATEGORY=
			"insert into category values(?,?)";
	//public static final ResultMapper COUNTRYMAPPER=
	public static final ResultMapper USERMAPPER=
		new ResultMapper()
	{
		public Object mapRow(ResultSet rs) throws SQLException {
		int id=	rs.getInt(1);
		String pass=rs.getString(2);
		String name = rs.getString(3);
		String roles = rs.getString(4);
//		User u = new User(id,pass);
		User u = new User();
		u.setUserId(id);
		u.setPass(pass);
		u.setName(name);
		u.setRole_type(roles);
			return u;
		}//mapRow
		
	};//Anonymous class
	
	
	
	public static final ResultMapper ORDERMAPPER=
		//public static final ResultMapper USERMAPPER=
			new ResultMapper()
		{
			public Object mapRow(ResultSet rs) throws SQLException {
			int oid = rs.getInt(1);
			int pid = rs.getInt(2);
			int qty = rs.getInt(3);
			int uid = rs.getInt(4);
			String d = rs.getString(5);
			
			Orderlist c=new Orderlist(oid,pid,qty,uid,d);
				return c;
			}//mapRow
			
		};//Anonymous class
		
		
		//display allorder list from admin end
		public static final ResultMapper ALLORDERMAPPER=
				//public static final ResultMapper USERMAPPER=
					new ResultMapper()
				{
					public Object mapRow(ResultSet rs) throws SQLException {
					String cname =	rs.getString(1);
					String email=rs.getString(2);
					String pname = rs.getString(3);
					int qty = rs.getInt(4);
					String city = rs.getString(5);
					String rdate = rs.getString(6);
					double price = rs.getDouble(7);
					double total = rs.getDouble(8);
					//return("customer Name:"+cname+", "+"Email:"+email+", "+"Product:"+pname+", "+"quantity:"+qty+", "+"City:"+city+", "+"Request date:"+rdate +","+"productprice:"+price +","+"Total amount:"+total);
					//User u = new User(cname,email,city);
					User u1= new User();
					u1.setName(cname);
					u1.setEmailId(email);
					u1.setCity(city);
					
					Product p1= new Product();
					p1.setProductName(pname);
					p1.setPrice(price);
					Orderlist ol = new Orderlist();
					ol.setUser(u1);
					ol.setProduct(p1);
					ol.setRequestdate(rdate);
					ol.setQty(qty);
					ol.setTotal(total);
					//ol.setQty(p1.getPrice());
						return ol;
					}//mapRow
					
				};//Anonymous class
				
				public static final ResultMapper PRODUCTMAPPER=
						new ResultMapper()
					{
						public Object mapRow(ResultSet rs) throws SQLException {
						int id=	rs.getInt(1);
						String name=rs.getString(2);
						int quantity = rs.getInt(3);
						double price = rs.getDouble(4);
						int catId = rs.getInt(5);
						Product p=new Product(id,name,quantity,price,catId);
							 
							return p;
							
						}//mapRow
						
					};//all product class
					
					//view order done by user
					public static final ResultMapper ORDERDONEBYUSER=
							//public static final ResultMapper USERMAPPER=
								new ResultMapper()
							{
								public Object mapRow(ResultSet rs) throws SQLException {
								int oid = rs.getInt(1);
								String pname = rs.getString(2);
								String rdate = rs.getString(3);
								int qty = rs.getInt(4);
								double total = rs.getDouble(5);
								//return(oid+"\t"+pname+"\t"+rdate+"\t"+qty+"\t\t"+total);
								Product p2= new Product();
								p2.setProductName(pname);
								Orderlist olst = new Orderlist();
								olst.setProduct(p2);
								olst.setOrderId(oid);
								olst.setTotal(total);
								olst.setRequestdate(rdate);
								olst.setQty(qty);
								return olst;
								}//mapRow
								
							};//end order done by usr
							
							
							public static final ResultMapper CATEGORYMAPPER=
									new ResultMapper()
								{
									public Object mapRow(ResultSet rs) throws SQLException {
									int id=	rs.getInt(1);
									String cname=rs.getString(2);
									
									Category c=new Category(id,cname);
										 
										return c;
										
									}//mapRow
									
								};
								
								public static final ResultMapper PRODUCTCATMAPPER=
										new ResultMapper()
									{
										public Object mapRow(ResultSet rs) throws SQLException {
										int pid=	rs.getInt(1);
										String pname=rs.getString(2);
										int quantity = rs.getInt(3);
										double price = rs.getDouble(4);
										int cid = rs.getInt(5);
										Product p = new Product(pid, pname, quantity, price, cid);
											return p;
										}//mapRow
										
									};
					
}









