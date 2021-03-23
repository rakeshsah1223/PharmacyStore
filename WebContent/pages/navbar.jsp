<%@page import="com.keane.training.domain.User"%>
<%
User user1 = (User)session.getAttribute("admin");

%>





<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<div class="container">
  <a class="navbar-brand" href="index.jsp">Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="admin.jsp">Home </a>
      </li>
      
     <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Category
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item text-white bg-dark" href="#">Personal Care</a>
          <a class="dropdown-item text-white bg-dark" href="#">Nutrition</a>
         
          <a class="dropdown-item text-white bg-dark" href="#">Health care</a>
        </div>
      </li>
    </ul>
    </div>
    <div>
    <ul class="navbar-nav ml-auto">
    
      	<%
      		if(user1==null)
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
      		
      		<form action="searchbyid.do"  class="d-flex ml-5">
        <input class="form-control me-3 " type="search" name="orderId" placeholder="Enter orderid to search" required aria-label="Search">
        <input class="btn btn-outline-success" type="submit" name="submit" value="search">
         </form>	
      			
      <li class="nav-item active">
        <a class="nav-link" href="#!"><%= user1.getName()%> </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="adlogout.do">Logout</a>
      </li>
      			<% 
      		}
      	
      	%>
      	
     
    
    </ul>
    
    
  </div>
  </div>
</nav>
