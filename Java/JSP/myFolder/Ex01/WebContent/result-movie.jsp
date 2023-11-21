<%@page import="servletEx.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%Movie mv = (Movie)session.getAttribute("data");
		
	if(mv!=null) {%>
		
		<h2>제목 : <%=mv.getName() %></h2>
		<h2>제목 : <%=mv.getDate() %></h2>
		<h2>제목 : <%=mv.getView() %></h2>
	<% }else {%>
		<h2>찾는 영화가 없습니다.</h2>
	
	
	<%}%>
</body>
</html>