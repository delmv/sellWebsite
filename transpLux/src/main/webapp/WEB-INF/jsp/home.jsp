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

</body>
</html>