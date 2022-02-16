<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${language.name }</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-5">
		<div class="d-flex align-items-center justify-content-between">
			<h2>Show Language</h2>
			<div>
				<form action="/languages/${language.id }" method="POST">
					<input type="hidden" name="_method" value="delete">
					<button class="btn btn-danger">Delete</button>
				</form>
				<a href="/languages">Dashboard</a>
			</div>
		</div>
		<form:form action="/languages/${language.id }" method="post" modelAttribute="language"
			class="form">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:errors path="name" class="text-danger" />
			</p>
			<p>
				<form:errors path="creator" class="text-danger" />
			</p>
			<p>
				<form:errors path="version" class="text-danger" />
			</p>
			<p>
				<form:label path="name" class="form-label">Name:</form:label>
				<form:input class="form-control" path="name" />
			</p>
			<p>
				<form:label path="Creator" class="form-label">Creator</form:label>
				<form:input class="form-control" path="creator" />
			</p>
			<p>
				<form:label path="version" class="form-label">Version</form:label>
				<form:input class="form-control" path="version" />
			</p>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>