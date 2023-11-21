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
<%@ page import="java.util.ArrayList" %>
	<%
		request.setCharacterEncoding("UTF-8");			//인코딩설정
		
		String param = request.getParameter("param");	//1)파라미터를 받아서
		
		//1-1) 파라미터가 null이면 곧바로 목록을 이동시킨다.
		if(param == null) {
			response.sendRedirect("ex06-list.jsp");
			return;
		}

		ArrayList<String> list = (ArrayList<String>)application.getAttribute("list");	//2)리스트를 불러와서

		list.add(param);	//3)리스트에 파라미터를 추가한다.

		//4) 추가 페이지의 목적은 모두 완료, 다시 목록을 띄워야하는데 원래 만들어진 목록페이지로 클라이언트를 보낸다.(리다이렉트)
		response.sendRedirect("ex06-list.jsp");
	%>
</body>
</html>