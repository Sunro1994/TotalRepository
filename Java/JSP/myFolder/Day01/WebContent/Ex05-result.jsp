<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h3{
	font-size: 1.5em;
	}
</style>
</head>
<body>
	<%
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		
		int answer =0;
		
		if(n1 != null && n2 != null) {
			int num1 = Integer.parseInt(n1);
			int num2 = Integer.parseInt(n2);
			answer = num1 + num2;
		}
		
	%>
	
	<h3><%=n1 %>+ <%=n2 %> = <%=answer %></h3>
	<a herf="Ex05-form.jsp"><button>입력창으로</button></a>
</body>
</html>