<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-index.jsp</title>
</head>
<body>

<h1>ex02-index.jsp</h1>
<hr>

<h3>${pageContext.session.id }</h3>
<%
	request.getSession();		// 현재 요청에 연결된 세션을 받아온다
	request.getSession(true);	// 현재 요청에 연결된 세션을 받아온다. 없으면 새로 생성한다 (true)
%>

<p>
	<a href="ex03-join.jsp"><button>회원가입</button></a>
</p>

<c:if test="${empty login }">
	<a href="ex02-form.jsp"><button>로그인</button></a>
</c:if>

<c:if test="${not empty login }">
	<h3>현재 사용자 : ${login.userid } (${login.username })</h3>
	<a href="ex04-mypage.jsp"><button>마이 페이지</button></a>
	<a href="ex02-logout.jsp"><button>로그아웃</button></a>	
</c:if>

</body>
</html>





