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
<title>Task Details</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-5">
		<div class="d-flex justify-content-between">
			<h1 class="text-primary">Project: <c:out
					value="${project.title }"></c:out>
			</h1> <a href="/dashboard">Back to Dashboard</a>
		</div>
		<p class="mb-5">
			Project Lead:
			<c:out value="${project.creator.firstName }"></c:out>
		</p>
		<form:form action="/projects/${project.id }/tasks" method="post"
			modelAttribute="task" class="form">
			<form:errors path="content" class="alert alert-danger" element="p"
				delimiter="</p><p class='alert alert-danger'>" />
			<div class="row mb-3">
				<form:label path="content" class="form-label col-3">Add a task ticket for this team:</form:label>
				<form:textarea class="form-control col" path="content" />
			</div>
			<div class="d-flex justify-content-end">
				<input type="submit" value="Submit" class="btn btn-primary" />
			</div>
		</form:form>
		<c:forEach var="task" items="${project.tasks }">
			<p class="fw-bold">Added by <c:out value="${task.user.firstName }"></c:out> at <fmt:formatDate type="both" pattern="KK:mmaa MMM d" value="${task.createdAt}"></fmt:formatDate>: </p>
			<p><c:out value="${task.content }"></c:out> </p>
		</c:forEach>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
