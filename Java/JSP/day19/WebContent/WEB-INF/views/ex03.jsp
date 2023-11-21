<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03.jsp</title>
</head>
<body>

<h1>ex03.jsp</h1>
<hr>

<form method="POST">
	<p>
		${msg }
		<input type="number" name="answer" min="0" max="100" autofocus>
		<input type="submit">	
	</p>
</form>

</body>
</html>