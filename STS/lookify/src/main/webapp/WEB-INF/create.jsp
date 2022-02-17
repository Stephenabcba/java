<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <div class="container pt-5">
        <div class="d-flex justify-content-between align-items-center">
        	<h1 class="text-primary">Add a Song</h1>
            <a href="/dashboard" class="link-primary">Dashboard</a>
        </div>
        <form:form action="/songs/new" method="post" modelAttribute="song" class="form">
            <p>
                <form:errors path="title" class="text-danger" />
            </p>
            <p>
                <form:errors path="artist" class="text-danger" />
            </p>
            <p>
                <form:errors path="rating" class="text-danger" />
            </p>
            <p>
                <form:label path="title" class="form-label">Name:</form:label>
                <form:input class="form-control" path="title" />
            </p>
            <p>
                <form:label path="artist" class="form-label">Artist:</form:label>
                <form:input class="form-control" path="artist" />
            </p>
            <p>
                <form:label path="rating" class="form-label">Rating:</form:label>
                <form:input class="form-control" type="number" path="rating" />
            </p>
            <input type="submit" value="Submit" class="btn btn-primary" />
        </form:form>
    </div>
    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>