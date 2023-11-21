<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01.jsp</title>
</head>
<body>
<%@ page import="calculator.Calculator" %>
<%
	Calculator calc = new Calculator();
	int answer = calc.pow(2, 10);
%>
<h3>2<sup>10</sup> = <%=answer %></h3>

</body>
</html>