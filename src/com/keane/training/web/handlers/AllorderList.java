package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;

public class AllorderList implements HttpRequestHandler{

	public static Logger log = Logger.getLogger(AllorderList.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
	}
}