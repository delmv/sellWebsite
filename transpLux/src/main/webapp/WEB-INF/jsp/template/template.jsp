<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="max-age=604800" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>${title}</title>

    <link href='<spring:url value="/images/favicon.ico"/>' rel="shortcut icon" type="image/x-icon">

    <!-- jQuery -->
    <script src='<spring:url value="/js/jquery-2.0.0.min.js"/>' type="text/javascript"></script>

    <!-- Bootstrap4 files-->
    <script src='<spring:url value="/js/bootstrap.bundle.min.js"/>' type="text/javascript"></script>
    <link href='<spring:url value="/css/bootstrap.css"/>' rel="stylesheet" type="text/css"/>

    <!-- Font awesome 5 -->
    <link href='<spring:url value="/fonts/fontawesome/css/all.min.css"/>' type="text/css" rel="stylesheet">

    <!-- custom style -->
    <link href='<spring:url value="/css/ui.css"/>' rel="stylesheet" type="text/css"/>
    <link href='<spring:url value="/css/responsive.css"/>' rel="stylesheet" media="only screen and (max-width: 1200px)" type="text/css"/>
    <link href='<spring:url value="/css/custom.css"/>' rel="stylesheet" type="text/css" />
    <link href='<spring:url value="/css/bootstrap.css"/>' rel="stylesheet" media="only screen and (max-width: 1200px)" type="text/css" />

    <!-- custom javascript -->
    <script src='<spring:url value="/js/script.js"/>' type="text/javascript"></script>

    <script type="text/javascript">
        /// some script

        // jquery ready start
        $(document).ready(function() {
            // jQuery code

        });
        // jquery end
    </script>

    <spring:url value="" var="localeFr">
        <spring:param name="locale" value="fr"/>
    </spring:url>

    <spring:url value="" var="localeEn">
        <spring:param name="locale" value="en"/>
    </spring:url>

</head>
<body>
<header class="section-header">

    <section class="header-main border-bottom">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-2 col-4">
                    <a href='<spring:url value="/"/>' class="brand-wrap">
                        <img class="logo" src='<spring:url value="/images/logos/Sans titre-2.png"/>' width="60%" height="60%">
                    </a> <!-- brand-wrap.// -->
                </div>
                <div class="col-lg-6 col-sm-12">
                    <form action="#" class="search">
                        <div class="input-group w-100">
                            <input type="text" class="form-control" placeholder="Search">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="submit">
                                    <i class="fa fa-search"></i> Search
                                </button>
                            </div>
                        </div>
                    </form> <!-- search-wrap .end// -->
                </div> <!-- col.// -->
                <div class="col-lg-4 col-sm-6 col-12">
                    <div class="widgets-wrap float-md-right">
                        <div class="widget-header  mr-3">
                            <a href='<spring:url value="/cart"/>' class="icon icon-sm rounded-circle border"><i class="fa fa-shopping-cart"></i></a>
                            <span class="badge badge-pill badge-danger notify">${nbItemsCart}</span>
                        </div>
                        <div class="widget-header icontext">
                            <a href='<spring:url value="myAccount"/>' class="icon icon-sm rounded-circle border"><i class="fa fa-user"></i></a>
                            <div class="text">
                                <span class="text-muted">Welcome! ${firstName}</span>
                                <div>
                                    <p>
                                        <a href='<spring:url value="login"/>'>Sign in</a> |
                                        <a href='<spring:url value="register"/>'> Register</a>
                                    </p>
                                    <p>
                                        <a href="${localeFr}">FR</a> |
                                        <a href="${localeEn}"/>EN</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div> <!-- widgets-wrap.// -->
                </div> <!-- col.// -->
            </div> <!-- row.// -->
        </div> <!-- container.// -->
    </section> <!-- header-main .// -->
</header> <!-- section-header.// -->
<div>
    <tiles:insertAttribute name="main-content"/>
</div>
<!-- ========================= FOOTER ========================= -->
<footer class="section-footer border-top">
    <div class="container">
        <section class="footer-top padding-y">
            <div class="row">
                <aside class="col-md col-6">
                    <h6 class="title">Company</h6>
                    <ul class="list-unstyled">
                        <li> <a href="./aboutus">About us</a></li>
                        <li> <a href="./aboutus">TranspLux Values</a></li>
                        <li> <a href="./aboutus">Infos</a></li>
                        <li> <a href="./aboutus">TranspLux</a></li>
                    </ul>
                </aside>
                <aside class="col-md col-6">
                    <h6 class="title">Account</h6>
                    <ul class="list-unstyled">
                        <li> <a href="./login"> User Login </a></li>
                        <li> <a href="./register"> User register </a></li>
                        <li> <a href="./myAccount"> Account Setting </a></li>
                        <li> <a href="./myAccount"> My Orders </a></li>
                    </ul>
                </aside>
            </div> <!-- row.// -->
        </section>	<!-- footer-top.// -->

        <section class="footer-bottom border-top row">
            <div class="col-md-2">
                <p class="text-muted"> &copy 2022 TranspLux </p>
            </div>
            <div class="col-md-8 text-md-center">
                <span  class="px-2">info@transpLux.io</span>
                <span  class="px-2">+879-332-9375</span>
                <span  class="px-2">Rue des très riches 123, 1000 Gold</span>
            </div>
            <div class="col-md-2 text-md-right text-muted">
                <i class="fab fa-lg fa-cc-paypal"></i>
            </div>
        </section>
    </div><!-- //container -->
</footer>
<!-- ========================= FOOTER END // ========================= -->

</body>
</html>