<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*" %>
	<%
		request.setCharacterEncoding("UTF-8");
		String param = request.getParameter("param");
	
		
		if(param == null) {
			response.sendRedirect("list.jsp");
			return;
		}
		ArrayList<String> list = (ArrayList)application.getAttribute("list");
		
		list.add(param);
		
		response.sendRedirect("list.jsp");
		
		%>
</body>
</html>