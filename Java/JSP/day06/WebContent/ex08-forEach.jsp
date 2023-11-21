<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex08-forEach.jsp</title>
</head>
<body>

<h1>ex08-forEach.jsp</h1>
<hr>

<h3>forEach에서 숫자를 이용하여 반복문을 사용하기</h3>

<ul>
	<c:forEach var="i" begin="1" end="9" step="1">
	<li>7 x ${i } = ${7 * i }</li>
	</c:forEach>
</ul>

<h3>step은 0보다 작거나 같을 수 없다</h3>
<ul>
	<c:forEach var="i" begin="0" end="5" step="1">
	<li>${5 - i }</li>
	</c:forEach>
</ul>

</body>
</html>








