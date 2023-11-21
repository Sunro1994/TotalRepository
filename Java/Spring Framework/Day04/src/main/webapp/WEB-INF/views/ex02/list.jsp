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
<h1>리스트</h1>
<hr>
<c:forEach var="dto" items="${list }">
	<p>${dto.id}</p>
	<p><a href="${cpath}/ex02/view/${dto.id}">${dto.name}</a></p>
</c:forEach>


</body>
</html>