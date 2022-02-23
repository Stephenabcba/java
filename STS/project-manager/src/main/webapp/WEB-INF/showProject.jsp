<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project Details</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
    <div class="container pt-5">
        <div class="d-flex justify-content-between mb-5">
            <h1 class="text-primary">Project Details</h1>
            <a href="/dashboard">Back to Dashboard</a>
        </div>
        <div class="row">
            <p class="col-2">Project:</p>
            <p class="col"><c:out value="${project.title}"/></p>
        </div>
        <div class="row">
            <p class="col-2">Description:</p>
            <p class="col"><c:out value="${project.description}"/></p>
        </div>
        <div class="row">
            <p class="col-2">Due Date:</p>
            <p class="col"><fmt:formatDate type="date" pattern="MM/dd/yyyy" value="${project.dueDate}"></fmt:formatDate></p>
        </div>
        <a href="/projects/${project.id }/tasks">See tasks!</a>
    </div>

    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
