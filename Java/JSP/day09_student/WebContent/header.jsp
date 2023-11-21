<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="student.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%	request.setCharacterEncoding("UTF-8"); %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<c:set var="dao" value="${StudentDAO.getInstance() }" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>day09_student</title>
<style>
	a {
		text-decoration: none;
		color: inherit;
	}
	a:hover {
		text-decoration: underline;
	}
	h1 {
		text-align: center;
	}
	header {
		border-bottom: 2px solid darkgrey;
	}
	nav > ul {
		list-style: none;
		padding-left: 0;
		display: flex;
		justify-content: space-around;
	}
	nav > ul > li {
		padding: 20px;
		font-size: 1.2em;
		font-weight: bold;
	}
	
	table {
		border-collapse: collapse;
		border: 2px solid black;
		margin: 20px auto;
	}
	td, th {
		padding: 10px;
		border: 1px solid grey;
	} 
	thead {
		background-color: #eee;
	}
</style>
</head>
<body>

<header>
	<h1><a href="${cpath }">student (day09)</a></h1>
	<nav>
		<ul>
			<li><a href="${cpath }/list.jsp">목록</a></li>
			<li><a href="${cpath }/add.jsp">추가</a></li>
		</ul>
	</nav>
</header>














