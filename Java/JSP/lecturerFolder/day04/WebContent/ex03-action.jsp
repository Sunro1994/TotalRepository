<%@page import="ex03.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03-action.jsp</title>
</head>
<body>
<%!
	Movie[] arr = {
		new Movie("밀수", "2023-07-26", 2417754),	
		new Movie("오펜하이머", "2023-08-15", 0),	
		new Movie("비공식작전", "2023-08-02", 165433),	
		new Movie("더 문", "2023-08-02", 121186),	
		new Movie("콘크리트 유토피아", "2023-08-09", 4876),	
		new Movie("엘리멘탈", "2023-06-14", 5955156),	
		new Movie("미션 임파서블: 데드 레코닝 PART ONE", "2023-07-12", 3685013),	
		new Movie("바비", "2023-07-19", 476594),	
		new Movie("몬스터 패밀리2", "2023-08-02", 17678),	
		new Movie("명탐정코난: 흑철의 어영", "2023-07-20", 632510),	
	};
%>
<%
	request.setCharacterEncoding("UTF-8");
	String search = request.getParameter("search");
	
	Movie data = null;
	for(Movie ob : arr) {
		if(ob.getTitle().contains(search)) {
			data = ob;
			break;
		}
	}
	session.setAttribute("data", data);
	
	String url = "ex03-result.jsp";
	response.sendRedirect(url);
%>

</body>
</html>













