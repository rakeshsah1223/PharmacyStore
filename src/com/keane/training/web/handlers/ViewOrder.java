package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.OrderlistDao;
import com.keane.training.domain.Orderlist;
import com.keane.training.domain.User;

public class ViewOrder implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(ViewOrder.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("current-user");
		int uid = user.getUserId();
		//List orderlist = OrderlistDao.viewOrderByUser(uid);
//		Iterator<Orderlist> iterator = orderlist.iterator();
		//System.out.println(uid);
		
		try {
			List orderlist1 = OrderlistDao.viewOrderByUser(uid);
			//Iterator<Orderlist> iterator = orderlist.iterator();
			request.setAttribute("vieword", orderlist1);
			request.getRequestDispatcher("vieworders.jsp").forward(request, response);
//			httpSession.setAttribute("vieword", orderlist1);
//			response.sendRedirect("vieworders.jsp");
		}catch(Exception e){
			System.out.println(e);
		}
//		if(user==null) {
//			httpSession.setAttribute("message", "Login first");
//			response.sendRedirect("Login.jsp");
//			return;
//		}else {
//			out.println("<table border=1 width=50% height=50%>");  
//            out.println("<tr><th>Order Id</th><th>Request date</th><th>Quantity</th><tr>"); 
//		while(iterator.hasNext()) {
//			Orderlist ol = iterator.next();
//			//System.out.println(ol.getProdId());
//			
//			
//			out.println("<tr><td>" + ol.getOrderId() + "</td><td>" + ol.getRequestdate() + "</td><td>" + ol.getQty() + "</td></tr>");
//			
//		}
//		out.println("</table>");  
//        out.println("</html></body>");
//		/*
//		 * 
//		 *   
//               
//                 out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");   
//             }  
//              
//		 */
//		}
		
	}
}