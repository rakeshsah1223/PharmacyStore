package com.keane.training.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.dbfw.ResultMapper;
import com.keane.training.domain.Orderlist;
import com.keane.training.domain.Product;
import com.keane.training.domain.User;

public class OrderlistDao {
static Logger log=Logger.getLogger(OrderlistDao.class);
	
	public static List getAllOrderDetails() throws DBFWException, CountryDAOException, DBConnectionException
	{
		List allorderdetails=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			log.debug("fetchig");
			allorderdetails=DBHelper.executeSelect(con,SQLMapper.FETCHALLORDERLIST,SQLMapper.ALLORDERMAPPER);
					
		} catch (DBConnectionException e) {
			throw new DBConnectionException("Unable to connect to db"+e);
		
		}
		finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}
		
		
		return allorderdetails;
		
	}// get all the order list 
	
	public static List getOrder(final int orderId)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		List order=null;
		
		try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
			final ParamMapper ORDERPMAPPER=new ParamMapper()
			{

				public void mapParam(PreparedStatement preStmt) throws SQLException {
				preStmt.setInt(1,orderId);
									
				}
				
			};//ananymous class
			
		order=DBHelper.executeSelect
		(con,SQLMapper.FETCHORDER,SQLMapper.ORDERMAPPER, ORDERPMAPPER );		
	
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
		
	}//getorder by search
	
	
	//inserting order
	//insert
		public static int insertOrder(final Orderlist c)
		{
			ConnectionHolder ch=null;
			Connection con=null;
			int result=0;
			
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				final ParamMapper INSERTPORDER=new ParamMapper()
				{

					
					public void mapParam(PreparedStatement preStmt)
							throws SQLException {
						//preStmt.setInt(1, c.getOrderId());
						preStmt.setInt(1,c.getuId());
						preStmt.setInt(2, c.getProdId());
						preStmt.setString(3, c.getRequestdate());
						preStmt.setInt(4,c.getQty());
						
					}
					
				};
				
			result=DBHelper.executeUpdate(con,SQLMapper.INSERTORDER,INSERTPORDER);
				
				
			} catch (DBFWException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DBConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			
			
		}//insertion done
		
		
		//update order list by customer ends
		
		public static int updateOrder(final Orderlist ol)
		{
			ConnectionHolder ch=null;
			Connection con=null;
			int updateord=0;
			
			try {
					ch=ConnectionHolder.getInstance();
					con=ch.getConnection();
				final ParamMapper UPDATEPMAPPER=new ParamMapper()
				{

					public void mapParam(PreparedStatement preStmt) throws SQLException {
						
					preStmt.setInt(1,ol.getQty());
					preStmt.setInt(2,ol.getOrderId());
					preStmt.setInt(3,ol.getuId());
					}
					
				};//ananymous class
				
				try {
					updateord=DBHelper.executeUpdate
(con,SQLMapper.UPDATEORDER, UPDATEPMAPPER );
				} catch (DBFWException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		
			} catch (DBConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return updateord;
			
		}
		
		//end update order
		
		//start delete order
		
		public static int deleteOrder(final Orderlist c)
		{
			ConnectionHolder ch=null;
			Connection con=null;
			int result=0;
			
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				final ParamMapper DELETEPORDER=new ParamMapper()
				{

					
					public void mapParam(PreparedStatement preStmt)
							throws SQLException {
						//preStmt.setInt(1, c.getOrderId());
						//preStmt.setInt(1, c.getProductId());
						preStmt.setInt(1,c.getuId());
						preStmt.setInt(2, c.getOrderId());
					
					}
					
				};
				
			result=DBHelper.executeUpdate(con,SQLMapper.DELETEORDER,DELETEPORDER);
				
				
			} catch (DBFWException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DBConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			
			
		}
		
		//end delete order
		
		//get the order detail by user to user
		public static List viewOrderByUser(final int uID)
		{
			ConnectionHolder ch=null;
			Connection con=null;
			List vieworder=null;
			
			try {
					ch=ConnectionHolder.getInstance();
					con=ch.getConnection();
				final ParamMapper VIEWORDERPMAPPER=new ParamMapper()
				{

					public void mapParam(PreparedStatement preStmt) throws SQLException {
					preStmt.setInt(1,uID);
										
					}
					
				};//ananymous class
				
			vieworder=DBHelper.executeSelect
			(con,SQLMapper.VIEWORDERBYUSER,SQLMapper.ORDERDONEBYUSER, VIEWORDERPMAPPER );		
		
			} catch (DBConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return vieworder;
			
		}
		//end the order details view
		
		
}
