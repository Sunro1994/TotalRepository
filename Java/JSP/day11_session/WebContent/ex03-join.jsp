<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03-join.jsp</title>
</head>
<body>

<h1>ex03-join.jsp</h1>
<hr>

<h3>회원가입</h3>

<form method="POST" action="ex03-action.jsp">
	<p><input type="text" name="userid" placeholder="ID" required></p>
	<p><input type="password" name="userpw" placeholder="Password" required></p>
	<p><input type="text" name="username" placeholder="Name" required></p>
	<p><input type="email" name="email" placeholder="foo@bar.com" required></p>
	<p>생년월일 : <input type="date" name="birth" required></p>
	<p><input type="submit" value="회원가입"></p>
</form>

</body>
</html>