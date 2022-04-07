<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Registration Home Page</title>
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
		<h2>Area of Interest</h2>
		<label for="intrest">Choose area of interest:</label> <select name="intrest" id="intrest">
			<option value="Web development">Web development</option>
			<option value="Cloud Technology">Cloud Technology</option>
			<option value="Basic Programming">Basic Programming</option>
		</select>
		<br><br><button onClick="JavaScript:window.location='home';">Back
			to Home Page</button>
	</div>
</body>
</html>