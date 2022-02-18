<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Read Share</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for internal CSS -->
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container pt-5">
		<div class="d-flex justify-content-between align-items-center">
			<h1>Welcome, ${loggedin_name }!</h1>
			<form action="/logout" method="post">
				<button class="text-primary bg-transparent border-0 p-0">Logout</button>
			</form>
		</div>
		<div class="d-flex justify-content-between align-items-center">
			<p>Books from everyone's shelves:</p>
			<a href="/books/new">+ Add a book to my shelf!</a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td class="align-middle">${book.id }</td>
						<td class="align-middle"><a href="/books/${book.id }">${book.title }</a></td>
						<td class="align-middle">${book.author }</td>
						<td class="align-middle">${book.poster.name }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<!-- internal script -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>
