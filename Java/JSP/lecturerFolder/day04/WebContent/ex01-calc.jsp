<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz1.jsp</title>
<style>
	form {
		margin: 30px auto;
		border: 2px solid black;
		width: 302px;
		padding: 20px;
		background-color: #fefefe;
		border-radius: 10px;
		box-shadow: 5px 5px 5px grey;
	}
	h3.exp {
		width: 279px;
		border: 1px solid black;
		height: 30px;
		padding: 10px;
		text-align: right;
		background-color: white;
		font-size: 1.5em;
		overflow: hidden;
	}
	div.flex {
		display: flex;
		flex-flow: wrap;
		width: 310px;
	}
	input[type="submit"] {
		width: 70px;
		height: 60px;
		margin: 3px;
		font-size: 1.5em;
	}
</style>
</head>
<body>
<%!
	// 페이지가 새로고침되어도 유지되어야 하는 데이터
	// 지금까지 입력했던 수식 (exp)
	String exp = "";
%>
<%
	// 여기서 화면에 나타낼 데이터를 준비합니다
	String btn = request.getParameter("btn");
	System.out.println("btn : " + btn);
	
	if("CE".equals(btn)) {
		exp = "";
	}
	else if("=".equals(btn)) {
		if(exp.contains(" ")) {
			String[] arr = exp.split(" ");
			int n1 = Integer.parseInt(arr[0]);
			String oper = arr[1];
			int n2 = Integer.parseInt(arr[2]);
			switch(oper) {
				case "+": 	exp = String.valueOf(n1 + n2); 	break;
				case "-": 	exp = String.valueOf(n1 - n2); 	break;
				case "x": 	exp = String.valueOf(n1 * n2); 	break;
				case "/": 	exp = String.valueOf(n1 / n2); 	break;
			}
		}
	}
	else {
		if((exp.endsWith(" ") && btn.startsWith(" ")) == false) {
			exp += btn != null ? btn : "";
		}
	}
%>

<%--HTML을 이용하여 구조를 만들고, 태그 내부에 들어갈 데이터는 표현식으로 값을 출력합니다 --%>
<h1>quiz1.jsp</h1>
<hr>

<h3>이항 산술연산이 가능한 간단 계산기 구현하기</h3>

<form method="POST">
	<h3 class="exp"><%=exp %></h3>
	<div class="flex">
		<input type="submit" name="btn" value="7">
		<input type="submit" name="btn" value="8">
		<input type="submit" name="btn" value="9">
		<input type="submit" name="btn" value=" / ">
		<input type="submit" name="btn" value="4">
		<input type="submit" name="btn" value="5">
		<input type="submit" name="btn" value="6">
		<input type="submit" name="btn" value=" x ">
		<input type="submit" name="btn" value="1">
		<input type="submit" name="btn" value="2">
		<input type="submit" name="btn" value="3">
		<input type="submit" name="btn" value=" - ">
		<input type="submit" name="btn" value="0">
		<input type="submit" name="btn" value="CE">
		<input type="submit" name="btn" value="=">
		<input type="submit" name="btn" value=" + ">
	</div>
</form>


</body>
</html>


