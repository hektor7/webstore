<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js">
	
</script>
<script src="/webstore/resource/js/controllers.js"></script>

<section class="container" ng-app="cartApp">
	<div class="row">
		<div class="col-md-5">
			<img
				src="<c:url value="/resource/images/${product.productId}.png"></c:url>"
				alt="image" style="width: 100%" />
		</div>
		<div class="col-md-5">
			<h3>${product.name}</h3>
			<p>${product.description}</p>
			<p>
				<strong><spring:message
						code="product.details.productId.label" /></strong> : <span
					class="label label-warning">${product.productId}</span>
			</p>
			<p>
				<strong><spring:message
						code="product.details.manufacturer.label" /></strong> :
				${product.manufacturer}
			</p>
			<p>
				<strong><spring:message
						code="product.details.category.label" /></strong> : ${product.category}
			</p>
			<p>
				<strong><spring:message
						code="product.details.unitsInStock.label" /></strong> :
				${product.unitsInStock}
			</p>
			<h4>${product.unitPrice}USD</h4>

			<p>
				<strong><a
					href="<c:url value="/resource/pdf/${product.productId}.pdf"/>">
						<spring:message code="product.details.productUserManual.label" />
				</a></strong>
			</p>
			<p ng-controller="cartCtrl">
				<a href="<spring:url value="/products" />" class="btn btn-default">
					<span class="glyphicon-hand-left glyphicon"></span> <spring:message
						code="product.details.back" />
				</a> <a href="#" class="btn btn-warning btn-large"
					ng-click="addToCart('${product.productId}')"> <span
					class="glyphicon-shopping-cart glyphicon"></span> <spring:message
						code="product.details.orderNow" />
				</a> <a href="<spring:url value="/cart" />" class="btn btn-default">
					<span class="glyphicon-hand-right glyphicon"></span> <spring:message
						code="product.details.viewCart" />
				</a>
			</p>
		</div>
	</div>
</section>