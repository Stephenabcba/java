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
<title>New Question</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-5">
		<h1 class="text-primary">What is your question?</h1>
		<form:form action="/questions/new" method="post"
			modelAttribute="question" class="form">
			<form:errors path="content" class="alert alert-danger" element="p"
				delimiter="</p><p class='alert alert-danger'>" />
			<form:errors path="tagInput" class="alert alert-danger" element="p"
				delimiter="</p><p class='alert alert-danger'>" />
			<p>
				<form:label path="content" class="form-label">Question:</form:label>
				<form:textarea class="form-control" path="content" />
			</p>
			<p>
				<form:label path="tagInput" class="form-label">Tags:</form:label>
				<form:input class="form-control" path="tagInput" />
			</p>

			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
