package com.keane.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.training.dao.OrderlistDao;

public class OrderListTest {
	
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
			
			OrderlistDao orderlistdao = new OrderlistDao();
			@Ignore
			@Test
			public void checkAllOrderDetails() {
				try {
					assertEquals(13,orderlistdao.getAllOrderDetails().size());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
