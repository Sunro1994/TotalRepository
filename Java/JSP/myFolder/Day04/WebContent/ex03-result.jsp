<%@page import="ex03.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  상수를 항상 앞에두면 Null체크를 하지 않아도 되는 간편함이 있다. 변수가 뒤에 가면 null이 공백으로 처리되기 때문에 예외가 터지지 않음 -->
	<%
		Movie data =(Movie)session.getAttribute("data");
		if(data!= null){
			
	%>
	
	<h4>제목 : <%= data.getTitle() %></h4>
	<h4>개봉일자 : <%= data.getDate() %></h4>
	<h4>누적관객수 : <%= data.getViewCount() %></h4>
<% 	
		}//end of if
		
		else{%>			
	<h4>검색 결과가 없습니다.</h4>
		<% } // end of else %>

<p><a href="Ex-03form.jsp"><button>다시검색</button></a></p>
</body>
</html>