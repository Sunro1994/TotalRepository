<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<h1>ex04.jsp</h1>
<hr>

<ul>
	<li>attribute에 접근하여 값을 출력한다</li>
	<li>다운캐스팅 없이 메서드를 호출할 수 있다</li>
	<li>산술연산, 비교연산, 논리연산이 가능하다</li>
	<li>empty, not empty 등을 통해 null체크 수행도 가능하다</li>
	<li>대상이 없으면 아무 값도 출력하지 않는다(null은 출력안함)</li>
	<li>\${param.name } 형식으로 파라미터의 값을 출력할 수 있다</li>
	<li>내장 객체 pageContext에 접근 가능하다</li>
</ul>

<fieldset>
	<h3>${not empty param.name ? param.name : '없음' }</h3>
</fieldset>

<fieldset>
	<legend>문자열 덧셈은 불가능</legend>
	<h3>${'1104'}${"a" }</h3>
</fieldset>
<br>
<table>
	<thead>
		<tr>
			<th>연산자</th>
			<th>예시</th>
			<th>결과</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>+</td>
			<td>\${12 + 23 }</td>
			<td>${12 + 23 }</td>
		</tr>
		<tr>
			<td>-</td>
			<td>\${12 - 23 }</td>
			<td>${12 - 23 }</td>
		</tr>
		<tr>
			<td>*</td>
			<td>\${12 * 23 }</td>
			<td>${12 * 23 }</td>
		</tr>
		<tr>
			<td>/, div</td>
			<td>\${10 / 3 }</td>
			<td>${10 / 3 }</td>
		</tr>
		<tr>
			<td>%, mod</td>
			<td>\${10 % 3 }</td>
			<td>${10 % 3 }</td>
		</tr>
		<tr>
			<td>>, gt</td>
			<td>\${10 > 3 }</td>
			<td>${10 > 3 }</td>
		</tr>
		<tr>
			<td><, lt</td>
			<td>\${10 < 3 }</td>
			<td>${10 < 3 }</td>
		</tr>
		<tr>
			<td>>=, ge</td>
			<td>\${10 >= 3 }</td>
			<td>${10 >= 3 }</td>
		</tr>
		<tr>
			<td><=, le</td>
			<td>\${10 <= 3 }</td>
			<td>${10 <= 3 }</td>
		</tr>
		<tr>
			<td>==, eq</td>
			<td>\${10 == 3 }</td>
			<td>${10 eq 3 }</td>
		</tr>
		<tr>
			<td>!=, ne</td>
			<td>\${10 != 3 }</td>
			<td>${10 != 3 }</td>
		</tr>
		<tr>
			<td>&&, and</td>
			<td>\${10 % 2 == 0 && 10 > 2 }</td>
			<td>${10 % 2 == 0 and 10 > 2 }</td>
		</tr>
		<tr>
			<td>||, or</td>
			<td>\${10 % 2 == 0 || 10 < 2 }</td>
			<td>${10 % 2 == 0 or 10 < 2 }</td>
		</tr>
		<tr>
			<td>!, not</td>
			<td>\${!(10 < 2)}</td>
			<td>${not (10 < 2)}</td>
		</tr>
		<%@ page import="java.util.*" %>
		<%
			String[] arr = {"이효리", "옥주현", "성유리", "이진"};
			pageContext.setAttribute("arr", arr);
			
			List<String> list = Arrays.asList(arr);
			pageContext.setAttribute("list", list);
			
			HashMap<String, String> map = new HashMap<>();
			map.put("위", "조조");
			map.put("촉", "유비");
			map.put("오", "손권");
			map.put("title", "Romance of Three Kingdoms");
			pageContext.setAttribute("map", map);
		%>
		<tr>
			<td>array[]</td>
			<td>\${arr[0] }</td>
			<td>${arr[0] }</td>
		</tr>
		<tr>
			<td>list[]</td>
			<td>\${list[1] }</td>
			<td>${list[1] }</td>
		</tr>
		<tr>
			<td>map[]</td>
			<td>\${map['위'] }</td>
			<td>${map['위'] }</td>
		</tr>
		<tr>
			<td>map.</td>
			<td>\${map.title }</td>
			<td>${map.title }</td>
		</tr>
		<tr>
			<td>param.name <br>(request.getParameter("name");)</td>
			<td>\${param.name }</td>
			<td>${param.name }</td>
		</tr>
		<tr>
			<td>param.age <br>(request.getParamter("age");)</td>
			<td>\${param.age }</td>
			<td>${param.age }</td>
		</tr>
		<tr>
			<td>header.</td>
			<td>\${header.host }</td>
			<td>${header.host }</td>
		</tr>
		<tr>
			<td>header[]</td>
			<td>\${header['user-agent'] }</td>
			<td>${header['user-agent'] }</td>
		</tr>
		<tr>
			<td>pageContext</td>
			<td>\${pageContext }</td>
			<td>${pageContext }</td>
		</tr>
		<tr>
			<td>request</td>
			<td>\${pageContext.request }</td>
			<td>${pageContext.request }</td>
		</tr>
		<tr>
			<td>session</td>
			<td>\${pageContext.session }</td>
			<td>${pageContext.session }</td>
		</tr>
		<tr>
			<td>application</td>
			<td>\${pageContext.servletContext }</td>
			<td>${pageContext.servletContext }</td>
		</tr>
	</tbody>
</table>

</body>
</html>
		







