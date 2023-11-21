<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01.jsp</title>
<style>
	table {
		border-collapse: collapse;
		border: 2px solid black;
	}
	td, th {
		padding: 10px;
		border: 1px solid grey;
	}
</style>
</head>
<body>

<h1>Server와 Client에서 활용하는 값 비교</h1>
<hr>

<table>
	<thead>
		<tr>
			<th colspan="2">Server</th>
			<th colspan="2">Client</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>attribute</td>
			<td>서버에서 만들어서 사용하는 값(객체)</td>
			<td>parameter</td>
			<td>클라이언트에서 입력해서 서버에게 넘겨주는 값(문자열)</td>
		</tr>
		<tr>
			<td>session</td>
			<td>각 사용자를 전담 관리하기 위한 내장 객체<br>모든 자바 객체 저장 가능</td>
			<td>cookie</td>
			<td>클라이언트가 자신에게 필요한 값을 보관하는 형태<br>문자열만 저장 가능</td>
		</tr>
	</tbody>
</table>

</body>
</html>




