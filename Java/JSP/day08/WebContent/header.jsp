<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="youtube.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<%	request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day08 - youtube</title>
<style>
	body {
		background-color: #f5f6f7;
	}
	header {
		border-bottom: 0.5px solid #dadada;
	}
	header, main {
		width: 900px;
		margin: 0 auto;
		background-color: white;
		padding: 10px;
		box-sizing: border-box;
	}
	body, h1, h2, h4, h5, h6, div, span {
		margin: 0;
		padding: 0;
	}
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
	nav > ul {
		list-style: none;
		padding-left: 0;
		display: flex;
		justify-content: space-around;
		font-size: 1.2em;
		font-weight: bold;
	}
	
	/* list.jsp 에 적용할 스타일 */
	#root {
		width: 100%;
	}
	.wrap {
		display: flex;
		flex-flow: wrap;
		width: 820px;
		margin: auto;
	}
	.item {
		width: 250px;
		margin: 10px;
	}
	.thumbnail > a > img {
		width: 250px;
	}
	.title {
		font-weight: bold;
	}
	.channel {
		font-size: 0.9em;
		color: grey;
	}
</style>
</head>
<body>

<header>
	<h1><a href="${cpath }">day08 - youtube</a></h1>
	<nav>
		<ul>
			<li><a href="${cpath }/list.jsp">목록</a></li>
			<li><a href="${cpath }/add.jsp">추가</a></li>
		</ul>
	</nav>
</header>

<!-- end of header.jsp -->







