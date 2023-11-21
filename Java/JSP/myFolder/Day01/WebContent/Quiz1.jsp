<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%!
//값이 유지되어야 하는 값
	private Random ran = new Random();
private int n1 = ran.nextInt(100)+1;
private int n2 = ran.nextInt(100)+1;
%>

<%
//페이지를 새로 고침할때마다 바뀌는 값(지역변수)
String answer = request.getParameter("answer");
String result ="";

if(answer != null) {
	int a = Integer.parseInt(answer);
	if(a== n1 + n2 ) {
		result = "정답";
		n1 = ran.nextInt(100) +1;
		n2 = ran.nextInt(100)+1;
	}
	else {
		result = "오답";
	}
}

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Quiz1</h1>
	<hr>
	
	<h3>두 정수의 덧셈 맞추기</h3>
	<ul>
		<li>java.util.Random 클래스를 import하세요</li>
		<li>form 태그에서는 두 정수 n1,n2를 랜덤으로 가져오세요</li>
		<li>랜덤의 범위는 1~100 사이입니다.</li>
		<li>두 정수를 이용하여 식을 보여주고, 정답을 입력받기 위한 input을 준비합니다.</li>
		<li>정답을 입력받는 파라미터의 이름은 answer입니다</li>
		<li>입력받은 answer가 맞으면 정답, 틀리면 오답이라고 출력하세요.</li>
	</ul>
	
	<fieldset>
	<form>
	 <p><%=n1%> + <%=n2%></p>
	 <p><input type="number" name="answer" placeholder="정답입력"></p>
	 <p><input type="submit"/></p>
	 
	 <p><%=result%></p>
	</form>
	</fieldset>
	
	
	
	
	
	
</body>
</html>