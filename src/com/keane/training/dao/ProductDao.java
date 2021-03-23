package com.keane.training.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.Product;

public class ProductDao {
	static Logger log=Logger.getLogger(ProductDao.class);
	
	//insert
		public static int insertProduct(final Product p)
		{
			ConnectionHolder ch=null;
			Connection con=null;
			int result=0;
			
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				final ParamMapper INSERTPPRODUCT=new ParamMapper()
				{

					
					public void mapParam(PreparedStatement preStmt)
							throws SQLException {
						preStmt.setInt(1, p.getProductId());
						preStmt.setString(2, p.getProductName());
						preStmt.setInt(3,p.getQuantity());
						preStmt.setDouble(4, p.getPrice());
						preStmt.setInt(5, p.getCatId());
					}
					
				};
				
			result=DBHelper.executeUpdate(con,SQLMapper.INSERTPRODUCT,INSERTPPRODUCT);
				
				
			} catch (DBFWException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DBConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			
			
		}//insert
		
		
		//list all the product by user
		public static List getAllProduct() throws DBFWException, CountryDAOException, DBConnectionException
		{
			List products=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				log.debug("fetchig");
				products=DBHelper.executeSelect(con,SQLMapper.FETCHALLPRODUCT,SQLMapper.PRODUCTMAPPER);
						
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
			
			
			return products;
			
		}//
		
		//end all product
		
		
		
		
		
		
		
		
		
		//trying something different
		public static List getCategory1() throws DBFWException, CountryDAOException, DBConnectionException
		{
			List products=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				log.debug("fetchig");
				products=DBHelper.executeSelect(con,SQLMapper.FETCHCATEGORY1,SQLMapper.PRODUCTMAPPER);
						
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
			
			
			return products;
			
		}//
		//end category1
		
		public static List getCategory2() throws DBFWException, CountryDAOException, DBConnectionException
		{
			List products=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				log.debug("fetchig");
				products=DBHelper.executeSelect(con,SQLMapper.FETCHCATEGORY2,SQLMapper.PRODUCTMAPPER);
						
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
			return products;
		}
			//end category 2
		
		//start category 3
		public static List getCategory3() throws DBFWException, CountryDAOException, DBConnectionException
		{
			List products=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				log.debug("fetchig");
				products=DBHelper.executeSelect(con,SQLMapper.FETCHCATEGORY3,SQLMapper.PRODUCTMAPPER);
						
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
			return products;
		}
		//end category 3
		
		//get product by category id
		public static List getProductsByCategoryId(final int catId) {
			ConnectionHolder ch = null;
			Connection con = null;
			List pcat = null;
			try {
				ch = ConnectionHolder.getInstance();
				con = ch.getConnection();
				final ParamMapper PRODUCTCATMAPPER = new ParamMapper() {
					
					
					public void mapParam(PreparedStatement preStmt) throws SQLException {
						// TODO Auto-generated method stub
						preStmt.setInt(1, catId);
						
					}
				};
				pcat = DBHelper.executeSelect
						(con, SQLMapper.FETCHCATEGORYID, SQLMapper.PRODUCTCATMAPPER, PRODUCTCATMAPPER);
			}catch(DBConnectionException e) {
				System.out.println(e);
			}
			return pcat;
    }
		//end of product by categoryId
}
















