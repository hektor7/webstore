<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title><spring:message code=  "product.details.windowTitle"/></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1><spring:message code=  "product.details.header"/></h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong><spring:message code=  "product.details.productId.label"/></strong> : <span class="label label-warning">${product.productId}</span>
				</p>
				<p>
					<strong><spring:message code=  "product.details.manufacturer.label"/></strong> : ${product.manufacturer}
				</p>
				<p>
					<strong><spring:message code=  "product.details.category.label"/></strong> : ${product.category}
				</p>
				<p>
					<strong><spring:message code=  "product.details.unitsInStock.label"/></strong> : ${product.unitsInStock}
				</p>
				<h4>${product.unitPrice}USD</h4>

				<p>
					<a href="<spring:url value="/products" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> <spring:message code=  "product.details.back"/>
					</a> <a href="#" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"></span> <spring:message code=  "product.details.orderNow"/>
					</a>
				</p>
			</div>
		</div>
	</section>
</body>
</html>