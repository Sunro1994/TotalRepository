<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex04.jsp</title>
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

<h1>ex04.jsp - 전화번호부 목록</h1>
<hr>

<details>
	<summary>데이터 추가</summary>
	<fieldset>
		<form method="POST">
			<p><input type="text" name="name" placeholder="이름" required></p>
			<p><input type="text" name="pnum" placeholder="전화번호" required></p>
			<p><input type="submit"></p>
		</form>
	</fieldset>
</details>
<br>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
	
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.idx }</td>
			<td>${dto.name }</td>
			<td>${dto.pnum }</td>
			<td>
				<a href="${cpath }/ex04/delete?idx=${dto.idx}"><button>삭제</button></a>
			</td>
		</tr>
	</c:forEach>
	
	</tbody>
</table>

</body>
</html>