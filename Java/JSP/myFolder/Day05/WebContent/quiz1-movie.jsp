<%@page import="day05.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.list{
		border : 1px dashed green;
		width : 200px;
		margin: 10px auto;
		background-color: #37485D;
		color: white;
		border-radius : 10px;
		font-size : 1.2em;
	}
	
	.list p{
		border-bottom : 1px solid grey;
		padding : 10px;
	}
	
	.func{
		padding : 20px;
		border : 1px solid black;
		width : fit-content;
		margin:  10px auto;
		border-radius : 20px;
		background-color : #37485D;
		height : fit-content;
	}
	h2{
		text-align: center;
		margin : 0;
		padding : 0;
		width : 169px;
		border-radius : 20px;
		color:white;
	}
	h3{
		margin : auto;
		text-align:center;
		width : 400px;
		align-items: center;
		border-bottom : 5px solid blue;
	}
	input{
		all:unset;
		width: 169px;
		border : 0.3px solid #7F7F7F;
		border-radius : 10px;
		padding : 10px;
		color: white;
		text-align : center;
	}
	input:hover { 
		background-color : #EBEBEB;
		color : black;
	
	}
	h2{
		position : relative;
	}
	h2:hover span{
		opacity: 1;
		transition-duration : 1s;
	}
	span{
		opacity : 0;
		position: absolute;
		width : 70px;
		hieght: 30px;
		background-color: black;
		color: white;
		border-radius : 20px 20px 20px 0;
		top: -8px;
		border : 3px dashed white;
		font-size : 0.7rem;
	}
	.Integratedbox{
	width: 100%;
	display: flex;
	}
	
</style>
</head>
<body>
	<%@ page import="java.util.*" %>
	<div class="Integratedbox">
	<div class="func">
	<h2>추가하기 기능</h2>
	<form method="POST" action="quiz1-action.jsp">
		<p><input type="number" name="rank" placeholder="순위"  ></p>
		<p><input type="text" name="title" placeholder="제목"  ></p>
		<p><input type="text" name="openningDate" placeholder="개봉일"  ></p>
		<p><input type="number" step="0.01" name="reserveRate" placeholder="에매율"  ></p>
		<p><input type="number" name="reserveCount" placeholder="예매관객수"  ></p>
		<p><input type="number" name="watchCount" placeholder="누적관객수"  ></p>
		<p><input type="submit" value="제출"></p>
	</form>
	</div>
	<div class="func">
	<h2>삭제하기 기능</h2>
	<form methd="POST" action="quiz1-delete.jsp">
		<p><input type="text" name="search" placeholder="삭제할 영화 이름"></p>
		<p><input type="submit">
	</form>
	</div>
	<div class="func">
	<h2>정렬하기 기능<span>오름차순</span></h2>
	<form methd="POST" action="quiz-sort.jsp">
		<p><input type="submit" value="정렬하기">
	</form>
	</div>
	<div class="func">
	<h2>수정하기 기능</h2>
	<form methd="POST" action="quiz-alert.jsp">
		<p><input type="text" name="titleName" placeholder="현재 제목" ></p>
		<p><input type="submit" value="수정하기">
	</form>
	</div>
	</div>
	<h3>추가된 영화 데이터 목록</h3>
	<div class="listbox">
	<% 
		ArrayList<Movie> list = (ArrayList<Movie>)application.getAttribute("list");
		
		if(list == null) {
			list = new ArrayList();
			application.setAttribute("list", list);
		}
		else{
		for(int i=0; i<list.size();i++){
			Movie ob = list.get(i);%>
			
			<div class="list">
			<p>순위 : <%=ob.getRank() %></p>
			<p>제목 :<%=ob.getTitle()%></p>
			<p>개봉일 : <%=ob.getOpenningDate()%></p>
			<p>예매율 : <%=ob.getReserveRate() %>%</p>
			<p>누적매출 : <%=ob.getReserveCount() %>원</p>
			<p>누적관객수 : <%=ob.getWatchCount() %>명</p>
			</div>
	</div>
		<% }}
	
	%>
	
	
	
</body>
</html>