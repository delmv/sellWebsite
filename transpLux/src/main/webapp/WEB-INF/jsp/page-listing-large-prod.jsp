<%@ page pageEncoding="UTF-8"
		 contentType="text/html; charset = UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE HTML>
<html lang="en">
<body>

<!-- ========================= SECTION PAGETOP ========================= -->
<section class="section-pagetop bg">
<div class="container">
	<h2 class="title-page">Category products</h2>
	<nav>
	<ol class="breadcrumb text-white">
	    <li class="breadcrumb-item"><a href="/transpLux">Home</a></li>
	    <c:choose>
			<c:when test="${!noCategory}">
				<li class="breadcrumb-item"><a href="./all">Products</a></li>
				<li class="breadcrumb-item active" aria-current="page">${products[0].category.getDefaultName()}</li>
			</c:when>
			<c:otherwise>
				<li class="breadcrumb-item active" aria-current="page">Products</li>
			</c:otherwise>
		</c:choose>
	</ol>
	</nav>
</div> <!-- container //  -->
</section>
<!-- ========================= SECTION INTRO END// ========================= -->

<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">
<div class="container">

<div class="row">
	<c:forEach var="product" items="${products}">
	<main class="col-md-9">

		<img src=${product.getProductImage()}  height="200dp" style="display: block; margin-left: auto; margin-right: auto;" />
		<article class="card card-product-list">
			<div class="card-body">
			<div class="row">
				<aside class="col-sm-4">
					<a href="#" class="img-wrap"><img src=${product.getProductLogo()}></a>
				</aside> <!-- col.// -->
				<div class="col-sm-8">
						<p class="title mt-2 h5">${product.getLabel()}</p>
						<div class="d-flex mb-3">
							<div class="price-wrap mr-4">
								<span class="price h5">$${product.getPrice()}</span>
							</div> <!-- price-dewrap // -->
						</div>
						
						<ul class="list-bullet">
							<li>${product.getDescription()}</li>
						</ul>
		
						<div class="form-row">
							<div class="form-group col-md flex-grow-0">
								<div class="input-group input-spinner" data-dashlane-rid="232d79aebf1e943e" data-form-type="other">
								  <div class="input-group-prepend">
									<button class="btn btn-light" type="button" id="button-plus"> - </button>
								  </div>
								  <input type="text" class="form-control" value="1" data-dashlane-rid="bdb8e614781bb362" data-form-type="other">
								  <div class="input-group-append">
									<button class="btn btn-light" type="button" id="button-minus" data-dashlane-rid="d08ae62580e61778" data-dashlane-label="true" data-form-type="other"> + </button>
								  </div>
								</div>  <!-- input-spinner.// -->
							</div> <!-- col.// -->
							<div class="form-group col-md">
								<a href="#" class="btn btn-primary"> <span class="text">Add to cart</span> <i class="fas fa-shopping-cart"></i> </a>
							</div> <!-- col.// -->
						</div> <!-- row.// -->
				</div> <!-- col.// -->
			</div> <!-- row.// -->
			</div> <!-- card-body .// -->
		</article>

	</main> <!-- col.// -->
	</c:forEach>
</div>

</div> <!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->





</body>
</html>