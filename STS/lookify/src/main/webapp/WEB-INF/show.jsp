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
<title>Details</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-3">
		<div class="d-flex justify-content-between align-items-center mb-5">
			<h1 class="text-primary">Song Details</h1>
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="row">
			<p class="col-4">Song Title:</p>
			<p class="col">${song.title}</p>
		</div>
		<div class="row">
			<p class="col-4">Song Artist:</p>
			<p class="col">${song.artist}</p>
		</div>
		<div class="row">
			<p class="col-4">Rating(1-10):</p>
			<p class="col">${song.rating}</p>
		</div>
		<form action="/songs/delete/${song.id}" method="POST" class="col-2">
			<input type="hidden" name="_method" value="delete" />
			<button class="btn btn-danger">Delete</button>
		</form>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>