<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="member.MemberDTO" />
<jsp:setProperty property="*" name="user" />

<c:set var="dao" value="${MemberDAO.getInstance() }" />
<c:set var="login" value="${dao.login(user) }" scope="session" />

<%
	String autologin = request.getParameter("autologin");
	if(autologin != null) {	// 자동 로그인 체크박스에 체크를 했다면
// 		Cookie c = new Cookie("JSESSIONID", session.getId());
		Cookie c = new Cookie("JSESSIONID", "7384C81A2C9BED1ADC0D80992A41150A");
		c.setMaxAge(60 * 60 * 24 * 7);
		response.addCookie(c);
	}
	response.sendRedirect("ex01-form.jsp");
%>
</body>
</html>








