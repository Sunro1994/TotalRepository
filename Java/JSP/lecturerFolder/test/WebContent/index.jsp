<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>Hello</h1>
	<hr>
	<% 	Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		String now = sdf.format(date);
	%>
	<h3>지금은 <%=now %> 입니다</h3>

</body>
</html>