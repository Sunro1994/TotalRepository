<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//1)몇 번째 데이터를 요청하는지 파라미터를 받는다.
	String i = request.getParameter("i");
	//2)정수로 변환한다.
	int index = Integer.parseInt(i);
	//3) 데이터를 꺼내오기 위해서 리스트를 불러온다.
	ArrayList<String> list = (ArrayList<String>)application.getAttribute("list");
	//4) 데이터를 꺼낸다.
	String data = list.get(index);
	//5) 현재 페이지에서 내용이 너무 길거나, jsp가 아니라서 태그를 쓰기 어렵다면 data를 request에 담는다.
	request.setAttribute("data", data);
	//6) 지정한"문서"에게 요청을 넘겨주면서, forward한다.
	request.getRequestDispatcher("ex06-result.jsp").forward(request, response);
	
	%>
</body>
</html>