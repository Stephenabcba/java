<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reading Books</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- for internal CSS -->
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <div class="container pt-5">
        <h1>${book.title}</h1>
        <p>Description: ${book.description }</p>
        <p>Language: ${book.language }</p>
        <p>Number of Pages: ${book.numberOfPages }</p>
    </div>

    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <!-- internal script -->
    <script type="text/javascript" src="/js/script.js"></script>
</body>
</html>