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
<title>Dojos</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-5">
		<div class="d-flex justify-content-between align-items-center">
			<h1 class="text-primary">New Dojo:</h1>
			<p><a href="/ninjas/new" class="link-primary">Add a ninja</a></p>
		</div>
		<form:form action="/dojos" method="post" modelAttribute="dojo"
			class="form mb-5">
			<p>
				<form:errors path="name" class="text-danger" />
			</p>
			<p>
				<form:label path="name" class="form-label">Name:</form:label>
				<form:input class="form-control" path="name" />
			</p>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
		<h1 class="text-primary">Dojos</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dojo" items="${dojos }">
					<tr>
						<td class="align-middle">${dojo.name }</td>
						<td class="align-middle"><a href="/dojos/${dojo.id}">See Students</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
