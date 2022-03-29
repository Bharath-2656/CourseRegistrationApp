<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
label {
	display: inline-block;
	width: 200px;
	margin: 5px;
	text-align: left;
}

button {
	padding: 10px;
	margin: 10px;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Welcome Student</h1>
		<h2>Add Details</h2>
		<form action="register" method="post" modelAttribute="user">
			<!-- <label path="id">ID</label> <input type="text" name="id"><br> -->
			<label>NAME</label><input type="text" name="name"><br>
			<label>AGE</label> <input type="text" name="age"><br>
			<label>EMAIL</label> <input type="text" name="email"><br>
			<label>PASSWORD</label> <input type="password" name="password"><br>
			<label>CONFIRM PASSWORD</label> <input type="password" name="confirm_password"><br>
			<button>Register</button>
			<br>
		</form>
	</div>
</body>
</html>