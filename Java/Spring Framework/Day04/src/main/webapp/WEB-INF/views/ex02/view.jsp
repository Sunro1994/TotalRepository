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
	<p>단일조회 : ${param.id }</p>
	<p>${dto.id}</p>
	<p>${dto.name}</p>
	<p>${dto.type}</p>
</body>
</html>