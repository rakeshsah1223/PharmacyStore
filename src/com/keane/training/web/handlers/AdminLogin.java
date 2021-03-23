package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.AdminDao;
import com.keane.training.dao.UserDao;
import com.keane.training.domain.User;

public class AdminLogin  implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(Login.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int portalid = Integer.parseInt(request.getParameter("portal_id"));
		String password = request.getParameter("password");
		
		int flag = -1;
		List users = null;
//		LoginDAO dao = new LoginDAO();
//		try {
//			users = dao.validateUser(portalid);
//			log.info(users);
//			for (Object object : users) {
//
//				User user = (User) object;
//				if (user.getPassword().equals(password)) {
//					flag = 0;
//					break;
//				}
//			}
//			log.info("Flag in login " + flag);
//			if (flag == 0) {
//				RequestDispatcher dispatcher = request
//						.getRequestDispatcher("home.jsp");
//				request.setAttribute("Name", portalid);
//				dispatcher.forward(request, response);
//
//			} else {
//				RequestDispatcher dispatcher = request
//						.getRequestDispatcher("Login.jsp");
//				request.setAttribute("Err",
//						"username are password is incorrect");
//				dispatcher.forward(request, response);
//			}
//
//		} catch (DAOAppException e) {
//			RequestDispatcher dispatcher = request
//					.getRequestDispatcher("error.jsp");
//			request.setAttribute("Err", e.getMessage());
//			dispatcher.forward(request, response);
//
//		}
		
		//new code
		//boolean users ;
		User user = new User();
		AdminDao dao = new AdminDao();
		try {
			users = AdminDao.adminLogin(portalid,password);
			log.info(users);
			for (Object object : users) {

				 user = (User) object;
				if (user.getUserId()==portalid && user.getPass().equals(password)) {
					flag = 0;
					break;
				}
			}
			String name = null;
			for (Object object : users) {

				 user = (User) object;
				 name=user.getName();
				
			}
			log.info("Flag in login " + flag);
			HttpSession httpsession = request.getSession();
			
			if (flag == 0) {
				
//				RequestDispatcher dispatcher = request
//						.getRequestDispatcher("home.jsp");
//				request.setAttribute("Name", portalid);
//				request.setAttribute("password", password);
//				dispatcher.forward(request, response);
				//session
				
				httpsession.setAttribute("admin", user);
				//System.out.println("wel:"+ user.getPass());
				response.sendRedirect("admin.jsp");
				//admin
//				if(user.getRole_type().equals("admin")) {
//					response.sendRedirect("admin.jsp");
//				}
//				else if(user.getRole_type().equals("customer")) {
//					response.sendRedirect("normal.jsp");
//				}else {
//					out.print("no role type");
//				}
				//user

			} else {
				out.println("<h1>invalid details</h1>");
				httpsession.setAttribute("message","invalid user id or password");
				response.sendRedirect("adminlogin.jsp");
				return;
				//System.out.println("incorrect u and p");
//				RequestDispatcher dispatcher = request
//						.getRequestDispatcher("Login.jsp");
//				request.setAttribute("Err",
//						"username are password is incorrect");
//				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);

		}
		

	}
}

