<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset = UTF-8" %>
<%@ include file="include/importTags.jsp" %>
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
                <a class="nav-link" href="/transpLux/products/all">All</a>
            </li>
            <c:forEach var="category" items="${categories}">
                <li class="nav-item">
                    <a class="nav-link" href="/transpLux/products/${category.getDefaultName()}">${category.getDefaultName()}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</nav>

<!-- ========================= SECTION PAGETOP ========================= -->
<section class="section-pagetop bg">
    <div class="container">
        <h2 class="title-page">Category products</h2>
        <nav>
            <ol class="breadcrumb text-white">
                <li class="breadcrumb-item"><a href="../">Home</a></li>
                <c:choose>
                    <c:when test="${!noCategory}">
                        <li class="breadcrumb-item"><a href="./all">Products</a></li>
                        <li class="breadcrumb-item active"
                            aria-current="page">${products[0].category.getDefaultName()}</li>
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
        <c:forEach var="product" items="${products}">
            <article class="card card-product-list">
                <div class="row no-gutters">
                    <aside class="col-md-3">
                        <a href="./details/${product.getId()}" class="img-wrap"><img src='<spring:url value="${product.getProductImage()}" />' ></a>
                    </aside> <!-- col.// -->
                    <div class="col-md-6">
                        <div class="info-main">
                            <a href="./details/${product.getId()}" class="h5 title"> ${product.getLabel()} </a>
                            <p>${product.getDescription()}</p>
                        </div> <!-- info-main.// -->
                    </div> <!-- col.// -->
                    <aside class="col-sm-3">
                        <div class="info-aside">
                            <div class="price-wrap">
                                <span class="price h5"> ${product.getCurrentPrice()} </span>
                                <c:if test="${product.getCurrentPrice() != product.getPrice()}">
                                    <del class="price-old"> ${product.getPrice()}</del>
                                </c:if>
                            </div> <!-- info-price-detail // -->
                            <p class="text-success">Free shipping</p>
                            <br>
                            <p>
                                <a href="./details/${product.getId()}" class="btn btn-primary btn-block"> Details </a>
                                <a href="#" class="btn btn-light btn-block"><i class="fa fa-heart"></i>
                                    <span class="text">Add to wishlist</span></a>
                            </p>
                        </div> <!-- info-aside.// -->
                    </aside> <!-- col.// -->
                </div> <!-- row.// -->
            </article>
            <!-- card-product .// -->
        </c:forEach>

        </main> <!-- col.// -->

    </div>

    </div> <!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->

<!-- ========================= FOOTER ========================= -->
<footer class="section-footer border-top padding-y">
    <div class="container">
        <p class="float-md-right">
            &copy Copyright 2019 All rights reserved
        </p>
        <p>
            <a href="#">Terms and conditions</a>
        </p>
    </div><!-- //container -->
</footer>
<!-- ========================= FOOTER END // ========================= -->


</body>
</html>