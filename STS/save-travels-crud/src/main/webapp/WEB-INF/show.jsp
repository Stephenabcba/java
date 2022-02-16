<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Save Travels</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
    <div class="container pt-5">
        <div class="d-flex justify-content-between mb-5">
        	<h1 class="text-primary">Expense Details</h1>
        	<a href="/expenses">Go back</a>
        </div>
        <div class="row">
        	<p class="col-4">Expense Name:</p>
        	<p class="col">${expense.name }</p>
        </div>
        <div class="row">
        	<p class="col-4">Expense Description:</p>
        	<p class="col">${expense.description}</p>
        </div>
        <div class="row">
        	<p class="col-4">Vendor:</p>
        	<p class="col">${expense.vendor }</p>
        </div>
        <div class="row">
        	<p class="col-4">Amount Spent:</p>
        	<p class="col">$${expense.amount }</p>
        </div>
        
    </div>

    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>