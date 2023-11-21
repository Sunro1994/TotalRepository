<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz3.jsp</title>
</head>
<body>
<%@ page import="java.util.Random" %>
<%!
	// 선언부, 유지되어야 하는 변수
	Random ran = new Random();
	int answer = ran.nextInt(100) + 1;
	int count = 0;
%>
<h1>quiz3.jsp</h1>
<hr>

<%
	// 요청이 들어올 때 마다 값이 변하는 변수
	String num = request.getParameter("num");
	int input = 0;
	String result = "";
	boolean flag = false;
	
	// 코드 전개
	if(num != null) {	// 파라미터를 입력받았다면
		count++;
		input = Integer.parseInt(num);
		if(input != answer) {	// 정답이 아니면
			if(input > answer) result = "DOWN";
			if(input < answer) result = "UP";
			result = String.format("%d회 시도 : %s", count, result);
		}
		else {					// 정답과 일치하면
			flag = true;
			result = String.format("<p>%d회 만에 정답을 맞췄습니다 !!</p>", count);
			// 출력할 메시지를 만들어주고
			// 정답과 횟수를 초기화한다
			answer = ran.nextInt(100) + 1;
			count = 0;
			result += "<p><a href=\"quiz3.jsp\"><button>다시</button></a></p>";
		}
	}
%>
<form>
	<p>
		<input type="number" name="num" placeholder="1 ~ 100"
			   autocomplete="off" required autofocus
			   value="<%=flag ? input : ""%>">
		<input type="submit">		  
	</p>
</form>
<h3><%=result %></h3>


</body>
</html>








