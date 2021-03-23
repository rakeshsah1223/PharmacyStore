<%@page import="com.keane.training.domain.User"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.keane.training.domain.Orderlist"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Medical Store</title>
<%@include file="assets/common_css_js.jsp" %>
</head>
<body>
<%
 HttpSession httpSession = request.getSession();
User user4 = (User)session.getAttribute("current-user");%>

<% 
if(user4!=null){%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<div class="container">

  <a class="navbar-brand" href="normal.jsp">Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div><ul class="navbar-nav ml-auto">
  
  <li class="nav-item active ml-5 ">
        <a class="nav-link" href="#!"><%= user4.getName() %> </a>
   </li>
  <li class="nav-item active ">
        <a class="nav-link" href="logout.do">Logout</a>
      </li>
      </ul></div>
</div></nav>
 <div class="container">
 	<h2 class="mt-5"align="center"><img src="assets/images/cart.png" width=50px>Order List</h2><br><br>
 	<table class="table table-dark mt-auto">
 	 <thead>
 	 	<tr>
 	 		<th>OrderID</th>
 	 		<th>Request Date</th>
 	 		<th>Product name</th>
 	 		<th>Quantity</th>
 	 		<th>Total Price</th>
 	 		<th><img src="assets/images/delete.png" width=20px height=20px></th>
 	 		<th><img src="assets/images/edit.png" width=20px height=20px></th>
 	 	</tr>
 	 	
 	  </thead>
 	  <tbody>
 	  	<%
 	  	List<Orderlist> o1 =(List) request.getAttribute("vieword");
 	  	
 	  	%>
 	  	<%
 	  	
 	  	 Iterator<Orderlist> itr = o1.iterator();
 	  	while(itr.hasNext()){
 	  		Orderlist ol = itr.next();
 	  	%>
 	  		
 	  		<tr>
 	  		<td><%=ol.getOrderId() %></td>
 	  		<td><%=ol.getRequestdate() %></td>
 	  		<td><%=ol.getProduct().getProductName()%></td>
 	  		<td><%=ol.getQty() %></td>
 	  		<td><%=ol.getTotal() %></td>
 	  		<td><a href="removeitem.do?oid=<%= ol.getOrderId() %>& action=removenow" class="text-white">Remove</a></td>
 	  		
 	  		<td><a href="edit.jsp" class="text-white">Edit</a></td>
 	  		</tr>
 	  	<% 
 	  	}
 	  	%>
 	  </tbody>
 	</table>
 </div>
 
 
 
 
 
 
</body>


<%}else{ 

	session.setAttribute("message", "you are not logged in");
	response.sendRedirect("Login.jsp");
	return;
} %>


</html>
