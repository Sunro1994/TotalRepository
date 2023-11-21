<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03-action.jsp</title>
</head>
<body>

<%@ page import="member.MemberDAO" %>
<% 	request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="user" class="member.MemberDTO" />
<jsp:setProperty property="*" name="user" />

<c:set var="dao" value="${MemberDAO.getInstance() }" />
<c:set var="row" value="${dao.insert(user) }" />

<script>
	const row = '${row}'
	alert(row != 0 ? '가입 성공' : '가입 실패')
	location.href = 'ex02-index.jsp'
</script>

</body>
</html>