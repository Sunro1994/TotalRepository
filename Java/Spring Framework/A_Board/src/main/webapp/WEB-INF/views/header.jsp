<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set value="${pageContext.request.contextPath }" var="cpath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1><a href="${cpath}">board</a></h1>
<c:if test="${login!=null }">
<h3>${login.userid }<a href="${cpath }/member/logout"><button>로그아웃</button></a></h3>
</c:if>

<ul>
	<c:if test="${login != null }">
	<li>
	<a href="${cpath}/board">게시판</a>
	</li>
	</c:if>
	<c:if test="${login ==null }">
	<li>
		<a href="${cpath}/member/login">로그인</a>
	</li>
	<li>
		<a href="${cpath}/member/join">회원가입</a>
	</li>
		<li>
			<a href="${cpath}/member/findAccount">아이디/비밀번호 찾기</a>
		</li>
	</c:if>
	<c:if test="${login != null }">
		<li>
			<a href="${cpath}/member/myPage">마이페이지</a>
		</li>
	</c:if>
</ul>

	


