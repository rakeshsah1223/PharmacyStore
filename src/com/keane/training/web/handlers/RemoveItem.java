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
import com.keane.training.domain.Product;
import com.keane.training.domain.User;

public class RemoveItem  implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(RemoveItem.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("oid"));
		HttpSession session;
		String action= (request.getParameter("action"));
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("current-user");
		OrderlistDao odao = new OrderlistDao();
		//Product p1  =  new Product();
//		p1.setProductName(id);
		Orderlist orderlist = new Orderlist();
		orderlist.setuId(user.getUserId());
		orderlist.setOrderId(id);
		//orderlist.setProduct(p1);
		int res = odao.deleteOrder(orderlist);
		response.sendRedirect("vieworder.do");
		return;
		}
}