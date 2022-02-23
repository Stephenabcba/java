<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Project Manager Dashboard</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for internal CSS -->
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container pt-5">
		<div class="d-flex justify-content-between align-items-center">
			<h1>Welcome, <c:out value="${loggedin_name }" />!
			</h1>
			<form action="/logout" method="post">
				<button class="text-primary bg-transparent border-0 p-0">Log
					Out</button>
			</form>
		</div>
		<div class="d-flex align-items-center justify-content-between">
			<p class="m-0 align-middle">All Projects</p>
			<a href="/projects/new" class="btn btn-primary">+ new project</a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${projects}">
					<c:if
						test="${project.creator.id != uuid && project.participants.contains(user) == false }">
						<tr>
							<td class="align-middle"><a href="/projects/${project.id }"><c:out value="${project.title }"></c:out></a></td>
							<td><c:out value="${project.creator.firstName }"></c:out></td>
							<td><fmt:formatDate type="date" pattern="MMM dd" value="${project.dueDate}"></fmt:formatDate>
							</td>
							<td>
								<form action="/projects/${project.id }/joinTeam" method="POST">
									<input type="hidden" name="_method" value="PUT" />
									<button class="bg-transparent border-0 text-primary p-0">Join
										team</button>
								</form>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		<table class="table">
			<thead>
				<tr>
					<th>Project</th>
					<th>Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${user.createdProjects}">
					<tr>
						<td class="align-middle"><a href="/projects/${project.id }"><c:out value="${project.title }"></c:out></a></td>
						<td><c:out value="${project.creator.firstName }"></c:out></td>
						<td><fmt:formatDate type="date" pattern="MMM dd" value="${project.dueDate}"></fmt:formatDate>
						</td>
						<td><a
							href="/projects/${project.id }/edit" class="text-decoration-none">edit</a></td>
					</tr>
				</c:forEach>
				<c:forEach var="project" items="${user.participatingProjects}">
					<tr>
						<td class="align-middle"><a href="/projects/${project.id }"><c:out value="${project.title }"></c:out></a></td>
						<td><c:out value="${project.creator.firstName }"></c:out></td>
						<td><fmt:formatDate type="date" pattern="MMM dd" value="${project.dueDate}"></fmt:formatDate>
						</td>
						<td>
							<form action="/projects/${project.id }/leaveTeam" method="POST">
								<input type="hidden" name="_method" value="PUT" />
								<button class="bg-transparent border-0 text-primary p-0">Leave
									team</button>
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
	<!-- internal script -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>
