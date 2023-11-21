<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board2.*, member.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%	request.setCharacterEncoding("UTF-8"); %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<c:set var="boardDAO" value="${BoardDAO.getInstance() }" />
<c:set var="memberDAO" value="${MemberDAO.getInstance() }" />
<c:set var="fileUtil" value="${FileUtil.getInstance() }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day18 - 파일 첨부 게시판</title>
<link rel="stylesheet" type="text/css" href="${cpath }/style/style.css">
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
	#login {
		height: 33px;
		text-align: right;
		padding-right: 20px;
	}
	nav > ul {
		display: flex;
		justify-content: space-around;
		padding-left: 0;
		margin-bottom: 20px;
		list-style: none;
	}
	header {
		border-bottom: 1px solid black;
		margin-bottom: 20px;
	}
	header + div {
		width: 900px;
		margin: auto;
	}
	table.boardList {
		border-collapse: collapse;
		width: 750px;
		margin: auto;
	}
	table.boardList td,
	table.boardList th {
		padding: 10px;
	}
	table.boardList > thead {
		background-color: black;
		color: white;
	}
	table.boardList > thead th:nth-child(2) {
		width: 500px;
	}
	table.boardList > tbody > tr {
		border-bottom: 1px solid #dadada;
	}
	table.boardList > tbody > tr:hover {
		background-color: #eee;
	}
	div.sb {
		width: 750px;
		margin: 20px auto;
		display: flex;
		justify-content: space-between;
	}
	table.boardView {
		border-collapse: collapse;
		border: 2px solid black;
		box-shadow: 5px 5px 5px grey;
		width: 750px;
		margin: auto;
	}
	table.boardView td,
	table.boardView th {
		padding: 10px 20px;
	}
	table.boardView td:first-child {
		width: 150px;
	}
	table.boardView tr {
		border-bottom: 1px solid #dadada;
	}
	table.boardView img {
		height: 200px;
	}
</style>
</head>
<body>

<header>
	<h1><a href="${cpath }">day18</a></h1>
	<div id="login">
		<c:if test="${not empty login }">
			<b>${login.userid } (${login.username })</b>
		</c:if>
	</div>
	<nav>
		<ul>
			<c:if test="${empty login }">
				<li><a href="${cpath }/member/login.jsp">로그인</a></li>
			</c:if>
			<c:if test="${not empty login }">
				<li><a href="${cpath }/member/logout.jsp">로그아웃</a></li>
			</c:if>
			<li><a href="${cpath }/board/list.jsp">게시판</a></li>
		</ul>
	</nav>
</header>











