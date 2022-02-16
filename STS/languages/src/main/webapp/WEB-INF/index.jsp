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
<title>Languages</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-5">
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="language" items="${languages }">
					<tr>
						<td class="align-middle"><a href="/languages/${language.id }">${language.name }</a></td>
						<td class="align-middle">${language.creator }</td>
						<td class="align-middle">${language.version }</td>
						<td class="row align-items-center"><a href="/languages/${language.id }/edit" class="col-1">edit</a>
							<form action="/languages/${language.id }" method="POST" class="col-1 offset-md-1">
								<input type="hidden" name="_method" value="delete">
								<button class="btn btn-danger">Delete</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:form action="/languages" method="post" modelAttribute="language"
			class="form">
			<p>
				<form:errors path="name" class="text-danger" />
			</p>
			<p>
				<form:errors path="creator" class="text-danger" />
			</p>
			<p>
				<form:errors path="version" class="text-danger" />
			</p>
			<p>
				<form:label path="name" class="form-label">Name:</form:label>
				<form:input class="form-control" path="name" />
			</p>
			<p>
				<form:label path="Creator" class="form-label">Creator</form:label>
				<form:input class="form-control" path="creator" />
			</p>
			<p>
				<form:label path="version" class="form-label">Version</form:label>
				<form:input class="form-control" path="version" />
			</p>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>