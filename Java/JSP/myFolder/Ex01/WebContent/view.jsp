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
	<%
		String i = (String)request.getParameter("i");
	
		int index = Integer.parseInt(i);
		
		ArrayList<String> list = (ArrayList<String>)application.getAttribute("list");
		
		String data = list.get(index);
		
		request.setAttribute("data", data);
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		
	%>
</body>
</html>