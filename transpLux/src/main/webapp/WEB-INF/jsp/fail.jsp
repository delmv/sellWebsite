<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="error">
    <img src="<spring:url value='/images/error.jpg'/>"/>

    <p><spring:message code="errorPageMessage" /></p>
</div>