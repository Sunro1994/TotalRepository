<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form{
	margin : 30px auto;
	border : 2px solid black;
	width: 320px;
	padding : 20px;
	background-color : #f5f6f7;
	box-shadow : 5px 5px 5px grey;
}
	h3.exp{
		width: 279px;
		border : 1px solid black;
		height : 50px;
		padding : 10px;
		text-align : right;
		box-sizing: border-box;
		font-size : 1.5em;
		over-flow: hidden;
	}
	input[type="submit"] {
		width : 70px;
		height : 60px;
		margin: 3px;
		font-size : 1.5em;
		
	}
	.flex{
	display: flex;
	flex-flow : wrap;
	width: 310px;
	}
	
</style>
</head>
<%!
	String exp ="";
%>
<%
	System.out.println(request.getParameter("btn"));
	String btn = request.getParameter("btn");
	
	if("CE".equals(btn)) {
		exp = "";
	}
	else if("=".equals(btn)) {
		String[] arr = exp.split(" ");
		int n1 = Integer.parseInt(arr[0]);
		String oper = arr[1];
		int n2 = Integer.parseInt(arr[2]);
		System.out.print(Arrays.toString(arr));
		switch(oper) {
		case "+": exp = String.valueOf(n1+n2); break;
		case "-": exp = String.valueOf(n1-n2); break;
		case "x": exp = String.valueOf(n1*n2); break;
		case "/": exp = String.valueOf(n1/(double)n2); break;
			}
	}
	else {
			exp += btn != null ? btn : "";
	}
%>
<body>
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
	<input type="submit" name="btn" value=" + " >
	</div>
	</form>
	
	<a href="Calculator.jsp"><button>되돌아가기</button></a>
</body>
</html>