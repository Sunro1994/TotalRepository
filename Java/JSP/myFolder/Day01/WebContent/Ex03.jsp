<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h3 > span{
	color:blue;
	}
	table{
	border: 2px solid black;
	border-collapsse : collapse;
	}
	thead {
		background-color:#dadada;
	}
	td, th{
	padding: 5px 10px;
	border : 1px solid gray;
	font-size: 1.5em;
	}
	tr > td:first-child{
		font-weight : bold;
		font-family : 'Consolas';
		color: orangered;
	}
</style>
</head>
<body>
	<h1>Parameter</h1>
	<hr>
	<h3>
	http://
	localhost
	:8080
	/day01	
	/ex03.jsp <!-- 자원의 이름 자원의 위치 -->
	<span>?name=이지은&age=31</span> <!--쿼리스트링형식의 파라미터라고 한다. -->
	</h3>
	
	<table>
		<tr>
			<th>request Method</th>
			<th>body 유무</th>
			<th>파라미터 형식</th>
		</tr>
		<tr>
			<td>GET</td>
			<td>X</td>
			<td>queryString, 주소창으로 파라미터를 전송한다.</td>
		</tr>
		<tr>
			<td>POST</td>
			<td>O</td>
			<td>form-data (urlencoded), 별도의 공간으로 파라미터를 전송한다.</td>
		</tr>
	</table>
	
	<fieldset>
	<legend>Get</legend>
	<form method="get">
		<p><input type="text" name="p1" placeholder="입력"></p>
		<p><input type="submit"></p>
	</form>
	</fieldset>
	
	<fieldset>
	<legend>Post</legend>
	<form method="POST" >
		<p><input type="text" name="p2" placeholder="입력"></p>
		<p><input type="submit"></p>
	</form>
	</fieldset>
	
	<%
		//주소창을 통해서 전달하지 않으면, 인코딩 규치깅 달라서 글자가 깨질 수 있다.
		
	
		//모든 파라미터는 문자열(String)형식으로 받는다.
		String p1 = request.getParameter("p1");
		String p2 = request.getParameter("p2");
		
		out.print("<h3>p1:" + p1 + "</h3>");
		out.print("<h3>p2:" + p2 + "</h3>");
	%>
	
</body>
</html>