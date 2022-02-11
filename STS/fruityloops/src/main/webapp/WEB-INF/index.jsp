<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Fruit Store</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for internal CSS -->
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<h1 class="text-secondary my-4">Fruit Store</h1>
		<div class="bg-secondary p-4">
			<table class="table bg-light m-0">
				<thead>
					<tr>
						<th>Name</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="fruit" items="${ fruits }">
						<tr>
							<td><c:out value="${ fruit.name }"/></td>
							<td><c:out value="${ fruit.price }"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<!-- internal script -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>