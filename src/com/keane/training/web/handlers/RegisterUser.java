package com.keane.training.web.handlers;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
//import com.keane.training.dao.RegisterDAO;
import com.keane.training.dao.UserDao;
import com.keane.training.domain.User;

public class RegisterUser implements HttpRequestHandler {
	static Logger log = Logger.getLogger(RegisterUser.class);

	
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		RegisterDAO dao = new RegisterDAO();
//		User user = new User();
//		user.setPortalID(Integer.parseInt(request.getParameter("portal_id")));
//		user.setName(request.getParameter("name"));
//		user.setEmployeeId(Integer.parseInt(request.getParameter("emp_id")));
//		user.setTechnology(request.getParameter("tech"));
//		user.setPassword(request.getParameter("password"));
//        user.setRole("user");
//		boolean isExists;
//		try {
//			isExists = dao.validateUser(user.getPortalID());
//
//			if (isExists) {
//				log.info("User already registered");
//				RequestDispatcher dispatcher = request
//						.getRequestDispatcher("..\\pages\\Register.jsp");
//				request.setAttribute("Err","User already registered with the system");
//				dispatcher.forward(request, response);
//			} else {
//				user.setPassword("NttData@"
//						+ Integer.toString(user.getPortalID()));
//				int finalRes = dao.registerUser(user);
//				if (finalRes > 0) {
//
//					RequestDispatcher dispatcher = request
//							.getRequestDispatcher("..\\pages\\success.jsp");
//					request.setAttribute("success",
//							"User succesfully registered with the system");
//					request.setAttribute("details", user);
//					dispatcher.forward(request, response);
//				}
//			}
//		} catch (DAOAppException e) {
//			RequestDispatcher dispatcher = request
//					.getRequestDispatcher("error.jsp");
//			request.setAttribute("Err", e.getMessage());
//			dispatcher.forward(request, response);
//		}
		
		User user = new User();
		UserDao userdao = new UserDao();
		user.setUserId(Integer.parseInt(request.getParameter("userId")));
		user.setPass(request.getParameter("password"));
		user.setEmailId(request.getParameter("emailId"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setContact(Long.parseLong(request.getParameter("contact")));
		user.setCity(request.getParameter("city"));
		user.setState(request.getParameter("state"));
		user.setPincode(Integer.parseInt(request.getParameter("pincode")));
		user.setRole_type(request.getParameter("role_type"));
		user.setName(request.getParameter("name"));
		
		
		HttpSession httpsession = request.getSession();
		try {
			int finalRes = userdao.insertUser(user);
			if (finalRes > 0) {
				
				httpsession.setAttribute("message","invalid user id or password");
				//response.sendRedirect("Login.jsp");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("..\\pages\\index.jsp");
				request.setAttribute("success",
						"User succesfully registered with the system");
				request.setAttribute("details", user);
				dispatcher.forward(request, response);
			}
		}catch(Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

}
