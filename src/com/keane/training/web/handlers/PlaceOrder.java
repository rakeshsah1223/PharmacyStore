package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.OrderlistDao;
import com.keane.training.domain.Orderlist;
import com.keane.training.domain.Product;
import com.keane.training.domain.User;

public class PlaceOrder implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(PlaceOrder.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		int pid=Integer.parseInt(id);
		ArrayList<String> cartlist = new ArrayList<String>();
		ArrayList<User> userList = new ArrayList<User>();
		HttpSession session;
		String action= (request.getParameter("action"));
		
		
		HttpSession httpSession = request.getSession();
		LocalDate curdate = LocalDate.now();
		String cdate=curdate.toString();
		
		
		User user = (User)httpSession.getAttribute("current-user");
		
		int uid=user.getUserId();
		OrderlistDao odao = new OrderlistDao();
		Orderlist o = new Orderlist();
		if(user!=null) 
		o.setuId(uid);
		o.setProdId(pid);
		o.setQty(1);
		o.setRequestdate(cdate);
		int res=odao.insertOrder(o);
		 httpSession = request.getSession();
		httpSession.setAttribute("message", "Order Placed Successfully!");
		response.sendRedirect("normal.jsp");
		
		return;
		
		//Product p = new Product();
//		if(action.equals("ordernow")) {
//			if(httpSession.getAttribute("cart")==null) {
//				
//			}else {
//				
//			}
//		}
		
		
	}
}