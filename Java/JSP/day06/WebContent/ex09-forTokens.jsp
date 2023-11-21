<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex09-forTokens.jsp</title>
</head>
<body>

<h1>ex09-forTokens.jsp</h1>
<hr>

<%
	String s1 = "짱구,유리,훈이,철수,맹구,수지";
	pageContext.setAttribute("s1", s1);
	out.print("<ul>");
	for(String name : s1.split(",")) {
		out.print("<li>" + name + "</li>");
	}
	out.print("</ul>");	
%>

<ol>
	<c:forTokens var="name" items="${s1 }" delims=",">
	<li>${name }</li>
	</c:forTokens>
</ol>

</body>
</html>










