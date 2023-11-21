<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="phonebook.PhoneBookDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<c:set var="dao" value="${PhoneBookDAO.getInstance() }" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>day10 - phonebook</title>
</head>
<body>

${dao }

<h1><a href="${cpath }">대문페이지</a></h1>
<ul>
	<li><a href="${cpath }/list.jsp">목록</a></li>
	<li><a href="${cpath }/add.jsp">추가</a></li>
</ul>


