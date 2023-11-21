<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-jstl.jsp</title>
<style>
	table {
		border: 2px solid black;
		border-collapse: collapse;
	}
	th {
		padding: 10px;
		border: 1px solid grey;
		background-color: #dadada;
	}
	td {
		padding: 10px;
		border: 1px solid grey;
	}
	tr > td:nth-child(2) {
		color: orangered;
		font-family: 'Consolas';
		font-weight: bold;	
	}
</style>
</head>
<body>

<h1>ex02-jstl.jsp</h1>
<hr>

<h3>Jsp Standard Tag Library (JSP 표준 태그 라이브러리)</h3>

<ul>
	<li>HTML문서 내부에서 자바코드로 진행하는 형식을 어려워하거나 꺼려하는 개발자가 많았다</li>
	<li>JSP 액션태그와 마찬가지로 태그 형태로 된 코드를 직접 만들어쓰기 시작했다</li>
	<li>서로 다른 사람이 커스텀 태그를 많이 만들다 보니 표준이 없어서 문제가 되었다</li>
	<li>JSP에서 많이 사용되는 태그의 표준을 정해서 묶어놓은 라이브러리가 만들어졌다</li>	
</ul>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<table>
	<thead>
		<tr>
			<th>접두사</th>
			<th>역할</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>c (core)</td>
			<td>set, remove, if, forEach, redirect 등 사용빈도가 가장 높은 태그</td>
		</tr>
		<tr>
			<td>fmt</td>
			<td>숫자 및 날짜 형식을 지정하기 위해 사용</td>
		</tr>
		<tr>
			<td>fn (functions)</td>
			<td>length, substring, split 등 함수로 처리해야 하는 내용을 보조한다</td>
		</tr>
		<tr>
			<td>sql</td>
			<td>DB접속 및 쿼리문 실행 (DAO를 분리하면 사용하지 않는다)</td>
		</tr>
		<tr>
			<td>x (xml)</td>
			<td>xml을 제어하기 위핸 태그, 거의 사용하지 않는다</td>
		</tr>
	</tbody>
</table>

</body>
</html>










