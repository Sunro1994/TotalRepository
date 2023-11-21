<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex04.jsp</title>
</head>
<body>

<h1>ex04.jsp</h1>
<hr>

<h3>form 태그의 method 속성을 생략하면 GET이다</h3>
<form method="POST">
	<p><input type="text" name="name" placeholder="이름"></p>
	<p><input type="number" name="age" min="0" max="100" placeholder="나이"></p>
	<p><input type="submit"></p>
</form>

<%
	request.setCharacterEncoding("UTF-8");

	// 파라미터는 클라이언트로 부터 입력받은 (전송받은) 글자
	// 파라미터가 없으면 request.getParameter() 의 결과는 null 이다
	String name = request.getParameter("name");	
	String age = request.getParameter("age");
	
	int a = 0;
	if(age != null) {
		a = Integer.parseInt(age);
		out.print("<h3>" + name + "님의 나이는 " + age + "살입니다</h3>");
		out.print("<h3>" + name + "님은 " + (a >= 20 ? "성인" : "미성년자") + "입니다</h3>");
		out.print("<h3>queryString : " + request.getQueryString() + "</h3>");
	}
%>

</body>
</html>




