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
<title>Lookify!</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>

<body>
	<div class="container pt-3">
		<div class="row">
			<a href="/songs/new" class="link-primary col">Add New</a> 
			<a href="/search/topTen" class="link-primary col">Top Songs</a>
			<form action="/search" method="get" class="col row">
				<div class="col">
					<input type="text" name="artist" id="artist"
						placeholder="Artist Name" class="form-control">
				</div>
				<div class="col">
					<button class="btn btn-secondary">Search Artists</button>
				</div>
			</form>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="song" items="${songs }">
					<tr>
						<td class="align-middle"><a href="/songs/${song.id }">${song.title}</a></td>
						<td class="align-middle">${song.rating}</td>
						<td class="align-middle">
							<form action="/songs/delete/${song.id}" method="POST"
								class="col-2">
								<input type="hidden" name="_method" value="delete" />
								<button class="btn btn-danger">Delete</button>
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