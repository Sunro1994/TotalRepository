<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex05.jsp</title>
</head>
<body>

<h1>ex05.jsp</h1>
<hr>

<form>
	<input type="text" name="name" placeholder="이름을 입력하세요" autofocus>
</form>

<h3>
	안녕하세요. 
	${param.name }
	${not empty param.name ? '님' : ''}
</h3>

<h3>
	안녕하세요. 
	<%=request.getParameter("name") != null ? request.getParameter("name") : "" %>
	<%=request.getParameter("name") != null ? "님" : "" %>
</h3>

</body>
</html>