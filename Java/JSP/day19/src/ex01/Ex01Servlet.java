package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 웹 페이지 요청을 처리하기 위한 자바 클래스
// request를 전달받아서, response를 반환하는 형식이다
// HttpServlet 클래스를 상속받은 새로운 클래스를 작성한다
// 메서드는 오버라이딩으로 작성하기 때문에, 비교적 쉽게 작성 가능하다

public class Ex01Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		
		String html = "";
		html += "<!DOCTYPE html>\n";
		html += "<html lang=\"ko\">\n";
		html += "	<head>\n";
		html += "		<meta charset=\"UTF-8\">\n";
		html += "		<title>Ex01Servlet</title>\n";
		html += "	</head>\n";
		html += "	<body>\n";
		html += "	<h1>Ex01Servlet</h1>\n";
		html += "	<hr>\n";
		html += "	<h3>Hello, %s</h3>\n";
		html += "	<form>\n";
		html += "		<p><input type=\"text\" name=\"name\" placeholder=\"이름\"></p>\n";
		html += "		<p><input type=\"submit\"></p>\n";
		html += "	</form>\n";
		html += "	</body>\n";
		html += "</html>\n";
		html = String.format(html, name != null ? name : "Guest");
		PrintWriter out = response.getWriter();
		out.write(html);
		out.flush();
		out.close();
	}
	
}






