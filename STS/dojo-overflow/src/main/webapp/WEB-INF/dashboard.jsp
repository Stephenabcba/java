<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Questions Dashboard</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
    <div class="container pt-5">
        <h1 class="text-primary">Questions Dashboard</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Question</th>
                    <th>Tags</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="question" items="${questions}">
                <tr>
                    <td class="align-middle"><a href="/<c:out value="questions/${question.id }"/>"><c:out value="${question.content }"/></a></td>
                    <td class="align-middle"><c:out value="${question.formatTags()}"/></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <p class="text-end my-5"><a href="/questions/new">New Question</a></p>
    </div>

    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
