<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex05-choose.jsp</title>
</head>
<body>

<h1>ex05-choose.jsp</h1>
<hr>

<c:choose>
	<c:when test="${empty param.age }">
		<form>
			<p><input type="number" name="age" placeholder="나이 입력"></p>
		</form>
	</c:when>
	<c:when test="${param.age >= 20 and param.age <= 100 }">
		<h3>당신은 성인입니다</h3>
	</c:when>
	<c:when test="${0 < param.age and param.age < 20 }">
		<h3>당신은 미성년자입니다</h3>
	</c:when>
	<c:otherwise>
		<h3>범위를 초과했습니다</h3>
	</c:otherwise>
</c:choose>

<a href="ex05-choose.jsp"><button>다시</button></a>











</body>
</html>