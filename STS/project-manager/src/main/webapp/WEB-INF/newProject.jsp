<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create a Project</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
    <div class="container pt-5">
        <h1 class="text-primary">Create a project:</h1>
        <form:form action="/projects/new" method="post" modelAttribute="project" class="form">
                <form:errors path="title" class="alert alert-danger" element="p" delimiter="</p><p class='alert alert-danger'>"/>
                <form:errors path="description" class="alert alert-danger" element="p" delimiter="</p><p class='alert alert-danger'>"/>
                <form:errors path="dueDate" class="alert alert-danger" element="p" delimiter="</p><p class='alert alert-danger'>"/>
            <p>
                <form:label path="title" class="form-label">Project Title:</form:label>
                <form:input class="form-control" path="title"/>
            </p>
            <p>
                <form:label path="description" class="form-label">Project Description:</form:label>
                <form:textarea class="form-control" path="description"/>
            </p>
            <p>
                <form:label path="dueDate" class="form-label">Due Date::</form:label>
                <form:input class="form-control" type="date" path="dueDate"/>
            </p>    
            <input type="submit" value="Submit" class="btn btn-primary"/>
        </form:form>    
    </div>

    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
