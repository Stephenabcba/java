<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<h2>Show Language</h1>
			<a href="/languages">Dashboard</a>
		</div>
		<p>${language.name }</p>
		<p>${language.creator }</p>
		<p>${language.version }</p>
		<p><a href="/languages/${language.id }/edit">edit</a></p>
		<form action="/languages/${language.id }" method="POST">
			<input type="hidden" name="_method" value="delete">
			<button class="btn btn-danger">Delete</button>
		</form>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>