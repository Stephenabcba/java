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
<title>Question Profile</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-5">
		<div class="d-flex justify-content-between mb-5">
			<h1><c:out value="${question.content}" /></h1> <a href="/questions">Go
				back</a>
		</div>
		<div class="d-flex align-items-center mb-5">
			<h2 class="me-3">Tags:</h2>
			<c:forEach var="tag" items="${question.tags }">
				<div
					class="bg-secondary bg-opacity-25 px-3 py-1 border me-3 rounded-pill">
					<p class="m-0 p-0">
						<c:out value="${tag.subject }" />
					</p>
				</div>
			</c:forEach>
		</div>
		<div class="row">
			<ul class="col-5 list-group">
				<li class="list-group-item bg-secondary text-light">Answers</li>
				<c:forEach var="answer" items="${question.answers }">
					<li class="list-group-item"><c:out value="${answer.content }"></c:out>
					</li>
				</c:forEach>
			</ul>
			<div class="col-6 offset-1">
				<h2>Add your answer:</h2>
				<form:form action="/questions/${question.id }/addAnswer"
					method="post" modelAttribute="answer" class="form">
					<form:errors path="content" class="alert alert-danger" element="p" delimiter="</p><p class='alert alert-danger'>"/>

					<div class="row">
						<p class="col-2">
							<form:label path="content" class="form-label">Answer:</form:label>
						</p>
						<p class="col">
							<form:textarea class="form-control" path="content" />
						</p>
					</div>

					<input type="submit" value="Answer it!" class="btn btn-primary" />
				</form:form>
			</div>
		</div>

	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>