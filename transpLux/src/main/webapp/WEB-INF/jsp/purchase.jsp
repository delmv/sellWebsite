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
            <form:form id="register"
                       method="POST"
                       action="/transpLux/register/send"
                       modelAttribute="currentUser">

                <div class="form-group">
                    <form:label path="address">
                        <spring:message code="addressLabel"/> *
                    </form:label>
                    <form:input path="address" type="text" class="form-control" placeholder=""/>
                    <form:errors path="address" element="div"/>
                </div>

                <div class="form-group">
                    <form:label path="zipCode">
                        <spring:message code="zipCodeLabel"/> *
                    </form:label>
                    <form:input path="zipCode" type="text" class="form-control" placeholder=""/>
                    <form:errors path="zipCode" element="div"/>
                </div>

                <div class="form-group">
                    <form:label path="city">
                        <spring:message code="cityLabel"/> *
                    </form:label>
                    <form:input path="city" type="text" class="form-control" placeholder=""/>
                    <form:errors path="city" element="div"/>
                </div>
            </form:form>

            <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                <input type="hidden" name="business"        value="sb-xwjou10814841@business.example.com">
                <input type="hidden" name="cert_id"         value="AU2uBoQolHcSRv_qutOxgJgLSXkB4FNBRjrVSW0Zjt2-3n4tnw4Nzp9CbWlvpn5Szr5dTErEQqjyCepD">

                <input type="hidden" name="amount"          value="500">
                <input type="hidden" name="cmd"             value="_xclick">
                <input type="hidden" name="currency_code"   value="EUR">

                <input type="hidden" name="return"          value='http://localhost:8081/transpLux'>

                <button>Submit</button>
            </form>
        </article><!-- card-body.// -->
    </div> <!-- card .// -->
    <br><br>
    <!-- ============================ COMPONENT REGISTER  END.// ================================= -->


</section>
<!-- ========================= SECTION CONTENT END// ========================= -->


</body>
</html>