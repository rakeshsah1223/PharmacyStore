package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.OrderlistDao;
import com.keane.training.domain.Orderlist;
import com.keane.training.domain.User;

public class EditItem implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(EditItem.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("oid1"));
		int qty =  Integer.parseInt(request.getParameter("qty"));
		HttpSession session;
		String action= (request.getParameter("action"));
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("current-user");
		OrderlistDao odao = new OrderlistDao();
		Orderlist ol1 = new Orderlist();
		
		ol1.setuId(user.getUserId());
		ol1.setOrderId(id);
		ol1.setQty(qty);
		System.out.println(qty);
		System.out.println(id);
		int res=odao.updateOrder(ol1);
		response.sendRedirect("vieworder.do");
		return;
	}
}
