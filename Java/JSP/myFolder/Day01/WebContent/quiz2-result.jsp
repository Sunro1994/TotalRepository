<%@page import="sun.security.jca.GetInstance"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%! Date d1 = new Date(); 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal = Calendar.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String date = request.getParameter("birth");
	
	
	
	int year = d1.getYear()+1900;
	 int month = d1.getMonth()+1;
	 int day = d1.getDate();
	
	
	
	cal.setTime(sdf.parse(date));
	
	 int year2 = cal.get(cal.YEAR);
	 int month2 = cal.get(cal.MONTH)+1;
	 int day2 = cal.get(cal.DAY_OF_MONTH);
	
	

	
	
%>


	<h3>오늘은 <%=date.substring(0,4)%>년 <%=date.substring(5,7) %>월 <%=date.substring(8,10) %>일 입니다. </h3>
	<h3>오늘은 <%=year%>년 <%=month %>월 <%=day %>일 입니다. </h3>
	<h3>오늘은 <%=year2%>년 <%=month2 %>월 <%=day2 %>일 입니다. </h3>
	<p><a href="Quiz2.jsp"><button>돌아가기</button></a></p>
</body>
</html>