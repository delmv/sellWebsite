<%@ page pageEncoding="UTF-8"
		 contentType="text/html; charset = UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE HTML>
<html lang="en">
<body>

<!-- ========================= SECTION PAGETOP ========================= -->
<section class="section-pagetop bg">
<div class="container">
	<h2 class="title-page">Product Details</h2>
	<nav>
	<ol class="breadcrumb text-white">
	    <li class="breadcrumb-item"><a href="../..">Home</a></li>
		<li class="breadcrumb-item"><a href="../all">Products</a></li>
		<li class="breadcrumb-item active" aria-current="page">${product.getLabel()}</li>
	</ol>
	</nav>
</div> <!-- container //  -->
</section>
<!-- ========================= SECTION INTRO END// ========================= -->

<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">
<div class="container">

<div class="row">
	<main class="col-md-9">

		<img src='<spring:url value="${product.getProductImage()}" />'  height="200dp" style="display: block; margin-left: auto; margin-right: auto;" />
		<article class="card card-product-list">
			<div class="card-body">
			<div class="row">
				<aside class="col-sm-4">
					<a href="#" class="img-wrap"><img src='<c:url value="${product.getProductLogo()}" />'></a>
				</aside> <!-- col.// -->
				<div class="col-sm-8">
						<p class="title mt-2 h5">${product.getLabel()}</p>
						<div class="d-flex mb-3">
							<div class="price-wrap mr-4">
								<span class="price h5"> ${product.getCurrentPrice()} </span>
								<c:if test="${product.getCurrentPrice() != product.getPrice()}">
									<del class="price-old"> ${product.getPrice()}</del>
								</c:if>
							</div> <!-- price-dewrap // -->
						</div>
						
						<ul class="list-bullet">
							<li>${product.getDescription()}</li>
						</ul>
						<form:form
							action="/transpLux/cart/addToCart/${product.getId()}"
							method="POST"
							modelAttribute="quantity">
							<div class="form-row">
								<div class="form-group col-md flex-grow-0">
									<div class="input-group input-spinner" data-dashlane-rid="232d79aebf1e943e" data-form-type="other">
										<div class="input-group-prepend">
											<span style="padding-top: 10%">Quantity⠀</span>
										</div>
										<form:input type="number" min="1" class="form-control" style="min-width: 60px" path="number" data-dashlane-rid="bdb8e614781bb362" data-form-type="other" />
										<form:errors path="number"/>
									</div>  <!-- input-spinner.// -->
								</div> <!-- col.// -->
								<div class="form-group col-md">
										<form:button class="addToCartButton">
											<span class="btn btn-primary"> <span class="text">Add to cart</span> <i class="fas fa-shopping-cart"></i></span>
										</form:button>
								</div> <!-- col.// -->
							</div> <!-- row.// -->
						</form:form>
				</div> <!-- col.// -->
			</div> <!-- row.// -->
			</div> <!-- card-body .// -->
		</article>

	</main> <!-- col.// -->
</div>

</div> <!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->





</body>
</html>