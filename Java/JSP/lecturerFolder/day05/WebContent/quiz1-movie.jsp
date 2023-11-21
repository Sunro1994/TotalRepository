<%@page import="day05.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz1-movie.jsp</title>
<style>
	table {
		border: 2px solid black;
		border-collapse: collapse;
	}
	td, th {
		padding: 10px;
		border: 1px solid grey;
	}
	thead {
		background-color: #eee;
	}
	
</style>
</head>
<body>

<h1>quiz1-movie.jsp</h1>
<hr>
<%@ page import="java.util.ArrayList, day05.Movie" %>
<%
	// application에서 "list"라는 이름의 list를 받아온다 (없으면 null) 
	ArrayList<Movie> list = (ArrayList<Movie>)application.getAttribute("list");

	// 만약, list가 null이면 (없으면)
	if(list == null) {
		list = new ArrayList<>();				// 새로운 리스트를 생성해서
		application.setAttribute("list", list);	// 방금 만든 리스트를 "list"라는 이름으로 추가한다
	}
// 	list.sort((a, b) -> a.getRank() - b.getRank());
%>

<fieldset>
	<legend>데이터 추가</legend>
	<form method="POST" action="quiz1-action.jsp">
		<p><input type="text" name="rank" placeholder="순위"></p>
		<p><input type="text" name="title" placeholder="제목"></p>
		<p><input type="text" name="openningDate" placeholder="개봉일"></p>
		<p><input type="number" name="reserveRate" placeholder="예매율" min="0" max="100" step="0.1"></p>
		<p><input type="text" name="reserveCount" placeholder="예매관객수"></p>
		<p><input type="text" name="watchCount" placeholder="누적관객수"></p>
		<p><input type="submit"></p>
	</form>
</fieldset>

<h3>추가된 영화 데이터 목록</h3>
<table>
	<thead>
		<tr>
			<th>순위</th>
			<th>제목</th>
			<th>개봉일</th>
			<th>예매율</th>
			<th>예매관객수</th>
			<th>누적관객수</th>
		</tr>
	</thead>
	<tbody>
	<%	for(Movie movie : list)  {%>
	<tr>
		<td><%=movie.getRank() %></td>
		<td><%=movie.getTitle() %></td>
		<td><%=movie.getOpenningDate() %></td>
		<td><%=movie.getReserveRate() %>%</td>
		<td><%=movie.getReserveCount() %></td>
		<td><%=movie.getWatchCount() %></td>
	</tr>
	<%	} %> 
	</tbody>
</table>


</body>
</html>