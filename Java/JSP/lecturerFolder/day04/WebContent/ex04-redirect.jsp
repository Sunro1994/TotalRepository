<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex04-redirect.jsp</title>
</head>
<body>

<h1>ex04-redirect.jsp</h1>
<hr>

<h3>클라이언트에게 새로 요청할 주소를 지정해준다</h3>
<h3>클라이언트가 스스로 요청하기 때문에 현재 서버가 아니라도 다른 위치로 이동할 수 있다</h3>
<h3>새로운 요청이 만들어지기 때문에, 기존 request에 담겨있던 parameter, attribute는 사용할 수 없다</h3>

<form method="POST">
	<input type="text" name="url" placeholder="url">
	<input type="submit" value="이동">
</form>

<%
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("UTF-8");
		String url = request.getParameter("url");
		
		response.sendRedirect(url);
		// redirect는 주소 형식에 따라 현재 도메인 내부의 다른 페이지를 요청할 수 있고
		// 다른 도메인의 경로를 요청할 수도 있다
		// 주소창에 입력하는 형식대로 입력하면 된다
		// redirect를 받은 이후 새로 만들어지는 요청은 주소만 지정하여 GET방식이다
	}
%>

</body>
</html>










