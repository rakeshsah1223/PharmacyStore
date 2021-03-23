package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;

public class AdminLogout implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(AdminLogout.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession httpSession = request.getSession();
		httpSession.removeAttribute("admin");
		response.sendRedirect("adminlogin.jsp");
	}
}