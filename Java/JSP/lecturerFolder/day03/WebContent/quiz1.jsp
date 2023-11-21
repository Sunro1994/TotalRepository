<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz1.jsp</title>
</head>
<body>
<%!
	String exp = "";
%>
<%
	// 여기서 화면에 나타낼 데이터를 준비합니다
	int a = 0;
	int b = 0;
	String num = "";
	
	if(true) {
		a = 12;
		b = 13;
		num = request.getParameter("num");	// 함수, 객체의 메서드 호출 가능
	}
%>

<%--HTML을 이용하여 구조를 만들고, 태그 내부에 들어갈 데이터는 표현식으로 값을 출력합니다 --%>
<h1>quiz1.jsp</h1>
<hr>

<h3>이항 산술연산이 가능한 간단 계산기 구현하기</h3>
<h3><%=a %> + <%=b %> = <%=a + b %></h3>

</body>
</html>


