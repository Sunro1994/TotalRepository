<%@page import="calculator.Calculator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02.jsp</title>
</head>
<body>

<h1>ex02.jsp</h1>
<hr>

<h3>HTTP Method를 이용하여 하나의 페이지에서 서로 다른 코드를 수행하게 만들 수 있다</h3>
<h3>request.getMethod() : <%=request.getMethod() %></h3>

<%	if(request.getMethod().equals("GET"))  { %>
	<form method="POST">
		<h4>a의 b승 숫자를 계산합니다</h4>
		<p><input type="number" name="n1" placeholder="n1" min="2" max="10"></p>
		<p><input type="number" name="n2" placeholder="n2" min="0" max="10"></p>
		<p><input type="submit" value="계산 !!"></p>
	</form>
<%	} %>

<%	if(request.getMethod().equals("POST")) { %>
<%
	int n1 = Integer.parseInt(request.getParameter("n1"));
	int n2 = Integer.parseInt(request.getParameter("n2"));
	Calculator calc = new Calculator();
	int answer = calc.pow(n1, n2);
%>
	<h3><%=n1 %><sup><%=n2 %></sup> = <%=answer %></h3>
	<a href="ex02.jsp"><button>다시 !!</button></a>
	<%--a태그는 항상 GET 요청을 만들어낸다 --%>	
<%	} %>
</body>
</html>










