<%@page import="com.keane.training.dao.OrderlistDao"%>
<%@page import="com.keane.training.domain.Orderlist"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="assets/common_css_js.jsp" %>
<title>My Medical Store</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<table class="table table-dark mt-3">
  <thead>
    <tr>
      <th >OrderId</th>
      <th >User Id</th>
      <th >Product Id</th>
      <th >Quantity</th>
       <th>Requested date</th>
    </tr>
  </thead><tbody>
<%



	//Orderlist orderlist = new Orderlist();
List<Orderlist> olist =(List) request.getAttribute("search");
	
	
%>



<%

			 for(Orderlist orderlist:olist)
			 {
			 %>	
			 
			     <tr>
			     	<td><%=orderlist.getOrderId()%></td>
				 	<td><%=orderlist.getuId() %></td>
				 	<td><%=orderlist.getProdId() %></td>
				 	<td><%=orderlist.getQty() %></td>
				 	<td><%=orderlist.getRequestdate() %></td>
				</tr> 	
			<% 
			 }

			%>
</tbody>
</table>
</body>
</html>