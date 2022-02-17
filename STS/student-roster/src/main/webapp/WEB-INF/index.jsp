<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dormitories</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
    <div class="container pt-5">
        <div class="d-flex justify-content-between align-items-center">
        	<h1 class="text-primary">Dormitories</h1>
        	<a href="/dorms/new">New Dorm</a>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th>Name</th>

                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dorm" items="${dorms }">
                <tr>
                    <td class="align-middle"><a href="/dorms/${dorm.id }">${dorm.name }</a></td>
                    <td class="align-middle">
                    <div class="row align-items-center">
                        <a href="" class="col-2">edit (not implemented)</a>
                    </div>
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
