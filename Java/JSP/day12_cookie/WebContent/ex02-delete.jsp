<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-delete.jsp</title>
</head>
<body>

<%
	// 쿠키 삭제하기, 같은 이름으로 아무 값이나 지정하고 유효시간을 0으로 설정한 다음 보낸다
	Cookie c = new Cookie("memo", null);

	c.setMaxAge(0);
	
	response.addCookie(c);
	
	String cpath = request.getContextPath();
	response.sendRedirect(cpath + "/ex02-check.jsp");
	// 쿠키 생성 코드와 거의 똑같으면서, 유효시간만 다르다
%>

</body>
</html>















