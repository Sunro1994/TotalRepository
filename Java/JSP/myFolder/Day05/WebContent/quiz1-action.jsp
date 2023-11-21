<%@page import="java.util.ArrayList"%>
<%@page import="day05.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP- Action</title>
<style>

</style>
</head>
<body>
	<jsp:useBean id="mv"  class="day05.Movie" scope="request" />
	
	<jsp:setProperty property="*" name="mv"/>
	
	
	
	<%
		
		ArrayList<Movie> list = (ArrayList<Movie>)application.getAttribute("list");
		
		if(list != null) 
			{list.add(mv);
		
		application.setAttribute("list", list);}
		
	%>
	
	<jsp:forward page="quiz1-movie.jsp"></jsp:forward>
</body>
</html>