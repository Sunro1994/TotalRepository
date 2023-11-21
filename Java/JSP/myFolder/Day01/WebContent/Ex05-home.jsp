<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input{
		font-size : 1.5em;
		padding : 10px;
		width:100px;
	}
</style>
</head>
<body>
<h3>form 태그의 action속성은 파라미터를 넘겨받는 대상이다.</h3>

	<form action="Ex05-result.jsp">
		<p>
		<input type="number" name="n1" placeholder="n1" autocomplete="off">
		+
		<input type="number" name="n2" placeholder="n2" autocomplete="off">
		<input type="submit" value="=">
		</p>
		
	</form>
</body>
</html>