<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Redirect</title>
</head>
<body>
	<h3>
		클라이언트에게 새로 요청할 주소를 지정해준다.
	</h3>
	<h3>클라이언트가 스스로 요청하기 때문에 현재 서버가 아니라도 다른 위치로 이동할 수 있다.</h3>
	<h3>새로운 요청이 만들어지기때문에, 기존 request에 담겨 있던 parameter, attribute는 사용할 수 없다</h3>
	<!-- response에는 두가지가 담긴다. 응답 코드 (정상 : 200) 
		redirect를 할때는 300번대가 걸린다.
		서버에서 새로 요청할 주소를 알려줘서 클라이언트가 다시 요청하는 방식
		redirect하는 소스에는 화면구현이 목적이 아니기 때문에 소스코드(body)가 없다.
		대신 전달받은 주소로 다시 요청하는것.
	 -->
	 
	 <form method="POST">
	 	<input type="text" name="url" placeholder="url">
	 	<input type="submit" value="이동">
	 </form>
	 
	 <%
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
			String url = request.getParameter("url");
			
			response.sendRedirect(url);
			//redirect는 주소 형식에 따라 현재 도메인 내부의 다른 페이지를 요청할 수 있고
			// 다른 도메인의 경로를 요청할 수도 있다.
			// 주소창에 입력하는 형식대로 입력하면 된다.
			// redirect를 받은 이후 새로 만들어지는 요청은 주소만 지정하여 GET방식이다.
			// https를 붙이면 모든 인터넷안에서 찾는것, http로 검색하면 다시 한번 리다이렉트해서 https로 찾게된다.
			// https가없으면 root주소의 하위 주소를 찾는다.
			//Tomcat으로 실행중이여도 어느 사이트든 갈 수 있는 이유는 내가 클라이언트로서 요청하고 있기 때문
			
			
			
		}
	%>
</body>
</html>