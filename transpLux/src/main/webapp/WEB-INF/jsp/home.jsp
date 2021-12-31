<%@ page pageEncoding="UTF-8"
		 contentType="text/html; charset = UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE HTML>
<html lang="en">
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="#">Categories</a>

	<!-- Toggler/collapsibe Button -->
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<!-- Navbar links -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="./products/all">All</a>
			</li>
			<c:forEach var="category" items="${categories}">
				<li class="nav-item">
					<a class="nav-link" href="./products/${category.getDefaultName()}">${category.getDefaultName()}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</nav>
<!-- ========================= SECTION INTRO ========================= -->
<section class="section-intro">

	<div class="intro-banner-wrap">
		<img src="images/banners/voiture_avion.png" class="w-100 img-fluid">
	</div>

</section>
<!-- ========================= SECTION INTRO END// ========================= -->


<!-- ========================= SECTION SPECIAL ========================= -->
<section class="section-specials padding-y border-bottom">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<figure class="itemside">
					<div class="aside">
					<span class="icon-sm rounded-circle bg-primary">
						<i class="fa fa-money-bill-alt white"></i>
					</span>
					</div>
					<figcaption class="info">
						<h6 class="title">Reasonable prices</h6>
						<p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
							tempor incididunt ut labor </p>
					</figcaption>
				</figure> <!-- iconbox // -->
			</div><!-- col // -->
			<div class="col-md-4">
				<figure class="itemside">
					<div class="aside">
					<span class="icon-sm rounded-circle bg-danger">
						<i class="fa fa-comment-dots white"></i>
					</span>
					</div>
					<figcaption class="info">
						<h6 class="title">Customer support 24/7 </h6>
						<p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
							tempor incididunt ut labor </p>
					</figcaption>
				</figure> <!-- iconbox // -->
			</div><!-- col // -->
			<div class="col-md-4">
				<figure class="itemside">
					<div class="aside">
					<span class="icon-sm rounded-circle bg-success">
						<i class="fa fa-truck white"></i>
					</span>
					</div>
					<figcaption class="info">
						<h6 class="title">Quick delivery</h6>
						<p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
							tempor incididunt ut labor </p>
					</figcaption>
				</figure> <!-- iconbox // -->
			</div><!-- col // -->
		</div> <!-- row.// -->

	</div> <!-- container.// -->
</section>
<!-- ========================= SECTION SPECIAL END// ========================= -->




<!-- ========================= SECTION  ========================= -->
<section class="section-name  padding-y-sm">
	<div class="container">

		<header class="section-heading">
			<a href="./products/all" class="btn btn-outline-primary float-right">See all</a>
			<h3 class="section-title">Popular products</h3>
		</header><!-- sect-heading -->


		<div class="row">
			<div class="col-md-3">
				<div href="#" class="card card-product-grid">
					<a href="#" class="img-wrap"> <img src="images/items/1.jpg"> </a>
					<figcaption class="info-wrap">
						<a href="#" class="title">Just another product name</a>
						<div class="price mt-1">$179.00</div> <!-- price-wrap.// -->
					</figcaption>
				</div>
			</div> <!-- col.// -->
			<div class="col-md-3">
				<div href="#" class="card card-product-grid">
					<a href="#" class="img-wrap"> <img src="images/items/2.jpg"> </a>
					<figcaption class="info-wrap">
						<a href="#" class="title">Some item name here</a>
						<div class="price mt-1">$280.00</div> <!-- price-wrap.// -->
					</figcaption>
				</div>
			</div> <!-- col.// -->
			<div class="col-md-3">
				<div href="#" class="card card-product-grid">
					<a href="#" class="img-wrap"> <img src="images/items/3.jpg"> </a>
					<figcaption class="info-wrap">
						<a href="#" class="title">Great product name here</a>
						<div class="price mt-1">$56.00</div> <!-- price-wrap.// -->
					</figcaption>
				</div>
			</div> <!-- col.// -->
			<div class="col-md-3">
				<div href="#" class="card card-product-grid">
					<a href="#" class="img-wrap"> <img src="images/items/4.jpg"> </a>
					<figcaption class="info-wrap">
						<a href="#" class="title">Just another product name</a>
						<div class="price mt-1">$179.00</div> <!-- price-wrap.// -->
					</figcaption>
				</div>
			</div> <!-- col.// -->
			<div class="col-md-3">
				<div href="#" class="card card-product-grid">
					<a href="#" class="img-wrap"> <img src="images/items/5.jpg"> </a>
					<figcaption class="info-wrap">
						<a href="#" class="title">Just another product name</a>
						<div class="price mt-1">$179.00</div> <!-- price-wrap.// -->
					</figcaption>
				</div>
			</div> <!-- col.// -->
			<div class="col-md-3">
				<div href="#" class="card card-product-grid">
					<a href="#" class="img-wrap"> <img src="images/items/6.jpg"> </a>
					<figcaption class="info-wrap">
						<a href="#" class="title">Some item name here</a>
						<div class="price mt-1">$280.00</div> <!-- price-wrap.// -->
					</figcaption>
				</div>
			</div> <!-- col.// -->
			<div class="col-md-3">
				<div href="#" class="card card-product-grid">
					<a href="#" class="img-wrap"> <img src="images/items/7.jpg"> </a>
					<figcaption class="info-wrap">
						<a href="#" class="title">Great product name here</a>
						<div class="price mt-1">$56.00</div> <!-- price-wrap.// -->
					</figcaption>
				</div>
			</div> <!-- col.// -->
			<div class="col-md-3">
				<div href="#" class="card card-product-grid">
					<a href="#" class="img-wrap"> <img src="images/items/9.jpg"> </a>
					<figcaption class="info-wrap">
						<a href="#" class="title">Just another product name</a>
						<div class="price mt-1">$179.00</div> <!-- price-wrap.// -->
					</figcaption>
				</div>
			</div> <!-- col.// -->
		</div> <!-- row.// -->

	</div><!-- container // -->
</section>
<!-- ========================= SECTION  END// ========================= -->



</body>
</html>