package ex03;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex03Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String prefix = "/WEB-INF/views/";
	private String suffix = ".jsp";
	
	private Random ran = new Random();
	private int n1;
	private int n2;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		n1 = ran.nextInt(10) + 1;
		n2 = ran.nextInt(10) + 1;
		String msg = String.format("%d + %d = ", n1, n2);
		System.out.println("msg : " + msg);
		
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher(prefix + "ex03" + suffix);
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String answer = request.getParameter("answer");
		int a = Integer.parseInt(answer);
		
		boolean flag = n1 + n2 == a;
		request.setAttribute("flag", flag);
		
		RequestDispatcher rd = request.getRequestDispatcher(prefix + "ex03-action" + suffix);
		rd.forward(request, response);
	}
	

}














