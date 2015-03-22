<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title><spring:message code="addProduct.form.windowTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<spring:message code="addProduct.form.header" />
				</h1>
				<p>
					<spring:message code="addProduct.form.title" />
				</p>
			</div>
			<a href="<c:url value="/j_spring_security_logout" />"
				class="btn btn-danger btn-mini pull-right"> <spring:message
					code="addProduct.logout" />
			</a>
			<div class="pull-right" style="padding-right: 50px">
				<a href="?language=en">
					<spring:message code="languages.english.label" />
				</a>|
				<a href="?language=es">
					<spring:message code="languages.spanish.label" />
				</a>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newProduct" class="form-horizontal"
			enctype="multipart/form-data">
			<form:errors path="*" cssClass="alert alert-danger" element="div"/>
			<fieldset>
				<legend><spring:message
						code="addProduct.form.formTitle"/></legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<spring:message code="addProduct.form.productId.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="productId" path="productId" type="text"
							class="form:input-large" />
						<form:errors path="productId" cssClass="text-danger"/>
					</div>
				</div>

				<!-- Similarly bind form:input tag for name,unitPrice,manufacturer,category,unitsInStock and unitsInOrder fields-->

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="iName">
						<spring:message code="addProduct.form.name.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="iName" path="name" type="text"
							class="form:input-large" />
						<form:errors path="name" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="iUnitPrice">
						<spring:message code="addProduct.form.unitPrice.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="iUnitPrice" path="unitPrice" type="text"
							class="form:input-large" />
						<form:errors path="unitPrice" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="iManufacturer">
						<spring:message code="addProduct.form.manufacturer.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="iManufacturer" path="manufacturer" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="iCategory">
						<spring:message code="addProduct.form.category.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="iCategory" path="category" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="iUnitsInStock">
						<spring:message code="addProduct.form.unitsInStock.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="iUnitsInStock" path="unitsInStock" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description"> <spring:message
							code="addProduct.form.description.label" />
					</label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows="2" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="condition"> <spring:message
							code="addProduct.form.condition.label" />
					</label>
					<div class="col-lg-10">
						<form:radiobutton path="condition" value="New" />
						<spring:message code="addProduct.form.conditionNew.label" />
						<form:radiobutton path="condition" value="Old" />
						<spring:message code="addProduct.form.conditionOld.label" />
						<form:radiobutton path="condition" value="Refurbished" />
						<spring:message code="addProduct.form.conditionRefurbished.label" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="productImage"><spring:message
							code="addProdcut.form.productImage.label" /></label>
					<div class="col-lg-10">
						<form:input id="productImage" path="productImage" type="file"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="productUserManual"><spring:message
							code="addProdcut.form.productUserManual.label" /></label>
					<div class="col-lg-10">
						<form:input id="productUserManual" path="productUserManual"
							type="file" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="<spring:message code=  "addProduct.form.AddButton.label"/>" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>