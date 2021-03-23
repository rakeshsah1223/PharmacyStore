package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.OrderlistDao;
import com.keane.training.domain.Orderlist;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

public class SearchOrderById  implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(SearchOrderById.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		
		//Orderlist orderlist = new Orderlist();
		List<Orderlist> olist = null;
		OrderlistDao odao = new OrderlistDao();
		olist= odao.getOrder(orderId);
		
		request.setAttribute("search",olist );
//		for(Orderlist orderlist:olist) {
//			System.out.println(orderlist.getRequestdate());
//		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchById.jsp");
		dispatcher.forward(request, response);
		
	}
}
