<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Save Travels</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-5">
		<div class="d-flex justify-content-between align-items-center">
			<div>
				<h1 class="text-primary">Exit Expense</h1>
			</div>
			<div>
				<a href="/expenses" class="link-primary">Go back</a>
			</div>
		</div>
		<form:form action="/expenses/edit/${expense.id }" method="post" modelAttribute="expense"
			class="form">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:errors path="name" class="text-danger" />
			</p>
			<p>
				<form:errors path="vendor" class="text-danger" />
			</p>
			<p>
				<form:errors path="amount" class="text-danger" />
			</p>
			<p>
				<form:errors path="description" class="text-danger" />
			</p>
			<p>
				<form:label path="name" class="form-label">Expense Name:</form:label>
				<form:input class="form-control" path="name"/>
			</p>
			<p>
				<form:label path="vendor" class="form-label">Vendor:</form:label>
				<form:input class="form-control" path="vendor"/>
			</p>
			<p>
				<form:label path="amount" class="form-label">Amount:</form:label>
				<form:input class="form-control" type="number" path="amount"/>
			</p>
			<p>
				<form:label path="description" class="form-label">Description:</form:label>
				<form:textarea class="form-control" path="description"/>
			</p>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>