<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Registration page</title>
  <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/css/login.css">
</head>
<body>
  <main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
    <div class="container">
      <div class="card login-card">
        <div class="row no-gutters">
          <div class="col-md-5">
            <img src="assets/images/login.jpg" alt="login" class="login-card-img">
          </div>
          <div class="col-md-7">
            <div class="card-body">
              <div class="brand-wrapper">
                <img src="assets/images/logo.svg" alt="logo" class="logo">
              </div>
              <p class="login-card-description">Sign Up</p>
              <%@ include file = "assets/message.jsp" %>
              <form action="register.do">
				  <div class="form-group">
                    <label for="userId" class="sr-only">Enter User Id</label>
                    <input type="text" name="userId" id="email" class="form-control" placeholder="Enter user id">
                  </div>
				  <div class="form-group mb-4">
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" name="password" id="password" class="form-control" placeholder="***********">
                  </div>
				 
				  <div class="form-group mb-4">
                    <label for="email" class="sr-only">Email</label>
                    <input type="email" name="emailId" id="email" class="form-control" placeholder="Email address">
                  </div>
				   <div class="form-group mb-4">
                    <label for="age" class="sr-only"></label>
                    <input type="text" name="age" id="email" class="form-control" placeholder="Enter Age">
                  </div>
                  <div class="form-group mb-4">
                    <label for="contact" class="sr-only">contact</label>
                    <input type="text" name="contact" id="email" class="form-control" placeholder="Enter Contact Number">
                  </div>
				  <div class="form-group mb-4">
                    <label for="city" class="sr-only">City</label>
                    <input type="text" name="city" id="email" class="form-control" placeholder="Enter City">
                  </div>
				  <div class="form-group mb-4">
                    <label for="state" class="sr-only">State</label>
                    <input type="text" name="state" id="email" class="form-control" placeholder="Enter state">
                  </div>
				  <div class="form-group mb-4">
                    <label for="pincode" class="sr-only">Pincode</label>
                    <input type="text" name="pincode" id="email" class="form-control" placeholder="Enter pincode">
                  </div>
                  <div class="form-group mb-4">
                    <label for="contact" class="sr-only">Role Type</label>
                    <input type="text" name="role_type" id="email" class="form-control" placeholder="Enter Role type(customer/admin)">
                  </div>
				  <div class="form-group mb-4">
                    <label for="contact" class="sr-only">Name</label>
                    <input type="text" name="name" id="email" class="form-control" placeholder="Enter Name">
                  </div>
                  <input name="login" id="login" class="btn btn-block login-btn mb-4" type="submit" value="Register">
                </form>
                <a href="#!" class="forgot-password-link">Forgot password?</a>
                <p class="login-card-footer-text">Existing user? <a href="Login.jsp" class="text-reset">Login here</a></p>
                <nav class="login-card-footer-nav">
                  <a href="#!">Terms of use.</a>
                  <a href="#!">Privacy policy</a>
                </nav>
            </div>
          </div>
        </div>
      </div>
     
    </div>
  </main>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>
