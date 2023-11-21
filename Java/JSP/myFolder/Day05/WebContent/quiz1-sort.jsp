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
<% ArrayList<Movie> list = (ArrayList<Movie>)application.getAttribute("list");
	
	if(list!=null){
		
	list.sort((a,b) -> {
		int n1 = a.getRank();
		int n2 = b.getRank();
		
		return n1 - n2>0?1:-1;
	});
	}
	
	application.setAttribute("list", list);
%>

	<jsp:forward page="quiz1-movie.jsp"></jsp:forward>
</body>
</html>