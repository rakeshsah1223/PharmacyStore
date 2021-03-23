
<%@page import="com.keane.training.domain.Category"%>
<%@page import="com.keane.training.dao.CategoryDao"%>
<%@page import="com.keane.training.domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.keane.training.dao.ProductDao"%>
<%@page import="com.keane.training.domain.User"%>
<%

    User user = (User)session.getAttribute("current-user");
	if(user==null){
		session.setAttribute("message", "you are not logged in");
		response.sendRedirect("Login.jsp");
		return;
	}else{
		
	}
%>


<%
User user2 = (User)session.getAttribute("current-user");

%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Medical Store</title>
<%@ include file="assets/common_css_js.jsp" %>

</head>
<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<div class="container">

  <a class="navbar-brand" href="normal.jsp">Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="normal.jsp">Home <span class="sr-only"></span></a>
      </li>
      
     <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Category
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Personal Care</a>
          <a class="dropdown-item" href="#">Nutrition</a>
         
          <a class="dropdown-item" href="#">Health Care</a>
        </div>
      </li>
    </ul></div>
    <div>
    <ul class="navbar-nav ml-auto">
    
      	<%
      		if(user2==null)
      		{
      			%>
      			 <li class="nav-item active">
        <a class="nav-link" href="adminlogin.jsp">Admin Login </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="Login.jsp">Login </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="Register.jsp">Register</a>
      </li>
      			
      			<%	
      		}
      		else{
      			%>
      			
      <li class="nav-item active">
       <a class="nav-link" href="vieworder.do">Check Order</a>
      </li>
      <li class="nav-item active ml-5 ">
        <a class="nav-link" href="#!"><%= user2.getName() %> </a>
      </li>
      <li class="nav-item active ml-5">
        <a class="nav-link" href="logout.do">Logout</a>
      </li>
      			<% 
      		}
      	
      	%>
      	
      	
    </ul>
  </div>
  </div>
</nav>

<!-- this is for displaying the category and product to the customer -->
 <div class="container-fluid">
 <%@ include file="assets/message.jsp" %>
 
	<div class="row mt-3 mx-2">
		<%
		  String cat = request.getParameter("category");
		 //out.println(cat);
		  ProductDao pdao =  new ProductDao();
		  List<Product> list = null;
		  if(cat==null || cat.trim().equals("all")){
			  list = pdao.getAllProduct();
		  }
		  else{
			 int cid= Integer.parseInt(cat.trim());
			  list=pdao.getProductsByCategoryId(cid);
		  }
		 
		 CategoryDao cdao = new CategoryDao();
		 List<Category> clist = cdao.getCategories();
		
		%>
		<!-- show category -->
		<div class="col-md-2">
		
			<div class="list-group mt-4">
				<a href="normal.jsp?category=all" class="list-group-item list-group-item-action active">
				All Product
				</a>
			
			
			<%
			 for(Category category:clist)
			 {
			 %>	
			 
				 	<a href="normal.jsp?category=<%= category.getCategoryId() %>"class="list-group-item list-group-item-action"><%=category.getCategoryName() %></a>
			<% 
			 }
			%>
			</div>
		</div>
		
		
		<!-- show product -->
		<div class="col-md-8">
			
			<div class="row mt-4">
				<div class="col-md-12">
				<div class="card-columns">
				
				<%
				
				for(Product product:list)
				 {
				%>
				 
				 <div class="card product-card mt-1">
				  <img alt="" src="assets/images/logo.svg" width="50px" height="50px" >
				 	<div class="card-body">
				 		<h5 class="card-title"><%=product.getProductName() %></h5>
				 		
				 		
				 	</div>
				 	<div class="footer">
				 	<button class="btn btn-success"> <a href="placeorder.do?id=<%= product.getProductId()%>& action=ordernow" class="text-white">Buy Now</a></button>
				 	<button class="btn btn-outline-primary"> &#8377;<%=product.getPrice()%>/-</button>
				 	</div>
				 </div>
				 
				<%
				} 
				
				if(list.size()==0){
					out.println("<h3>No item in this category</h3>");
				}
				%>
				</div>
					
				</div>
			
			</div>
			
		</div>
	</div>
	</div>
	
	<div class="mt-3"></div>
</body>
<%@include file="footer.jsp" %>
</html>