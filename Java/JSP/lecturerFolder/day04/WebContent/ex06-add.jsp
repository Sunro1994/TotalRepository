<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex06-add.jsp</title>
</head>
<body>
<%@ page import="java.util.ArrayList" %>
<%
	request.setCharacterEncoding("UTF-8");	// 인코딩 설정
	
	// 1) 파라미터를 받아서
	String param = request.getParameter("param");
	
	// 1-2) 파라미터가 null이면 곧바로 목록으로 이동시킨다
	if(param == null) {
		response.sendRedirect("ex06-list.jsp");
		return;
	}
	
	// 2) 리스트를 불러와서
	ArrayList<String> list = (ArrayList<String>)application.getAttribute("list");
	
	// 3) 리스트에 파라미터를 추가했다
	list.add(param);
	
	// 4) 추가 페이지의 목적은 모두 완료했고, 다시 목록을 띄우면 되는데 여기서 똑같은걸 작성하긴 싫다

	// 5) 만들어진 목록페이지가 있으니, 클라이언트에게 해당 "주소"로 이동하라고 지시한다
	response.sendRedirect("ex06-list.jsp");
%>

</body>
</html>