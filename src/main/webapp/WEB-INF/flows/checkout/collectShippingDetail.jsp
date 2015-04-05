<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title><spring:message
		code="checkoutFlow.collectShippingDetail.windowTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<spring:message code="checkoutFlow.collectShippingDetail.header" />
				</h1>
				<p>
					<spring:message code="checkoutFlow.collectShippingDetail.subHeader" />
				</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="order.shippingDetail"
			class="form-horizontal">
			<fieldset>
				<legend>
					<spring:message
						code="checkoutFlow.collectShippingDetail.fieldSet.legend" />
				</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message
							code="checkoutFlow.collectShippingDetail.name.label" /></label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="shippingDate"><spring:message
							code="checkoutFlow.collectShippingDetail.shippingDate.label" /></label>
					<div class="col-lg-10">
						<form:input id="shippingDate" path="shippingDate" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="doorNo"><spring:message
							code="checkoutFlow.collectShippingDetail.doorNo.label" /></label>
					<div class="col-lg-10">
						<form:input id="doorNo" path="shippingAddress.doorNo" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="streetName"><spring:message
							code="checkoutFlow.collectShippingDetail.streetName.label" /></label>
					<div class="col-lg-10">
						<form:input id="streetName" path="shippingAddress.streetName."
							type="text" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="areaName"><spring:message
							code="checkoutFlow.collectShippingDetail.areaName.label" /></label>
					<div class="col-lg-10">
						<form:input id="areaName" path="shippingAddress.areaName"
							type="text" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="state"><spring:message
							code="checkoutFlow.collectShippingDetail.state.label" /></label>
					<div class="col-lg-10">
						<form:input id="state" path="shippingAddress.state" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="country"><spring:message
							code="checkoutFlow.collectShippingDetail.country.label" /></label>
					<div class="col-lg-10">
						<form:input id="country" path="shippingAddress.country"
							type="text" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="zipCode"><spring:message
							code="checkoutFlow.collectShippingDetail.zipCode.label" /></label>
					<div class="col-lg-10">
						<form:input id="zipCode" path="shippingAddress.zipCode"
							type="text" class="form:input-large" />
					</div>
				</div>

				<input type="hidden" name="_flowExecutionKey"
					value="${flowExecutionKey}" />

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<button id="back" class="btn btn-default"
							name="_eventId_backToCollectCustomerInfo">
							<spring:message
								code="checkoutFlow.collectShippingDetail.back.button" />
						</button>

						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add" name="_eventId_shippingDetailCollected" />
						<button id="btnCancel" class="btn btn-default"
							name="_eventId_cancel">
							<spring:message
								code="checkoutFlow.collectShippingDetail.cancel.button" />
						</button>
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>