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
<title>Search</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>

<body>
	<div class="container pt-3">
		<div class="d-flex align-items-center justify-content-between">
			<p>Top Ten Songs:</p>
			<a href="/dashboard">Dashboard</a>
		</div>
		<ul class="list-group">
			<c:forEach var="song" items="${songs }">
			<li class="list-group-item">
				${song.rating } - <a href="songs/${song.id }" class="link-primary">${song.title }</a> - ${song.artist }
			</li>
			</c:forEach>
		</ul>
	</div>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>