package com.keane.test;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.BeforeClass;

import com.keane.training.dao.CategoryDao;
import com.keane.training.dao.CountryDAOException;
import com.keane.training.dao.ProductDao;

import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;

public class CategoryTest {
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
	
	CategoryDao cdao = new CategoryDao();
	@org.junit.Test
	public void listProductCategory()
	{
		try {
			try {
				assertEquals(4, cdao.getCategories().size());
			} catch (CountryDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DBConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (DBFWException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

