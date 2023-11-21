<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ex01.jsp</title>
</head>
<body>

	<h1>ex01.jsp</h1>
	<hr>

	<form method="POST"> 
		<input type="submit" name="num" value="1">
		<input type="submit" name="num" value="2">
		<input type="submit" name="num" value="3">
		<input type="submit" name="num" value=" + ">
		<input type="submit" name="num" value=" - ">
		<input type="submit" name="num" value="CE">
	</form>
<%!
	String exp = "";
%>
<%
	if(request.getMethod().equals("POST"))  {
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");
		if("CE".equals(num)) {
			exp = "";
			return;
		}
		exp += num; 
%>
		<h3><%=num %></h3>
		<h3><%=exp %></h3>
<%
	}
%>
</body>
</html>