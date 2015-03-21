<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title><spring:message code="customers.list.windowTitle" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<spring:message code="customers.list.header" />
				</h1>
				<p>
					<spring:message code="customers.list.title" />
				</p>
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

	<section class="container">
		<div class="row">
			<c:forEach items="${customers}" var="customer">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>
								<spring:message code="customers.list.name.label" />
								${customer.name}
							</h3>
							<p>
								<spring:message code="customers.list.address.label" />
								${customer.address}
							</p>
							<p>
								<spring:message code="customers.list.noOfOrdersMade.label" />
								${customer.noOfOrdersMade}
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>