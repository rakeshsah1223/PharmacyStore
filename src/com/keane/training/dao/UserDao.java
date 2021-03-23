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

import com.keane.training.domain.User;

public class UserDao {
	static Logger log=Logger.getLogger(UserDao.class);
	
	public static List getUserDetails() throws DBFWException, CountryDAOException, DBConnectionException
	{
		List userdetails=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			log.debug("fetchig");
			userdetails=DBHelper.executeSelect(con,SQLMapper.FETCHUSER,SQLMapper.USERMAPPER);
					
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
		
		
		return userdetails;
		
	}// get the user details
	
	//login of user
	public static List userLogin(final int userId, final String pass) {
		ConnectionHolder ch = null;
		Connection con = null;
		List login = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			final ParamMapper USERMAPPER = new ParamMapper() {
				
				
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					// TODO Auto-generated method stub
					preStmt.setInt(1, userId);
					preStmt.setString(2, pass);
				}
			};
			login = DBHelper.executeSelect
					(con, SQLMapper.FETCHUSERLOGIN, SQLMapper.USERMAPPER, USERMAPPER);
		}catch(DBConnectionException e) {
			System.out.println(e);
		}
		return login;
//		if(login.isEmpty()) {
//			return false;
//		}
//		else {
//			return true;
//		}
	}
	//end of login user
	
	
	//insert users details in registration fields
		public static int insertUser(final User c)
		{
			ConnectionHolder ch=null;
			Connection con=null;
			int result=0;
			
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				final ParamMapper INSERTPUSER=new ParamMapper()
				{

					
					public void mapParam(PreparedStatement preStmt)
							throws SQLException {
						preStmt.setInt(1, c.getUserId());
						preStmt.setString(2, c.getPass());
						preStmt.setString(3, c.getEmailId());
						preStmt.setInt(4, c.getAge());
						preStmt.setLong(5, c.getContact());
						preStmt.setString(6, c.getCity());
						preStmt.setString(7, c.getState());
						preStmt.setInt(8, c.getPincode());
						preStmt.setString(9, c.getRole_type());
						preStmt.setString(10, c.getName());
						
					}
					
				};
				
			result=DBHelper.executeUpdate(con,SQLMapper.INSERTUSER,INSERTPUSER);
				
				
			} catch (DBFWException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DBConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			
			
		}//insert
}
