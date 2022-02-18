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
<title>Read Share</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-5">
		<div class="d-flex justify-content-between mb-5">
			<h1 class="text-primary">${book.title}</h1> <a href="/books">back
				to the shelves</a>
		</div>
		<h3>
			<c:choose>
				<c:when test="${uuid == book.poster.id }">You</c:when>
				<c:otherwise>${book.poster.name }</c:otherwise>
			</c:choose>
			read ${book.title } by ${book.author }.
		</h3>
		<h3 class="mb-5">
			Here are
			<c:choose>
				<c:when test="${uuid == book.poster.id }">your</c:when>
				<c:otherwise>${book.poster.name }'s</c:otherwise>
			</c:choose>
			thoughts:
		</h3>
		<div class="mx-3">
			<p class="border-bottom border-secondary mb-4"></p>
			<p class="col">${book.thought}</p>
			<p class="border-bottom border-secondary my-4"></p>
		</div>
		<c:if test="${book.poster.id == uuid }">
			<div class="d-flex justify-content-end">
				<a href="/books/${book.id }/edit" class="btn btn-secondary">edit</a>
			</div>
		</c:if>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
