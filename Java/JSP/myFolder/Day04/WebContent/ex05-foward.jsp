<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Foward</h1>
	<hr>
	
	<h3>forward는 서버에서 임의로 응답을 처리할 페이지를 변경하는 기술</h3>
	<h3>클라이언트는 1회만 요청하면 서버에서 다른 페이지에서 요청과 응답을 넘겨준다</h3>
	<h3>요청과 응답을 넘겨받은 페이지에서는 기존 request를 그대로 사용할 수 있다</h3>	
	<h3>클라이언트가 주소를 변경하는 것이 아니라서 주소창이 바뀌지 않는다.</h3>
	<h3>서버가 보유한 자원(root아래 자원)으로 포워딩하기 때문에, 다른 서버(네이버, 다음 등 다른 서버)로는 넘길 수 없다.</h3>

	<form method="POST">
		<p><input type="text" name="url" placeholder="url"></p>
		<p><input type="submit" value="이동"></p>
	</form>
	
	<%
		if(request.getMethod().equals("POST")) {
			String url = request.getParameter("url");
			
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("test2", "제발 눈좀 떠라");
			
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			//request와 response를 url에 지정된 페이지에 넘겨준다.
		}
	%>

</body>
</html>