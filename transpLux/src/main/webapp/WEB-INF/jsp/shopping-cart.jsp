<%@ page pageEncoding="UTF-8"
		 contentType="text/html; charset = UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE HTML>
<html lang="en">

<body>

<!-- ========================= SECTION PAGETOP ========================= -->
<section class="section-pagetop bg">
<div class="container">
	<h2 class="title-page"><spring:message code="cartLabel"/></h2>
</div> <!-- container //  -->
</section>
<!-- ========================= SECTION INTRO END// ========================= -->

<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">
<div class="container">

<div class="row">
	<main class="col-md-9">
<div class="card">

<table class="table table-borderless table-shopping-cart">
<thead class="text-muted">
<tr class="small text-uppercase">
  <th scope="col"><spring:message code="productsLabel"/></th>
  <th scope="col" width="120"><spring:message code="quantityLabel"/></th>
  <th scope="col" width="120"><spring:message code="applyQuantityLabel"/></th>
	<th scope="col"><spring:message code="priceLabel"/></th>
  <th scope="col" class="text-right" width="200"> </th>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${cart.products.values()}">

	<tr>

		<td>
			<figure class="itemside">
				<div class="aside"><img src='<spring:url value="${item.product.getProductLogo()}" />' class="img-sm"></div>
				<figcaption class="info">
					<span class="title text-dark">${item.product.label}</span>
					<p class="text-muted small">${item.product.description}</p>
				</figcaption>
			</figure>
		</td>
		<form:form
				action="/transpLux/cart/changeQuantity/${item.product.id}"
				method="POST"
				modelAttribute="quantity">
		<td>
				<form:input type="number" min="1" class="form-control" value="${item.quantity}" style="min-width: 60px" path="number" data-dashlane-rid="bdb8e614781bb362" data-form-type="other" />
		</td>
		<td>
			<form:button class="addToCartButton">
				<span class="btn btn-light"><spring:message code="applyQuantityLabel"/></span>
			</form:button>
		</td>
		</form:form>
		<td>
			<div class="price-wrap">
				<var class="price">$${item.product.price * item.quantity}</var>
				<small class="text-muted"> $${item.product.price} <spring:message code="eachProductLabel"/> </small>
			</div> <!-- price-wrap .// -->
		</td>
		<form:form
				method="POST"
				action="/transpLux/cart/remove/${item.product.id}">
		<td class="text-right">
				<button class="addToCartButton"><span class="btn btn-light"> <spring:message code="removeLabel"/> </span></button>
		</td>
		</form:form>
	</tr>

</c:forEach>
</tbody>
</table>

<div class="card-body border-top">
	<c:if test="${cart.getTotalPrice() > 0}">
		<a href="/transpLux/purchase" class="btn btn-primary float-md-right"> <spring:message code="buyLabel"/> <i class="fa fa-chevron-right"></i> </a>
	</c:if>
</div>
</div> <!-- card.// -->

<div class="alert alert-success mt-3">
	<p class="icontext"><i class="icon text-success fa fa-truck"></i> <spring:message code="freeDeliveryWithinLabel"/></p>
</div>

	</main> <!-- col.// -->
	<aside class="col-md-3">

		<div class="card">
			<div class="card-body">
					<dl class="dlist-align">
					  <dt><spring:message code="totalPriceLabel"/>:</dt>
					  <dd class="text-right">${cart.getTotalPriceWithoutDiscounts()}</dd>
					</dl>
					<dl class="dlist-align">
					  <dt><spring:message code="discountLabel"/>:</dt>
					  <dd class="text-right">${cart.getTotalDiscounts()}</dd>
					</dl>
					<dl class="dlist-align">
					  <dt><spring:message code="totalPriceDiscountLabel"/>:</dt>
					  <dd class="text-right  h5"><strong>${cart.getTotalPrice()}</strong></dd>
					</dl>
			</div> <!-- card-body.// -->
		</div>  <!-- card .// -->
	</aside> <!-- col.// -->
</div>

</div> <!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->

<!-- ========================= SECTION  ========================= -->
<section class="section-name bg padding-y">
<div class="container">
<h6><spring:message code="paymentPolicyLabel"/></h6>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

</div><!-- container // -->
</section>
<!-- ========================= SECTION  END// ========================= -->

</body>
</html>