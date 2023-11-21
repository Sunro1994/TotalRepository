<%@ page language="java" contentType="text/html; charset=UTF-8"	
    pageEncoding="UTF-8"%>	<!-- %는 자바의 import부분과 동일하다 -->
    <%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>hello</h1>
	<hr>
	
	<%
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		String now =sdf.format(date);
		// 서버의 서비스, 자바의 하나의 클래스안 지역변수를 만드는 공간
	%>
	<!-- %= 는 서비스를 표현할 공간 -->
	<h3>지금은 <%=now %> 입니다.</h3>
</body>
</html>