<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>request</h1>
<hr>

<h3><%=request.getProtocol() %></h3>
<h3><%=request.getServerName() %></h3>
<h3><%=request.getServerPort() %></h3>
<h3><%=request.getRequestURI() %></h3>
<h3><%=request.getMethod() %></h3>


<fieldset>
	<legend>request</legend>
	
		<%=request.getMethod()%>
		<%=request.getRequestURI() %>
		<%=request.getProtocol() %>
		 <br>
		Host: <%=request.getServerName() %>:<%=request.getServerPort() %>
	
</fieldset>

</body>
</html>