<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ninja Gold Game</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
    <div class="container pt-5">
        <div class="row align-items-center mb-3">
        	<h2 class="col-2">Your Gold:</h2>
        	<h2 class="col-2 border p-2 text-center">${gold }</h2>
        	<a href="/gold/reset" class="col-2 offset-6 link-primary text-end">Reset Progress</a>
        </div>
        <div class="row gx-4 mb-5">
        	<div class="col">
        		<div class="card">
        			<div class="card-body">
        				<h2>Farm</h2>
        				<p>(earns 10-20 gold)</p>
        				<form action="/gold/make_gold" method="POST">
        					<input type="hidden" name="income_type" value="farm"/>
        					<button class="btn btn-primary">Find Gold!</button>
        				</form>
        			</div>
        		</div>
        	</div>
        	<div class="col">
        		<div class="card">
        			<div class="card-body">
        				<h2>Cave</h2>
        				<p>(earns 5-10 gold)</p>
        				<form action="/gold/make_gold" method="POST">
        					<input type="hidden" name="income_type" value="cave"/>
        					<button class="btn btn-primary">Find Gold!</button>
        				</form>
        			</div>
        		</div>
        	</div>
        	<div class="col">
        		<div class="card">
        			<div class="card-body">
        				<h2>House</h2>
        				<p>(earns 2-5 gold)</p>
        				<form action="/gold/make_gold" method="POST">
        					<input type="hidden" name="income_type" value="house"/>
        					<button class="btn btn-primary">Find Gold!</button>
        				</form>
        			</div>
        		</div>
        	</div>
        	<div class="col">
        		<div class="card">
        			<div class="card-body">
        				<h2>Casino!</h2>
        				<p>(earns/takes 0-50 gold)</p>
        				<form action="/gold/make_gold" method="POST">
        					<input type="hidden" name="income_type" value="casino"/>
        					<button class="btn btn-primary">Find Gold!</button>
        				</form>
        			</div>
        		</div>
        	</div>
        	<div class="col">
        		<div class="card">
        			<div class="card-body">
        				<h2>Spa</h2>
        				<p>(takes 5-20 gold)</p>
        				<form action="/gold/make_gold" method="POST">
        					<input type="hidden" name="income_type" value="spa"/>
        					<button class="btn btn-primary">Find Gold!</button>
        				</form>
        			</div>
        		</div>
        	</div>
        </div>
        <h2>Activities</h2>
        <p>${message }</p>
    </div>

    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>