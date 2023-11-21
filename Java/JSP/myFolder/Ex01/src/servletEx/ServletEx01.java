package servletEx;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx01 extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("로그인 서블릿 초기화");
	}
	
	@Override
	public void destroy() {
		System.out.println("로그인 서블릿 소멸");
	}
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//doGet(), doPost() 등 HTTP Method에 대응하는 메서드를 오버라이딩하기도 한다.
//		System.out.println("로그인 서비스!");
//	}
	
	//Get요청시 어떻게 처리할 것인가?를 처리하는 메서드
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PrintWriter pw = new PrintWriter(resp.getOutputStream());
//		pw.println(
//				//JSP없이 처리하려면 이렇게 긴 문장을 넣어야 한다.
//"<!DOCTYPE html>\r\n" + 
//"<html>\r\n" + 
//"<head>\r\n" + 
//"<meta charset=\"UTF-8\">\r\n" + 
//"<title>Insert title here</title>\r\n" + 
//"</head>\r\n" + 
//"<body>\r\n" + 
//"<!-- login을 수행할 경우 loginProc.jsp에서 처리한다. post방식 -->\r\n" + 
//"<!-- 웹 브라우저와 웹 어플리케이션 사이에서 jsp가 매개체 역할을 한다.\r\n" + 
//"		jsp파일은 결국 자바 코드다.\r\n" + 
//"		\r\n" + 
//"	!lifecycle : jsp파일은 자바코드로 변환이되고 컴파일이 되고 컴파일이 끝나면\r\n" + 
//"	객체를 생성한다. 생성된 객체는 init을 호출하여 필요한 초기값을 지정하고\r\n" + 
//"	브라우저 요청에 대한 처리는 서비스라는 함수에서 하게 된다.\r\n" + 
//"	\r\n" + 
//"	JSP파일 동작 방식 :\r\n" + 
//"	jsp파일은 자바코드로 변환이 된다.\r\n" + 
//"	이때 HttpServlet을 상속하여 만들어진다.\r\n" + 
//"	\r\n" + 
//"	기존방식 = 클라이언트 요청을 jSP파일로 받음\r\n" + 
//"	서블릿 = 클라이언트의 요청을 servlet으로 직접 받음\r\n" + 
//"	\r\n" + 
//"	MVC패턴을 구현하기 위해서는 서블릿을 구현하는 방법을 알아야 한다.\r\n" + 
//"	\r\n" + 
//"	MVC패턴 \r\n" + 
//"	model \r\n" + 
//"	view - jsp파일(순수 화면 구현)\r\n" + 
//"	Controller - Servlet(어떻게 처리해야 하는지 구분)\r\n" + 
//" -->\r\n" + 
//"<form action=\"loginProc.jsp\" method=\"post\">\r\n" + 
//"	<input type=\"text\" name=\"userid\" >\r\n" + 
//"	<input type=\"password\" name=\"userpw\" >\r\n" + 
//"	<input type=\"submit\" value=\"로그인\" >\r\n" + 
//"</form>\r\n" + 
//"</body>\r\n" + 
//"</html>"
//				);
//}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//JSP 파일을 통해서 연계가능하다. 위 메서드보다 훨씬 깔끔
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		if(userid.equals(userpw)) {
			resp.sendRedirect("/main.jsp");
			System.out.println("로그인 성공");
		}
		else {
			resp.sendRedirect("/login.jsp");
			System.out.println("로그인 실패!");
		}
	}

}
