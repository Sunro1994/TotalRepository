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


	<h1><a href="${cpath}/board/list">게시판</a></h1>
	<p><a href="${cpath}/ex04"><button>파일업로드 예제1</button></a></p>
	<p><a href="${cpath}/ex05"><button>파일업로드 예제2 (DTO)</button></a></p>
	<p><a href="${cpath}/ex06"><button>파일업로드 예제3 (use component)</button></a></p>
	<hr>
	

