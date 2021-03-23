package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.CategoryDao;
import com.keane.training.dao.ProductDao;
import com.keane.training.domain.Category;
import com.keane.training.domain.Product;

public class ProductOperation implements HttpRequestHandler{

	public static Logger log = Logger.getLogger(ProductOperation.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String op = request.getParameter("operation");
		if(op.trim().equals("addproduct")) {
			
			int productId = Integer.parseInt(request.getParameter("productId"));
			String productName = request.getParameter("productName");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			double productprice = Double.parseDouble(request.getParameter("productprice")); 
			int catId = Integer.parseInt(request.getParameter("catId"));
			
			Product product = new Product();
			product.setProductId(productId);
			product.setProductName(productName);
			product.setQuantity(quantity);
			product.setPrice(productprice);
			product.setCatId(catId);
			
			int result = ProductDao.insertProduct(product);
			//out.println("Product saved");
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message", "Product Successfully added!");
			response.sendRedirect("admin.jsp");
			return;
			
		}
		else if(op.trim().equals("addcategory")) {
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			String categoryName = request.getParameter("categoryName");
			
			Category category = new Category();
			category.setCategoryId(categoryId);
			category.setCategoryName(categoryName);
			
			int res = CategoryDao.insertCategory(category);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message", "Category Added Successfully");
			response.sendRedirect("admin.jsp");
			return;
		}
	}
}