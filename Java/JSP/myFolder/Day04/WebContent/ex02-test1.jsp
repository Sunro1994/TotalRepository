<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>test1 : <%=pageContext.getAttribute("test1") %></h3>
	<h3>test2 : <%=request.getAttribute("test2") %></h3>
	<h3>test3 : <%=session.getAttribute("test3") %></h3>
	<h3>test4 : <%=application.getAttribute("test4") %></h3>
	
	
	<p><a href="ex02-attribute.jsp"><button>원래 페이지로</button></a></p>
</body>
</html>