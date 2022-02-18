<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book Lender Dashboard</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for internal CSS -->
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container pt-5">
		<div class="d-flex justify-content-between align-items-center mb-3">
			<div>
				<p class="mb-0">Hello, ${loggedin_name }. Welcome to...</p>
				<h1>The Book Broker!</h1>
			</div>
			<div class="text-end">
				<form action="/logout" method="post">
					<button class="link-danger bg-transparent border-0 p-0">Logout</button>
				</form>
				<p>
					<a href="/books" class="text-decoration-none">back to the
						shelves</a>
				</p>
			</div>
		</div>
		<p>Available Books to Borrow</p>
		<div class="d-flex justify-content-between align-items-center">

		</div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Owner</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td class="align-middle">${book.id }</td>
						<td class="align-middle"><a href="/books/${book.id }">${book.title }</a></td>
						<td class="align-middle">${book.author }</td>
						<td class="align-middle">${book.poster.name }</td>
						<td class="align-middle"><c:choose>
								<c:when test="${book.poster.id == uuid }">
									<div class="d-flex">
										<a href="/books/${book.id }/edit"
											class="link-primary me-3 text-decoration-none">edit</a>
										<form action="/books/${book.id }/delete" method="post">
											<input type="hidden" name="_method" value="delete" />
											<button class="link-danger m-0 p-0 bg-transparent border-0">delete</button>
										</form>
									</div>
								</c:when>
								<c:otherwise>
									<a href="/books/${book.id }/borrow"
										class="text-decoration-none">borrow</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p class="mt-5">Books I'm Borrowing...</p>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${borrowedBooks}">
					<tr>
						<td class="align-middle">${book.id }</td>
						<td class="align-middle"><a href="/books/${book.id }">${book.title }</a></td>
						<td class="align-middle">${book.author }</td>
						<td class="align-middle">${book.poster.name }</td>
						<td class="align-middle"><a href="/books/${book.id }/return"
							class="text-decoration-none">return</a></td>
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
