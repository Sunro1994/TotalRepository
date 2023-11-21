<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-action.jsp</title>
</head>
<body>
<%@ page import="member.MemberDAO" %>
<%	request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="member.MemberDTO" />
<jsp:setProperty property="*" name="user" />

<c:set var="dao" value="${MemberDAO.getInstance() }" />
<c:set var="login" value="${dao.login(user) }" scope="session" />

<%
	session.setMaxInactiveInterval(600);	// 로그인 유지 시간 600초 (10분)
	// 세션 비활성화 주기를 0으로 설정하면, 세션 유지 시간이 무한대가 되어버린다
	
%>

<script>
	const login = '${login}'
	if(login == '') {
		alert('로그인 실패')
	}
	else {
		alert('로그인 성공')
	}
	location.href = 'ex02-index.jsp'
</script>

</body>
</html>