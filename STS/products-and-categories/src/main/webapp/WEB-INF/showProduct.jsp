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
<title>Product Page</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-5">
		<div class="d-flex justify-content-start mb-5">
			<h1 class="text-primary"><c:out value="${product.name}" /></h1>
		</div>
		<div class="row">
			<p class="col-2">Price:</p>
			<p class="col-2">
				<fmt:formatNumber value="${product.price}" type="currency"
					minFractionDigits="2" maxFractionDigits="2" />
			</p>
			<p class="col-2">Description:</p>
			<p class="col">
				<c:out value="${product.description}" />
			</p>
		</div>
		<div class="row">
			<div class="col">
				<h2>Categories:</h2>
				<ul class="list-group">
					<c:forEach var="containCategory" items="${ containCategories}">
						<li class="list-group-item"><c:out
								value="${containCategory.name }"></c:out></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col">
				<form action="/products/<c:out value="${product.id }"/>/addCategory"
					class="form" method="POST">
					<div class="row">
						<p class="col-3">
							<label for="addCategory">Add Category:</label>
						</p> 
						<select name="addCategory" id="addCategory" class="form-select col">
							<c:forEach var="notContainCategory" items="${notContainCategories }">
								<option value="${notContainCategory.id }"><c:out
										value="${notContainCategory.name }"></c:out></option>
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
