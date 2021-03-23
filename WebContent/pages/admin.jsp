
<%@page import="com.keane.training.domain.Orderlist"%>
<%@page import="com.keane.training.dao.OrderlistDao"%>
<%@page import="com.keane.training.dao.UserDao"%>
<%@page import="com.keane.training.domain.Product"%>
<%@page import="com.keane.training.dao.ProductDao"%>
<%@page import="com.keane.training.domain.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.keane.training.dao.CategoryDao"%>
<%@page import="com.keane.training.domain.User"%>
<%

    User user = (User)session.getAttribute("admin");
	if(user==null){
		session.setAttribute("message", "you are not logged in");
		response.sendRedirect("adminlogin.jsp");
		return;
	}else{
		
	}
%>









<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin panel</title>
<%@ include file="assets/common_css_js.jsp" %>

</head>
<body>
<%@ include file="navbar.jsp" %>


        <% 
 			ProductDao pdao =  new ProductDao();
 			
 			 List<Product> list1 = null;
 			
 			list1 = pdao.getAllProduct();
 						
 			
  			%>
  			
  			<%
  			  UserDao udao = new UserDao();
  			List<User> l2 = null;
  			l2 = udao.getUserDetails();
  			
  			%>
		 <%
  			  OrderlistDao od = new OrderlistDao();
  			List<Orderlist> l3 = null;
  			l3= od.getAllOrderDetails();
  			
  			%>

 	<div class="container admin">
 	
 		<div class="container-fluid mt-3">
 			<%@ include file="assets/message.jsp" %>
 		</div>
 		<div class="row mt-3">
 		
 		
 			<div class="col-md-4">
 				<div class="card">
 					<div class="card-body text-center">
 						<div class="container">
 						<img style="max-width:125px;" class="img-fluid rounded-circle"alt="user" src="assets/images/team.png">
 						</div>
 					 <h1 class="text-muted">Users</h1>
 					 <h1><%=l2.size() %></h1>
 					</div>
 				</div>
 			</div>
 			
 			
 			
				
				
				
 			<div class="col-md-4">
 				<div class="card">
 					<div class="card-body text-center">
 					
 						<div class="container">
 						<img style="max-width:150px;" class="img-fluid rounded-circle"alt="user" src="assets/images/image3.jpg">
 						</div>
 					 
 					 <h1 class="text-muted">Product</h1>
 					 <h1><%=list1.size() %></h1>
 					</div>
 				</div>
 			</div>
 			
 			
 			
 			
 			<div class="col-md-4">
 				<div class="card">
 					<div class="card-body text-center">
 					<div class="container">
 					<a href="allorderlist.jsp">
 						<img style="max-width:125px;" class="img-fluid rounded-circle"alt="user" src="assets/images/team.png">
 						</div> </a>
 					 <h1 class="text-muted">All orderList</h1>
 					 <h1><%=l3.size()%></h1>
 					</div>
 				</div>
 			</div>
 			
 			
 			
 		</div>
 		<!--  second row-->
 		
 		
 		
 		
 		<div class="row mt-3">
 		
 		<!-- add category -->
 		<div col-md-4>
 			<div class="card" data-bs-toggle="modal" data-bs-target="#add-category-modal">
 					<div class="card-body text-center">
 					<div class="container">
 						<img style="max-width:125px;" class="img-fluid rounded-circle"alt="user" src="assets/images/box.png">
 						</div>
 						<p class="text-muted">click here to add category</p>
 					 <h1 class="text-muted">Add Category</h1>
 					 
 					</div>
 				</div>
 			</div>
 		
 		<!-- end category -->
 		
 			<div col-md-4>
 			<div class="card" data-bs-toggle="modal" data-bs-target="#add-product-modal">
 					<div class="card-body text-center">
 					<div class="container">
 						<img style="max-width:125px;" class="img-fluid rounded-circle"alt="user" src="assets/images/plus.png">
 						</div>
 						<p class="text-muted">click here to add product</p>
 					 <h1 class="text-muted">Add Product</h1>
 					 
 					</div>
 				</div>
 			</div>
 			
 		</div>
 	</div>
 	<!-- add category modal -->
 	
<div class="modal fade" id="add-category-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header bg-dark text-white">
        <h5 class="modal-title" id="exampleModalLabel">Fill Product Details</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        
        
        <form action="productoperation.do" >
        <input type="hidden" name="operation" value="addcategory">
        	<div class="form-group mt-2">
        		<input type="text" class="form-control" name="categoryId" placeholder="Enter Category Id" required>
        	</div>
        	<div class="form-group mt-2">
        		<input type="text" class="form-control" name="categoryName" placeholder="Enter Category name" required>
        	</div>
        	<div class="container text-center mt-2 ">
        		<button class="btn btn-outline-success">Add Category</button>
        		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        	</div>
        </form>
        </div>
        </div>
        </div>
        </div>
        
 	<!-- end category madal -->
 	
 	
 	<!-- add product model -->
 
<!-- Modal -->
<div class="modal fade" id="add-product-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header bg-dark text-white">
        <h5 class="modal-title" id="exampleModalLabel">Fill Product Details</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        
        
        <form action="productoperation.do" >
        <input type="hidden" name="operation" value="addproduct">
        	<div class="form-group mt-2">
        		<input type="text" class="form-control" name="productId" placeholder="Enter product Id" required>
        	</div>
        	<div class="form-group mt-2">
        		<input type="text" class="form-control" name="productName" placeholder="Enter product name" required>
        	</div>
        	<div class="form-group mt-2">
        		<input type="text" class="form-control" name="quantity" placeholder="Enter Quantity" required>
        	</div>
        	<div class="form-group mt-2">
        		<input type="text" class="form-control" name="productprice" placeholder="Enter product price" required>
        	</div>
        	
        	<!--  <div class="form-group mt-2"> -->
        	<!-- 	<input type="text" class="form-control" name="catId" placeholder="Enter Category Id" required> -->
        	<!-- </div> -->
        	
        	<!-- categoy  -->
        	
        	<%
        	
        	CategoryDao cdao = new CategoryDao();
        	List<Category> list = cdao.getCategories();
        	
        	%>
        	
        	
        	<div class="form-group mt-2">
        		<select name="catId" class="form-control" id="">
        			<%
        			
        			  for(Category c:list){
        			%>
        			<option value="<%=c.getCategoryId()%>"><%=c.getCategoryName() %></option>
        			<% } %>
        		</select>
        	</div>
        	
        	<div class="container text-center mt-2 ">
        		<button class="btn btn-outline-success">Add product</button>
        		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        	</div>
        </form>
        
        
      </div>
      
    </div>
  </div>
</div>
<!-- End product modal -->
<div class="mt-5"></div>
</body>
<%@ include file="footer.jsp" %>
</html>