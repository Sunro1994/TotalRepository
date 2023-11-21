<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ex07-forEach.jsp</title>
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
	tr.red {
		background-color: lightpink;
	}
	tr.blue {
		background-color: lightskyblue;
	}
</style>
</head>
<body>

<h1>ex07-forEach.jsp</h1>
<hr>


<%-- <h3>${list }</h3> --%>
<table>
	<thead>
		<tr>
			<th>index</th>
			<th>name</th>
			<th>age</th>
		</tr>
	</thead>
	<tbody>
	<jsp:useBean id="repo" class="ex07.Repository" />
	<c:set var="list" value="${repo.list }" />
	
	<%@page import="java.util.ArrayList, ex07.Member"%>
	<%
// 		ArrayList<Member> list = (ArrayList<Member>)pageContext.getAttribute("list");
// 		for(int i = 0; i < list.size(); i++) {
// 			Member mem = list.get(i);
// 			out.print("<tr>");
// 			out.print("	<td>" + i + "</td>");
// 			out.print("	<td>" + mem.getName() + "</td>");
// 			out.print("	<td>" + mem.getAge() + "</td>");
// 			out.print("</tr>");
// 		}
	%>
	<c:forEach var="mem" items="${list }" varStatus="st">
		<tr class="${st.index % 2 == 0 ? 'red' : 'blue' }">
			<td>${st.index }</td>
			<td>${mem.name }</td>
			<td>${mem.age }</td>
		</tr>	
	</c:forEach>
	</tbody>
</table>

</body>
</html>




