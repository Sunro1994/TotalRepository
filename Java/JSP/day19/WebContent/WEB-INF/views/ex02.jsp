<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ex02.jsp</title>
</head>
<body>

<h1>ex02.jsp</h1>
<hr>

<h3>Hello, ${empty name ? 'Guest' : name }</h3>
<!-- 서블릿에서 request에 담아둔 값을 참조할 수 있다 -->

<form>
	<p><input type="text" name="name" placeholder="이름"></p>
	<p><input type="submit"></p>
</form>



</body>
</html>