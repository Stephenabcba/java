<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login &#38; Registration</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for internal CSS -->
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container pt-5">
		<h1>Welcome!</h1>
		<p>Join our growing community.</p>
		<div class="row">
			<div class="col-5">
				<h2>Register</h2>
				<form:form action="/register" method="post" modelAttribute="newUser"
					class="form">
					<form:errors path="name" class="alert alert-danger" element="p"
						delimiter="</p><p class='alert alert-danger'>" />
					<form:errors path="email" class="alert alert-danger" element="p"
						delimiter="</p><p class='alert alert-danger'>" />
					<form:errors path="password" class="alert alert-danger" element="p"
						delimiter="</p><p class='alert alert-danger'>" />
					<form:errors path="passwordConfirm" class="alert alert-danger"
						element="p" delimiter="</p><p class='alert alert-danger'>" />
					<p>
						<form:label path="name" class="form-label">User Name:</form:label>
						<form:input class="form-control" path="name" />
					</p>
					<p>
						<form:label path="email" class="form-label">Email:</form:label>
						<form:input class="form-control" path="email" />
					</p>
					<p>
						<form:label path="password" class="form-label">Password:</form:label>
						<form:input class="form-control" type="password" path="password" />
					</p>
					<p>
						<form:label path="passwordConfirm" class="form-label">Confirm PW:</form:label>
						<form:input class="form-control" type="password"
							path="passwordConfirm" />
					</p>
					<input type="submit" value="Register" class="btn btn-primary" />
				</form:form>
			</div>
			<div class="col-5 offset-1">
				<h2>Log in</h2>
				<form:form action="/login" method="post" modelAttribute="newLogin"
					class="form">
					<form:errors path="email" id="" class="alert alert-danger" element="p"
						delimiter="</p><p class='alert alert-danger'>" />
					<form:errors path="password" id="" class="alert alert-danger" element="p"
						delimiter="</p><p class='alert alert-danger'>" />
					<p>
						<form:label path="email" class="form-label">Email:</form:label>
						<form:input class="form-control" path="email" />
					</p>
					<p>
						<form:label path="password" class="form-label">Password:</form:label>
						<form:input class="form-control" type="password" path="password" />
					</p>
					<input type="submit" value="Log In" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<!-- internal script -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>
