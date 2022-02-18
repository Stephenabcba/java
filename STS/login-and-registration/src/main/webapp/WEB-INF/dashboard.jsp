<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- for internal CSS -->
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <div class="container pt-5">
        <h1>Welcome, ${loggedin_name }!</h1>
        <p>This is your dashboard. Nothing to see here yet.</p>
        <form action="/logout" method="post">
        	<button class="text-primary bg-transparent border-0 p-0">Log Out</button>
        </form>
    </div>

    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <!-- internal script -->
    <script type="text/javascript" src="/js/script.js"></script>
</body>
</html>
