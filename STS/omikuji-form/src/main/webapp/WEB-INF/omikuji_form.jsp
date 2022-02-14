<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Omikuji</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- for internal CSS -->
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <div class="container pt-5">
        <h1>Send an Omikuji!</h1>
        <form action="/omikuji/submit" method="POST" class="form border p-5">
        	<label for="pick_number" class="form-label">Pick any number from 5 to 25</label>
			<input type="number" name="pick_number" id="pick_number" class="form-control" value="5"/>
			<label for="city_name" class="form-label">Enter the name of any city.</label>
			<input type="text" name="city_name" id="city_name" class="form-control"/>
			<label for="person_name" class="form-label">Enter the name of any real person:</label>
			<input type="text" name="person_name" id="person_name" class="form-control"/>
			<label for="hobby" class="form-label">Enter professional endeavor or hobby:</label>
			<input type="text" name="hobby" id="hobby" class="form-control"/>
			<label for="living_thing" class="form-label">Enter any type of living thing.</label>
			<input type="text" name="living_thing" id="living_thing" class="form-control"/>
			<label for="something_nice" class="form-label">Say something nice to someone:</label>
        	<textarea rows="" cols="" name="something_nice" class="form-control mb-3"></textarea>
        	<p>Send and show a friend</p>
        	<button class="btn btn-primary">Send</button>
        </form>
    </div>

    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <!-- internal script -->
    <script type="text/javascript" src="/js/script.js"></script>
</body>
</html>