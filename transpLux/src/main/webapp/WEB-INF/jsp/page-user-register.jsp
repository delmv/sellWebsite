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
            <header class="mb-4"><h4 class="card-title">Sign up</h4></header>
            <form:form id="register"
                       method="POST"
                       action="/transpLux/register/send"
                       modelAttribute="currentUser">
                <div class="form-row">
                    <div class="col form-group">
                        <form:label path="firstName">
                            <spring:message code="firstNameLabel"/>
                        </form:label>
                        <form:input type="text" class="form-control" placeholder="" path="firstName"/>
                        <form:errors path="firstName" element="div"/>
                    </div> <!-- form-group end.// -->
                    <div class="col form-group">
                        <form:label path="lastName">
                            <spring:message code="lastNameLabel"/>
                        </form:label>
                        <form:input path="lastName" type="text" class="form-control" placeholder=""/>
                        <span style="color: red">
                            <form:errors path="lastName" element="div"/>
                        </span>
                    </div> <!-- form-group end.// -->
                </div>
                <!-- form-row end.// -->


                <div class="form-group">
                    <form:label path="email">
                        <spring:message code="emailLabel"/>
                    </form:label>
                    <form:input path="email" type="email" class="form-control" placeholder=""/>
                    <form:errors path="email" element="div"/>
                    <small class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <!-- form-group end.// -->
                <div class="form-group">
                    <spring:message code="manLabel" var="manLabel"/>
                    <spring:message code="womanLabel" var="womanLabel"/>

                    <form:radiobutton path="male" value="true" label="${manLabel}"
                                      class="custom-control custom-radio custom-control-inline"/>
                    <form:radiobutton path="male" value="false" label="${womanLabel}"
                                      class="custom-control custom-radio custom-control-inline"/>
                    <form:errors path="male" element="div"/>

                </div>
                <!-- form-group end.// -->
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <form:label path="city">
                            <spring:message code="cityLabel"/>
                        </form:label>
                        <form:input path="city" type="text" class="form-control"/>
                        <form:errors path="city" element="div"/>

                    </div> <!-- form-group end.// -->
                    <div class="form-group col-md-6">
                        <form:label path="country">
                            <spring:message code="countryLabel"/>
                        </form:label>
                        <form:select id="inputState" class="form-control" path="country">
                            <form:option value=""> Choose...</form:option>
                            <form:option value="Uzbekistan">Uzbekistan</form:option>
                            <form:option value="Russia">Russia</form:option>
                            <form:option value="United State" selected="">United States</form:option>
                            <form:option value="India">India</form:option>
                            <form:option value="Afganistan">Afganistan</form:option>
                        </form:select>
                        <form:errors path="country" element="div"/>
                    </div> <!-- form-group end.// -->
                </div>
                <!-- form-row.// -->
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <form:label path="password">
                            <spring:message code="createPasswordLabel"/>
                        </form:label>
                        <form:input path="password" class="form-control" type="password"/>
                        <form:errors path="password" element="div"/>

                    </div> <!-- form-group end.// -->
                    <div class="form-group col-md-6">
                        <form:label path="repeatPassword">
                            <spring:message code="repeatPasswordLabel"/>
                        </form:label>
                        <form:input path="repeatPassword" type="password" class="form-control"/>
                        <form:errors path="repeatPassword" element="div"/>
                    </div> <!-- form-group end.// -->
                </div>
                <div class="form-group">
                    <form:button type="submit" class="btn btn-primary btn-block">
                        <spring:message code="registrationButton"/>
                    </form:button>
                </div>
                <!-- form-group// -->
            </form:form>
        </article><!-- card-body.// -->
    </div> <!-- card .// -->
    <p class="text-center mt-4">Have an account? <a href="./login">Log In</a></p>
    <br><br>
    <!-- ============================ COMPONENT REGISTER  END.// ================================= -->


</section>
<!-- ========================= SECTION CONTENT END// ========================= -->


</body>
</html>