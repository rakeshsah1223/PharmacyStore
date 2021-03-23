package com.keane.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.keane.training.dao.CountryDAOException;
import com.keane.training.dao.ProductDao;
import com.keane.training.domain.Product;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;

public class ProductTest {
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
	
	ProductDao pdao = new ProductDao();
	@org.junit.Test
	public void listProduct()
	{
		try {
			try {
				assertEquals(9, pdao.getAllProduct().size());
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
	
	@Test
	public void addProduct() {
		Product p = new Product(102,"Horlicks", 20, 105, 2);
		int res = ProductDao.insertProduct(p);
		assertEquals(1, res);
	}

}
