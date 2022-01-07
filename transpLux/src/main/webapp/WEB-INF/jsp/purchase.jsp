<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset = UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<!DOCTYPE HTML>
<html lang="en">
<body>

<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">

    <!-- ============================ COMPONENT REGISTER   ================================= -->
    <div class="card mx-auto" style="max-width:520px; margin-top:40px;">
        <article class="card-body">
            <header class="mb-4"><h4 class="card-title"><spring:message code="purchaseLabel"/></h4></header>

            <p><spring:message code="purchaseConfirmation"/></p>

            <c:if test="${paypalButtonHidden}">
            <form action="/transpLux/purchase/registerCommand" method="post">
                <a href="/transpLux/cart" class="btn btn-primary"><spring:message code="purchaseDeclineButton" /><i class="fa fa-chevron-right"></i> </a>
                <button class="addToCartButton">
                    <span class="btn btn-primary"><spring:message code="purchaseAcceptButton" /><i class="fa fa-chevron-right"></i> </span>
                </button>
            </form>
            </c:if>

            <c:if test="${!paypalButtonHidden}">
            <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                <input type="hidden" name="business"        value="sb-xwjou10814841@business.example.com">
                <input type="hidden" name="cert_id"         value="AU2uBoQolHcSRv_qutOxgJgLSXkB4FNBRjrVSW0Zjt2-3n4tnw4Nzp9CbWlvpn5Szr5dTErEQqjyCepD">

                <input type="hidden" name="amount"          value="${totalAmount}">
                <input type="hidden" name="cmd"             value="_xclick">
                <input type="hidden" name="currency_code"   value="EUR">

                <input type="hidden" name="return"          value='http://localhost:8081/transpLux/purchase/validateOrder'>

                <button class="addToCartButton">
                    <span class="btn btn-primary"><spring:message code="payWithPaypalButton" /><i class="fa fa-chevron-right"></i> </span>
                </button>
            </form>
            </c:if>
        </article><!-- card-body.// -->
    </div> <!-- card .// -->
    <br><br>
    <!-- ============================ COMPONENT REGISTER  END.// ================================= -->


</section>
<!-- ========================= SECTION CONTENT END// ========================= -->


</body>
</html>