<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<li><a href="<spring:url value="/products"/>"><spring:message code="navigation.manu.home"/></a></li>
<li><a href="<spring:url value="/products/"/>"><spring:message code="navigation.manu.products"/></a></li>
<li><a href="<spring:url value="/products/add"/>"><spring:message code="navigation.manu.addProducts"/></a></li>
<li><a href="<spring:url value="/cart/"/>"><spring:message code="navigation.manu.cart"/></a></li>