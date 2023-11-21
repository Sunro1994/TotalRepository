<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public void init() throws ServletException{
	System.out.println("login.jsp초기화");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- login을 수행할 경우 loginProc.jsp에서 처리한다. post방식 -->
<!-- 웹 브라우저와 웹 어플리케이션 사이에서 jsp가 매개체 역할을 한다.
		jsp파일은 결국 자바 코드다.
		
	!lifecycle : jsp파일은 자바코드로 변환이되고 컴파일이 되고 컴파일이 끝나면
	객체를 생성한다. 생성된 객체는 init을 호출하여 필요한 초기값을 지정하고
	브라우저 요청에 대한 처리는 서비스라는 함수에서 하게 된다.
	
	JSP파일 동작 방식 :
	jsp파일은 자바코드로 변환이 된다.
	이때 HttpServlet을 상속하여 만들어진다.
	
	기존방식 = 클라이언트 요청을 jSP파일로 받음(HTTP문서 안에 JAVA코드)
	서블릿 = 클라이언트의 요청을 servlet으로 직접 받음(JAVA코드 안에 HTML포함)
	
	MVC패턴을 구현하기 위해서는 서블릿을 구현하는 방법을 알아야 한다.
	
	MVC패턴 
	model 
	view - jsp파일(순수 화면 구현)
	Controller - Servlet(어떻게 처리해야 하는지 구분)
 -->
<form action="loginProc.jsp" method="post">
	<input type="text" name="userid" >
	<input type="password" name="userpw" >
	<input type="submit" value="로그인" >
</form>
</body>
</html>