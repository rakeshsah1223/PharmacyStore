<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="assets/common_css_js.jsp" %>

<title>My Medical Store</title>
</head>
<body >
<%@ include file= "navbar.jsp" %>



<header>
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
      <!-- Slide One - Set the background image for this slide in the line below -->
      <div class="carousel-item active" style="background-image: url('assets/images/personal.jpg')">
        <div class="carousel-caption d-none d-md-block">
          
        </div>
      </div>
      <!-- Slide Two - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('assets/images/health.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h3 class="display-4">Health Product</h3>
          <p class="lead">All kinds of Health Product available here.</p>
        </div>
      </div>
      <!-- Slide Three - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('assets/images/nutrition.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h3 class="display-4">Nutrition</h3>
          <p class="lead">All kinds of nutrition item available here.</p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" type="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
  </div>
</header>
<div class=" ml-2">
<h3>Beauty Hygiene Products</h3>
<p>We know how important personal care is to women and how most women just cannot do without their 
favourite products on a daily basis. Whether it’s for your daily skin care, hair care or if you’re shopping beauty 
care products, we have all your favourite brands, as well as Ayurvedic and organic options.
 Beauty hygiene products are an important part of your daily routine and doing without them can cause unnecessary unhappiness. That’s why we at bigbasket have made it so easy for you to pick up all your products from one place, while doing all your other shopping, 
and get it as soon as you like with our express delivery option!</p>
</div>

<h3>Hair Care</h3>
<p>
Soaps, deodorants, cosmetics and washes - you need it all on a daily basis.
 We at bigbasket are determined to have it all for you, intelligently sourced. 
 If you like to smell like a garden of roses you need to make sure you always have your
  favourite soaps, talcs and deodorants in stock. We know how you can’t leave the house without your 
  streak of kajal and or splash of colour with a different nail polish every other day,
   and that’s why we house all your favourite brands like Lakme, Biotique, Maybelline and many others
 </p>
 
 <h3>Nutrition Product</h3>
 <p>With our hectic schedules, it’s very common for us to not meet our daily nutritional needs despite our best efforts.
 To be more mindful about decisions about our health, it’s important to meet essential nutritional demands through external sources.
  With Herbalife Nutrition Targeted Nutrition range, 
  you can now stay on top of your health easily by giving your body the specific targeted nutritional 
 support it needs.</p>
</body>
<%@include file="footer.jsp" %>
</html>