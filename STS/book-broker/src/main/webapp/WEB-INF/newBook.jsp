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
<title>Book Share</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-5">
		<div class="d-flex justify-content-between align-items-center">
			<h1 class="text-primary">Add a Book to Your Shelf!</h1> <a
				href="/books">back to the shelves</a>
		</div>
		<form:form action="/books/new" method="post" modelAttribute="book"
			class="form">
			<form:errors path="title" class="alert alert-danger" element="p"
				delimiter="</p><p class='alert alert-danger'>" />
			<form:errors path="author" class="alert alert-danger" element="p"
				delimiter="</p><p class='alert alert-danger'>" />
			<form:errors path="thought" class="alert alert-danger" element="p"
				delimiter="</p><p class='alert alert-danger'>" />
			<p>
				<form:label path="title" class="form-label">Title:</form:label>
				<form:input class="form-control" path="title" />
			</p>
			<p>
				<form:label path="author" class="form-label">Author:</form:label>
				<form:input class="form-control" path="author" />
			</p>
			<p>
				<form:label path="thought" class="form-label">My Thoughts:</form:label>
				<form:textarea class="form-control" path="thought" />
			</p>
			<div class="d-flex justify-content-end">
            	<input type="submit" value="Submit" class="btn btn-primary"/>
            </div>
		</form:form>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
