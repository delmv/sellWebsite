<%@ page pageEncoding="UTF-8"
		 contentType="text/html; charset = UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE HTML>
<html lang="en">

<body>

<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-conten padding-y" style="min-height:84vh">

<!-- ============================ COMPONENT LOGIN   ================================= -->
	<div class="card mx-auto" style="max-width: 380px; margin-top:100px;">
      <div class="card-body">
      <h4 class="card-title mb-4"><spring:message code="loginButton"/></h4>
          <c:if test="${not empty error}">
              <div style="color:green; font-weight: bold; margin: 30px 0px;">
                  <spring:message code="userNameOrPasswordIncorrect"/>
              </div></c:if>
          <c:if test="${not empty logout}">
              <div style="color:red; font-weight: bold; margin: 30px 0px;">
                  <spring:message code="lougoutSuccessful"/>
              </div></c:if>
      <form:form id="login"
                method="post"
                 action=""
                modelAttribute="user">
          <div class="form-group">
              <form:label path="username">
                  <spring:message code="userNameLabel"/>*
              </form:label>
              <form:input path="username" class="form-control" placeholder=""/>
              <form:errors path="username" element="div"/>
          </div> <!-- form-group// -->
          <div class="form-group">
              <form:label path="password">
                  <spring:message code="passwordLabel"/>*
              </form:label>
              <form:input path="password" class="form-control" type="password"/>
              <form:errors path="password" element="div"/>
          </div> <!-- form-group// -->
          <div class="form-group">
              <form:button type="submit" class="btn btn-primary btn-block">
                  <spring:message code="loginButton"/>
              </form:button>
          </div> <!-- form-group// -->
      </form:form>
      </div> <!-- card-body.// -->
    </div> <!-- card .// -->

     <p class="text-center mt-4"><spring:message code="noAccountLabel"/> <a href="./register"><spring:message code="registerLabel"/></a></p>
     <br><br>
<!-- ============================ COMPONENT LOGIN  END.// ================================= -->


</section>
<!-- ========================= SECTION CONTENT END// ========================= -->






</body>
</html>