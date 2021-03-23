package com.keane.training.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;

public class AdminDao {
	static Logger log=Logger.getLogger(AdminDao.class);
	public static List adminLogin(final int userId, final String pass) {
		ConnectionHolder ch = null;
		Connection con = null;
		List adminlogin = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			final ParamMapper USERMAPPER = new ParamMapper() {
				
				//@Override
				public void mapParam(PreparedStatement preStmt) throws SQLException {
					// TODO Auto-generated method stub
					preStmt.setInt(1, userId);
					preStmt.setString(2, pass);
				}
			};
			adminlogin = DBHelper.executeSelect
					(con, SQLMapper.FETCHADMINLOGIN, SQLMapper.USERMAPPER, USERMAPPER);
		}catch(DBConnectionException e) {
			System.out.println(e);
		}
		return adminlogin;
//		if(adminlogin.isEmpty()) {
//			return false;
//		}
//		else {
//			return true;
//		}
	}
}
