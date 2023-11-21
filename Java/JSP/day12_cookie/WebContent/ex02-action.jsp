<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-action.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String memo = request.getParameter("memo");
	
	// 문자열 값을 이용해서 쿠키 객체를 생성한다. 쿠키는 이름과 값으로 구성된다
	// Cookie c = new Cookie(String name, String value);
	Cookie c = new Cookie("memo", memo);
	
	// 쿠키는 유효시간을 설정해야 한다. 쿠키의 유효시간은 초 단위로 지정한다
	c.setMaxAge(60 * 60 * 24); 	// 60초, 60분, 24시간
	
	// 서버에서 생성한 쿠키는 클라이언트가 보관해야 하기 때문에 response에 적재하여 보내준다
	response.addCookie(c);
	
	// 쿠키 관련 작업이 끝났으면, 다른 페이지로 리다이렉트를 보낸다
	// 쿠키는 받은 즉시 효력이 발생하지 않고, 다음 방문(다음 요청)시에 효력이 발생하기 때문에 리다이렉트를 권장
	// 리다이렉트는 클라이언트가 새로운 요청을 발생시키도록 만드는 응답이다 (status code 302)
	String cpath = request.getContextPath();
	response.sendRedirect(cpath + "/ex02-check.jsp");
%>


</body>
</html>





