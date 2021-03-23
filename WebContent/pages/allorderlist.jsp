<%@page import="com.keane.training.dao.OrderlistDao"%>
<%@page import="com.keane.training.domain.Orderlist"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Medical Store</title>
<%@include file="assets/common_css_js.jsp" %>

<%@page import="java.util.List"%>    
  <%--Importing all the dependent classes--%>
  <%@page import="java.util.Iterator"%>
  <%@ include file="assets/common_css_js.jsp" %>
</head>
<body>


<%
User user3 = (User)session.getAttribute("admin");

%>
<% if(user3!=null){ %>

<%@ include file="navbar.jsp" %>
<div class="container">
  <div class="alert alert-info mt-3">
  <strong>OrderList</strong> Displaying All Order of Customer
</div>
             
  <table class="table table-dark mt-3">
    <thead>
      <tr>
        <th>Name</th>
        <th>Email Id</th>
        <th>Product Name</th>
        <th>Quantity</th>
        <th>City</th>
        <th>Request date</th>
        <th>Product price</th>
        <th>Total Price</th>
        
      </tr>
    </thead>
    <tbody>
    <% List orderList =  OrderlistDao.getAllOrderDetails(); %>
<%
// Iterating through subjectList



	Iterator<Orderlist> iterator = orderList.iterator();  // Iterator interface
	
	while(iterator.hasNext())  // iterate through all the data until the last record
	{
		Orderlist ol = iterator.next(); //a
	%>
	<tr><td><%=ol.getUser().getName()%></td>
		<td><%=ol.getUser().getEmailId()%></td>
		<td><%=ol.getProduct().getProductName()%></td>
		<td><%=ol.getQty()%></td>
		<td><%=ol.getUser().getCity()%></td>
		<td><%=ol.getRequestdate()%></td>
		<td><%=ol.getProduct().getPrice()%></td>
		<td><%=ol.getTotal()%></td>
	</tr>
	<%
	}

%>
    </tbody>
  </table>
</div>
<div class="mt-5"></div>
</body>
<%@include file="footer.jsp" %>>

<%}else{ %>
<ul>
 <li class="nav-item active">
        <a class="nav-link" href="adminlogin.jsp">Admin Login </a>
      </li></ul>
      <%} %>
</html>