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
import com.keane.training.domain.Category;
import com.keane.training.domain.Product;

public class CategoryDao {
	static Logger log=Logger.getLogger(CategoryDao.class);
	
	
	public static int insertCategory(final Category p)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper INSERTPCATEGORY=new ParamMapper()
			{

				
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setInt(1, p.getCategoryId());
					preStmt.setString(2, p.getCategoryName());
					
				}
				
			};
			
		result=DBHelper.executeUpdate(con,SQLMapper.INSERTCATEGORY,INSERTPCATEGORY);
			
			
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}//insert
	
	
	//list all the category
			public static List getCategories() throws DBFWException, CountryDAOException, DBConnectionException
			{
				List category=null;
				ConnectionHolder ch=null;
				Connection con=null;
				try {
					ch=ConnectionHolder.getInstance();
					con=ch.getConnection();
					
					log.debug("fetchig");
					category=DBHelper.executeSelect(con,SQLMapper.FETCHCATEGORY,SQLMapper.CATEGORYMAPPER);
							
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
				
				
				return category;
				
			}//
			
			//end all product
			
}
