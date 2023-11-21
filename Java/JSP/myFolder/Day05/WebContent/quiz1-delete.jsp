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
		String search = request.getParameter("search");
		
		if(list != null) {
		for(int i=0; i<list.size(); i++){
			Movie x = list.get(i);
			
			if(x.getTitle().equals(search)) {
				list.remove(i);
				break;
			}
			
			}
		}
		
		application.setAttribute("list", list);
		
	%>
		<jsp:forward page="quiz1-movie.jsp"></jsp:forward>
</body>
</html>