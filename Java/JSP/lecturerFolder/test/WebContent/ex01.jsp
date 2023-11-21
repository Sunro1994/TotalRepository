<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01.jsp</title>
</head>
<body>

<h1>request</h1>
<hr>

<fieldset>
	<legend>request</legend>
	<%=request.getMethod() %> 
	<%=request.getRequestURI() %> 
	<%=request.getProtocol() %>
	<br>
	Host: <%=request.getServerName() %>:<%=request.getServerPort() %>
		
</fieldset>

</body>
</html>






