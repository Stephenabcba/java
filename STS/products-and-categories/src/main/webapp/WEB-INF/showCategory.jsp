<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Category Page</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-5">
		<div class="d-flex justify-content-start mb-5">
			<h1 class="text-primary"><c:out value="${category.name}" /></h1>
		</div>
		<div class="row">
			<div class="col">
				<h2>Products:</h2>
				<ul class="list-group">
					<c:forEach var="containProduct" items="${ containProducts}">
						<li class="list-group-item"><c:out
								value="${containProduct.name }"></c:out></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col">
				<form action="/categories/<c:out value="${category.id }"/>/addProduct"
					class="form" method="POST">
					<div class="row">
						<p class="col-3">
							<label for="addProduct">Add Product:</label>
						</p> 
						<select name="addProduct" id="addProduct" class="form-select col">
							<c:forEach var="notContainProduct" items="${notContainProducts }">
								<option value="${notContainProduct.id }"><c:out
										value="${notContainProduct.name }"></c:out></option>
							</c:forEach>
						</select>
					</div>
					<button class="btn btn-primary">Add</button>
				</form>

			</div>
		</div>

	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
