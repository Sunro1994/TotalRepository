package ex04;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex04Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String prefix = "/WEB-INF/views/";
	private String suffix = ".jsp";
	
	private PhoneBookDAO dao = PhoneBookDAO.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<PhoneBookDTO> list = dao.selectList();	// DB에서 데이터를 불러와서
		request.setAttribute("list", list);			// request에 데이터를 담기
		
		String path = prefix + "ex04" + suffix;		// 이동할 jsp를 지정
		RequestDispatcher rd = request.getRequestDispatcher(path);	// forward
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String pnum = request.getParameter("pnum");
		
		if(name != null && pnum != null) {
			PhoneBookDTO dto = new PhoneBookDTO();
			dto.setName(name);
			dto.setPnum(pnum);
			
			int row = dao.insert(dto);
			System.out.println(row + "행이 추가되었습니다");
		}
		// jsp로 포워드 하지않고, 특정 주소로 리다이렉트를 수행한다
		String cpath = request.getContextPath();
		response.sendRedirect(cpath + "/ex04");
	}

	
}












