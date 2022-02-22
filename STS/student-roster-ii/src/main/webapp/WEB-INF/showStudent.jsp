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
<title>Show Student</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container pt-5">
		<h1 class="text-primary"><c:out value="${student.name }"></c:out>
		</h1>
		<form action="/students/${student.id }/addClass" method="POST"
			class="form mb-3">
			<input type="hidden" name="_method" value="put" /> 
			<div class="row align-items-center mb-3">
				<label for="classToAdd" class="form-label col col-lg-1">Classes:</label> 
				<select name="classToAdd"
					id="classToAdd" class="form-select col">
				<c:forEach var="swclass" items="${classes }">
					<option value="${swclass.id }"><c:out
							value="${swclass.name }"></c:out>
					</option>
				</c:forEach>
				</select>
			</div>
			<button class="btn btn-primary">Add</button>
		</form>
		<h2>Your Schedule</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Class Name</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="swclass" items="${student.classes}">
					<tr>
						<td class="align-middle"><c:out value="${swclass.name }"></c:out>
						</td>
						<td>
							<form action="/students/${id }/dropClass" method="POST" class="">
								<input type="hidden" name="_method" value="put"> <input
									type="hidden" name="classToDrop" value="${swclass.id }" />
								<button class="btn btn-danger">Drop</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
