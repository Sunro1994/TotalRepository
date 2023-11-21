package ex04;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex04/delete")
public class Ex04DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private PhoneBookDAO dao = PhoneBookDAO.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idx = request.getParameter("idx");
		
		if(idx != null) {
			int i = Integer.parseInt(idx);
			System.out.println("delete : " + i);
			int row = dao.delete(i);
			System.out.println(row + "행이 삭제되었습니다");
		}
		else {
			System.out.println("삭제할 대상의 idx가 지정되지 않았음");
		}
		response.sendRedirect(request.getContextPath() + "/ex04");
	}
}
