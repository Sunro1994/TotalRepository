<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <c:set  value="${pageContext.request.contextPath }" var="cpath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<fieldset>
<legend>따로 받기</legend>
<form method="POST" action="${cpath}/ex03/post1">
	<p><input type="text" name="userid" placeholder="ID" required></p>
	<p><input type="password" name="userpw" placeholder="PW" required></p>
	<p><input type="submit"></p>
</form>
</fieldset>

<fieldset>
<legend>HashMap으로 받기</legend>
<form method="POST" action="${cpath}/ex03/post2">
	<p><input type="text" name="userid" placeholder="ID" required></p>
	<p><input type="password" name="userpw" placeholder="PW" required></p>
	<p><input type="submit"></p>
</form>
</fieldset>

<fieldset>
<legend>DTO로 받기</legend>
<form method="POST" action="${cpath}/ex03/post3">
	<p><input type="text" name="userid" placeholder="ID" required></p>
	<p><input type="password" name="userpw" placeholder="PW" required></p>
	<p><input type="submit"></p>
</form>
</fieldset>

</body>
</html>