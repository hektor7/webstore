<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/htmlcharset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title><spring:message code="productNotFound.detail.windowTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger">
					<spring:message code="productNotFound.detail.productNotFound"
						arguments="${invalidProductId}" htmlEscape="false" />
				</h1>
			</div>
		</div>
		<div class="pull-right" style="padding-right: 50px">
			<a href="?language=en"> <spring:message
					code="languages.english.label" />
			</a>| <a href="?language=es"> <spring:message
					code="languages.spanish.label" />
			</a>
		</div>
	</section>

	<section>
		<div class="container">
			<p>${url}</p>
			<p>${exception}</p>
		</div>

		<div class="container">
			<p>
				<a href="<spring:url value="/products" />" class="btn btn-primary">
					<span class="glyphicon-hand-left glyphicon"></span> <spring:message
						code="productNotFound.detail.products" />
				</a>
			</p>
		</div>

	</section>
</body>
</html>