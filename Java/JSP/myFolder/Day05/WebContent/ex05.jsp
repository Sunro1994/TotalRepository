<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form>
	<input type="text" name="name" placeholder="이름을 입력하세요">
</form>
<!--  El태그는 null 인 경우 빈문자열 취급한다. -->
<h3> 
	안녕하세요. ${not empty param ? param.name : ''}
	${not empty param ? '님': '' }
</h3>

<!--  일반 표현식은 Null체크를 하지 못해서 빈문자열이 아닌  공백도 null이 아니라 판단하여 님이 출력된다. -->
<h3> 
	안녕하세요.
	<%= request.getParameter("name") != null ? request.getParameter("name"): "" %>
	<%= request.getParameter("name")!= null ? "님" : "" %>
</h3>


</body>
</html>