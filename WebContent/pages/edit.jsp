<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update quantity</title>
<%@include file="assets/common_css_js.jsp" %>
</head>
<body>
<div class= "container">
<form action="edititem.do">


<div class="form-row ">
    <div class="col-md-2 mb-3">
      <label for="validationServer01">Enter Order ID</label>
      <input type="text" class="form-control" name="oid1" placeholder="Enter Order Id">
     </div>
     
     <div class="col-md-2 mb-3">
      <label for="validationServer02">Quantity</label>
      <input type="text" class="form-control" name="qty" placeholder="Enter Quantity">
      </div>
  </div>



<input class="btn btn-primary" type="submit" value="Update" name="submit">
</form></div>
</body>
</html>