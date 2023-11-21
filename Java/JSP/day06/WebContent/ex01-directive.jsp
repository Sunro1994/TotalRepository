<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01-directive.jsp</title>
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

<h1>ex01-directive.jsp</h1>
<hr>

<table>
	<tr>
		<th>지시자</th>
		<th>예시</th>
		<th>설명</th>
	</tr>
	<tr>
		<td>page</td>
		<td>&lt;%@ page language="" import="" session="" %></td>
		<td>
			<ul>
				<li>전체 페이지에 적용되는 설정을 작성한다</li>
				<li>import 속성에서 다른 클래스를 불러올 수 있다</li>
				<li>session 설정에서 세션 사용 여부를 결정할 수 있다</li>
			</ul>
		</td>
	</tr>
	<tr>
		<td>include</td>
		<td>&lt;%@ include file="" %></td>
		<td>
			<ul>
				<li>다른 jsp파일을 지정한 위치에 포함시킨다</li>
				<li>액션 태그 include와 달리, 소스코드를 하나로 합친 이후 컴파일 한다</li>
				<li>대상 file의 변수를 현재 파일이 공유받을 수 있다</li>
			</ul>
		</td>
	</tr>
	<tr>
		<td>taglib</td>
		<td>&lt;%@ taglib prefix="" uri="" %></td>
		<td>
			<ul>
				<li>기본 태그 외 다른 태그를 커스텀 태그를 불러와서 사용할 수 있게 한다.</li>
				<li>JSTL 사용시 필수</li>
			</ul>
		</td>
	</tr>
</table>


</body>
</html>





