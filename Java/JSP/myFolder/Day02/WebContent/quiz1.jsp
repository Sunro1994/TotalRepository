<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="quiz1.DataList" %>
    <%! DataList data = new DataList(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.PostBox{
		width: fit-content;
		padding : 20px;
		margin :  50% auto;
		border : 1px dashed lightgrey;
		background-color: lightblue;
		border-radius: 10px;
		color: blue;
	}
	select{
		all: unset;
		width:200px;
		color:white;
		text-align:center;
		background-color : #008BCE;
		font-size: 1.8em;
	}
	
	input{
		all:unset;
		color: black;
		font-weight: bold;
		font-size: 1.3em;
		background-color:white;
		border-radius:10px;
		padding: 10px;
	}
	
	input:hover{
		font-size: 1.4em;
		color:white;
		background-color:black;
		padding: 10px;
		border-radius:10px;
		transition-duration: 0.5s;
	}
	fieldset{
		margin:auto;
		margin-top: 100px;
		background-color: black;
		color:white;
		width:250px;
		transition-duration: 4s;
	}
	fieldset:hover{
		width: 800px;
		border : 5px solid yellow;
		transition-duration: 4s;
		
	}
	legend{
		background-color: white;
		color:black;
		border-radius: 20px;
		border : 3px solid yellow;
	}
	
</style>
</head>
<body>

	<%--
		dataList 객체를 생성해두고
		파라미터를 받아서
		문자열의 내용을 출력하는 코드를 작성하세요
		request.getMethod() 를 활용하여
		GET/POST 일 경우를 현재 페이지에 모두 작성하세요.
	 --%>
	 
	 <%--
	 <% switch(request.getMethod()) {
	 
	 	case "GET":
	 	%>
	 	<form method="POST">
	 	<h3>원하는 데이터의 순번을 선택하세요</h3>
	 	<p>
	 		<label><input type="radio" name="index" value="0">0</label>
	 		<label><input type="radio" name="index" value="1">1</label>
	 		<label><input type="radio" name="index" value="2">2</label>
	 		<label><input type="radio" name="index" value="3">3</label>
	 		<label><input type="radio" name="index" value="4">4</label>
	 		</p>
	 		<p><input type="submit"></p>
	 	</form>
	 	<%
	 	break;
	 	case : "POST" :
	 	int index = Integer.parseInt(request.getParameter("index"));
	 	String result = data.get(index);
	 	%>
	  --%>
	 
	 
	 <% if(request.getMethod().equals("GET")) { %>
	 <div class=PostBox>
	 	<form method="post">
	 		<select name="index" required>
	 			<option value="1">1</option>
	 			<option value="2">2</option>
	 			<option value="3">3</option>
	 			<option value="4">4</option>
	 			<option value="5">5</option>
	 		</select>
	 		<input type="submit">
	 	</form>
	 	</div>
	 <%} %>
	 
	 <% if(request.getMethod().equals("POST")) {%>
	<%
		String param = request.getParameter("index");
		int index = Integer.parseInt(param);
		String result = "";
		
		if(param!=null){
				int i=index-1;
				result = data.get(i);
		}
	%>
	<fieldset>
	<legend><%=result.split(",")[0] %>님의 정보</legend>
		<h3>이름: <%=result.split(",")[0] %></h3>
		<h3>나이: <%=result.split(",")[1] %>살</h3>
		<h3>성별: <%=result.split(",")[2] %></h3>
	</fieldset>
	<a href="quiz1.jsp"><button>이전으로</button></a>
	 
	 <%} %>
</body>
</html>