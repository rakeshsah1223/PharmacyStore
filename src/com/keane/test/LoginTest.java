package com.keane.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.UserDao;
import com.keane.training.domain.User;

public class LoginTest {

	static Connection con=null;
	static String url="jdbc:mysql://localhost:3306/pharmacy";
	@BeforeClass
	public static void init()
	{
	 try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,"root","rakesh123");
		System.out.println(con);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	UserDao dao=new UserDao();
	@org.junit.Test
	public void Test()
	{
		
		try {
			assertEquals("list size is checked", 5, dao.getUserDetails().size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Ignore
	@Test
	public void loginUser() {
		assertEquals("check login user", true, dao.userLogin(1003, "2603"));
	}
}
