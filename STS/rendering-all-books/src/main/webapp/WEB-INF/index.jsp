<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Read Share</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- for internal CSS -->
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <div class="container pt-5">
        <h1>All Books</h1>
        <table class="table">
        	<thead>
        		<tr>
        			<th>ID</th>
        			<th>Title</th>
        			<th>Language</th>
        			<th># Pages</th>
        		</tr>
        	</thead>
        	<tbody>
        		<c:forEach var="book" items="${books }">
        			<tr>
        				<td>${book.id }</td>
        				<td><a href="/books/${book.id }">${book.title }</a></td>
        				<td>${book.language }</td>
        				<td>${book.numberOfPages }</td>
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