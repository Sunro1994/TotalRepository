<%@page import="ex03.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03-result.jsp</title>
</head>
<body>

<h1>ex03-result.jsp</h1>
<hr>

<h3>검색 결과</h3>

<%
	Movie data = (Movie)session.getAttribute("data");
	if(data != null) {
%>
		<h4>제목 : <%=data.getTitle() %></h4>
		<h4>개봉 일자 : <%=data.getDate() %></h4>
		<h4>누적 관객 수 : <%=data.getViewCount() %></h4>
		
<%	}	// end of if 	

	else { %>
		<h4>검색 결과가 없습니다</h4>
<%	} 	// end of else	%>

<p><a href="ex03-form.jsp"><button>다시 검색</button></a></p>
</body>
</html>





