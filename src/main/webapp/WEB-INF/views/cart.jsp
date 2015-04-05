<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="/webstore/resource/js/controllers.js"></script>

<section class="container" ng-app="cartApp">
	<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">

		<div>
			<a class="btn btn-danger pull-left" ng-click="clearCart()"> <span
				class="glyphicon glyphicon-remove-sign"></span> <spring:message
					code="cart.list.clearCart.label" />
			</a> <a href="<spring:url value="/checkout?cartId=${cartId}"/>"
				class="btn btn-success pull-right"> <span
				class="glyphicon-shopping-cart glyphicon"></span> <spring:message
					code="cart.list.checkout.label" />
			</a>
		</div>
		<table class="table table-hover">
			<tr>
				<th><spring:message code="cart.list.product.label" /></th>
				<th><spring:message code="cart.list.unitPrice.label" /></th>
				<th><spring:message code="cart.list.quantity.label" /></th>
				<th><spring:message code="cart.list.price.label" /></th>
				<th><spring:message code="cart.list.action.label" /></th>
			</tr>
			<tr ng-repeat="item in cart.cartItems">
				<td>{{item.product.productId}}-{{item.product.name}}</td>
				<td>{{item.product.unitPrice}}</td>
				<td>{{item.quantity}}</td>
				<td>{{item.totalPrice}}</td>
				<td><a href="#" class="label label-danger"
					ng-click="removeFromCart(item.product.productId)"> <span
						class="glyphicon glyphicon-remove" /></span> <spring:message
							code="cart.list.remove.label" />
				</a></td>
			</tr>
			<tr>
				<th></th>
				<th></th>
				<th><spring:message code="cart.list.grandTotal.label" /></th>
				<th>{{cart.grandTotal}}</th>
				<th></th>
			</tr>
		</table>

		<a href="<spring:url value="/products" />" class="btn btn-default">
			<span class="glyphicon-hand-left glyphicon"></span> <spring:message
				code="cart.list.continueShopping.label" />
		</a>
	</div>
</section>