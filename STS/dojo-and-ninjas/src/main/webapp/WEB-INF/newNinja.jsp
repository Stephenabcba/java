<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>New Ninja</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-5">
		<div class="d-flex justify-content-between align-items-center">
			<h1 class="text-primary">Add a Ninja:</h1>
			<a href="/dojos">Go back</a>
		</div>
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja"
			class="form">
			<p>
				<form:errors path="firstName" class="text-danger" />
			</p>
			<p>
				<form:errors path="lastName" class="text-danger" />
			</p>
			<p>
				<form:errors path="age" class="text-danger" />
			</p>
			<form:select path="dojo" class="form-select">
				<c:forEach var="oneDojo" items="${dojos}">
					<form:option value="${oneDojo.id}" path="dojo">
						<c:out value="${oneDojo.name}" />
					</form:option>
				</c:forEach>
			</form:select>
			<p>
				<form:label path="firstName" class="form-label">First Name:</form:label>
				<form:input class="form-control" path="firstName" />
			</p>
			<p>
				<form:label path="lastName" class="form-label">Last Name:</form:label>
				<form:input class="form-control" path="lastName" />
			</p>
			<p>
				<form:label path="age" class="form-label">Age:</form:label>
				<form:input class="form-control" type="number" path="age" />
			</p>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>