<%@page import="day05.Movie"%>
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
		ArrayList<Movie> list = (ArrayList<Movie>)application.getAttribute("list");
		String title = (String)application.getAttribute("titleName");
		String newTitle = (String)request.getParameter("changedName");
		
		if(list!=null){
			for(Movie i: list) {
				if(i.getTitle().equals(title)) {
					i.setTitle(newTitle);
					break;
				}
			}
			
		}
		
		application.setAttribute("list", list);
	%>

	<jsp:forward page="quiz1-movie.jsp"></jsp:forward>
</body>
</html>