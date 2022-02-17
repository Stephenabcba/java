<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Dormitory</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
    <div class="container pt-5">
        <div class="d-flex justify-content-between mb-5">
            <h1 class="text-primary">${dorm.name } Dormitory</h1>
            <a href="/dorms">Go back</a>
        </div>
        <c:if test="${dormlessStudents.size() > 0 }"> 
        <form action="/dorms/${dorm.id }/add" class="form" method="post">
        <label for="newStudent">Students:</label>
        <select name="newStudentId" id="student" class="form-select mb-3">
        	<c:forEach var="newStudent" items="${dormlessStudents }">
        	<option value="${newStudent.id }">${newStudent.name }</option>
        	</c:forEach>
        </select>               	
        <button class="btn btn-primary">Add Student to Dorm!</button>
        </form>
        </c:if>
        <table class="table">
        	<thead>
        		<tr>
        			<th>Name</th>
        			<th>Action</th>
        		</tr>
        	</thead>
        	<tbody>
        		<c:forEach var="student" items="${dorm.students }">
        			<tr>
        				<td>${student.name }</td>
        				<td>
        					<form action="/dorms/${dorm.id }/removeStudent" method="POST">
        					<input type="hidden" name="_method" value="delete">
        					<button class="btn btn-danger" name="studentId" value="${student.id }">Remove</button>
        					</form>
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
