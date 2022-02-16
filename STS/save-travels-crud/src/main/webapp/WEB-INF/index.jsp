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
        <h1 class="text-primary">Save Travels</h1>
        <table class="table">
        	<thead>
        		<tr>
        			<th>Expense</th>
        			<th>Vendor</th>
        			<th>Amount</th>
        			<th>Actions</th>
        		</tr>
        	</thead>
        	<tbody>
        		<c:forEach var="expense" items="${expenses }">
        		<tr>
        			<td class="align-middle"><a href="/expenses/${expense.id }">${expense.name }</a></td>
        			<td class="align-middle">${expense.vendor }</td>
        			<td class="align-middle">$${expense.amount }</td>
        			<td class="align-middle">
        			<div class="row align-items-center">
        				<a href="/expenses/edit/${expense.id}" class="col-2">edit</a>
        				<form action="/expenses/delete/${expense.id}" method="POST" class="col-2">
        					<input type="hidden" name="_method" value="delete" />
        					<button class="btn btn-danger">Delete</button>
        				</form>
        			</div>
        			</td>
        		</tr>
        		</c:forEach>
        	</tbody>
        </table>
        <h2 class="text-primary">Add an expense:</h2>
        <form:form action="/expenses" method="post" modelAttribute="expense" class="form">
		    <p>
		    	<form:errors path="name" class="text-danger"/>
		    </p>
		    <p>
		    	<form:errors path="vendor" class="text-danger"/>
		    </p>
		    <p>
		    	<form:errors path="amount" class="text-danger"/>
		    </p>
		    <p>
		    	<form:errors path="description" class="text-danger"/>
		    </p>
		    <p>
		        <form:label path="name" class="form-label">Expense Name:</form:label>
		        <form:input class="form-control" path="name"/>
		    </p>
		    <p>
		        <form:label path="vendor" class="form-label">Vendor:</form:label>
		        <form:input class="form-control" path="vendor"/>
		    </p>
		    <p>
		        <form:label path="amount" class="form-label">Amount:</form:label>
		        <form:input class="form-control" type="number" path="amount"/>
		    </p> 
		    <p>
		        <form:label path="description" class="form-label">Description:</form:label>
		        <form:textarea class="form-control" path="description"/>
		    </p>   
		    <input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>    
    </div>

    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>