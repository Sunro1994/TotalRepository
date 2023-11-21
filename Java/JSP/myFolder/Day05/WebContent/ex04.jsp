<%@page import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
		border : 2px solid black;
		border-collapse : collapse;
	}
	td, th {
		padding : 10px;
		border : 1px solid grey;
	}
	thead{
		background-color: #eee;
	}
</style>
</head>
<body>
	<h1>EL Tag</h1>
	
	<ul>
		<li>attribute에 접근하여 값을 출력한다</li>
		<li>다운캐스팅 없이 메서드를 호출할 수 있다.</li>
		<li>산술연산, 비교연산, 논리연산이 가능하다.</li>
		<li>empty, not empty 등을 통해 null체크 수행도 가능하다.</li>
		<li>대상이 없으면 아무 값도 출력하지 않는다.(null은 출력안함)</li>
		<li>\${param.name} 형식으로 파라미터 값을 출력할 수 있다.</li>
		<li>내장 객체 pageContext에 접근이 가능하다.</li>
	</ul>
	
	<!--  
	삼항연산이 가능하다. 
	숫자 연산은 가능하지만 문자열 연산은 불가능하다.	
	더하기 연산자가 있는 경우 문자열을 모두 숫자로 판단
	-->
	<fieldset>
		<h3>${not empty param.name ? param.name : '없음' }</h3>
	</fieldset>
	<fieldset>
		<legend>문자열 덧셈은 불가능</legend>
		<h3>${'1104'+'100'}</h3>
		<h3>${'110100'}</h3>
		<h3>${'1104'}${"a"}</h3>
	</fieldset>
	
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
				<td>\${12+23 }</td>
				<td>${12+23}</td>
			</tr>
			<tr>
				<td>-</td>
				<td>\${12-23 }</td>
				<td>${12-23}</td>
			</tr>
			<tr>
				<td>*</td>
				<td>\${12*23 }</td>
				<td>${12*23}</td>
			</tr>
			<tr>
				<td>/, div</td>
				<td>\${10/3 }</td>
				<td>${10/3}</td>
			</tr>
			<tr>
				<td>%,mod</td>
				<td>\${10%3 }</td>
				<td>${10%3}</td>
			</tr>
			<tr>
				<td>>,gt</td>
				<td>\${10>3 }</td>
				<td>${10>3}</td>
			</tr>
			<tr>
				<td>%,lt</td>
				<td>\${10<3 }</td>
				<td>${10<3}</td>
			</tr>
			<tr>
				<td>>,ge</td>
				<td>\${10>=3 }</td>
				<td>${10>=3}</td>
			</tr>
			<tr>
				<td>%,le</td>
				<td>\${10<=3 }</td>
				<td>${10<=3}</td>
			</tr>
			<tr>
				<td>==,eq</td>
				<td>\${10==3 }</td>
				<td>${10 eq 3}</td>
			</tr>
			<tr>
				<td>!=,ne</td>
				<td>\${10!=3 }</td>
				<td>${10 ne 3}</td>
			</tr>
			<tr>
				<td>&&,and</td>
				<td>\${10%2 ==0 && 10 >2}</td>
				<td>${10%2 ==0 and 10 >2}</td>
			</tr>
			<tr>
				<td>||,or</td>
				<td>\${10%2 ==0 || 10 <2}</td>
				<td>${10%2 ==0 or 10 <2}</td>
			</tr>
			<tr>
				<td>!,not</td>
				<td>\${!(10 <2)}</td>
				<td>${not(10<2)}</td>
			</tr>
			
			<%@ page import="java.util.*" %>
			
			<%
				String[] arr = {
						"이효리","옥주현","성유리","이진"
				};
			pageContext.setAttribute("arr", arr);
			
			List<String> list = Arrays.asList(arr);
			pageContext.setAttribute("list", list);
			
			HashMap<String,String> map = new HashMap();
			map.put("위","조조");
			map.put("촉","유비");
			map.put("오","손권");
			map.put("title","손권");
			pageContext.setAttribute("map", map);
			%>
			<!-- 위처럼 내장객체에 값을 넣어줘야 el태그로 사용할 수 있다.
				배열이나 리스트는 모두 동일하게 인덱스로 접근한다.
				
				map은 [''], .을 이용한 접근이 가능하다(영어한정)
				한글은 ['']만 가능하다.
				
				param은 파라미터를 가져오는 객체이다.
				param.name을 하면 파라미터 이름을 가져온다.
				Attribute대상이 아닌 넘어온 파라미터를 대상으로 한다.
			 -->
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
				<td>param.name<br>(request.getParameter("name"))</td>
				<td>\${param.name }</td>
				<td>${param.name }</td>
			</tr>
			<tr>
				<td>param.age<br>(request.getParameter("age");)</td>
				<td>\${param.name }</td>
				<td>${param.name }</td>
			</tr>
			<tr>
				<td>header. 또는 header[]</td>
				<td>\$header['host']}</td>
				<td>${header['host']}</td>
			</tr>
			<!--  user-agent인 경우  '-'의경우 연산자로 취급하기 때문에 []안에 넣어줘야 한다.-->
			<tr>
				<td> header[]</td>
				<td>\$header['user-agent']}</td>
				<td>${header['user-agent']}</td>
			</tr>
			<!--  pageContext는 다른 내장객체와의 다리 역할을 할 수 있다. -->
			<tr>
				<td> pagecontext</td>
				<td>\${pageContext}</td>
				<td>${pageContext}</td>
			</tr>
			<tr>
				<td> request</td>
				<td>\${pageContext.request}</td>
				<td>${pageContext.request}</td>
			</tr>
			<tr>
				<td> session</td>
				<td>\${pageContext.session}</td>
				<td>${pageContext.session}</td>
			</tr>
			<tr>
				<td> application</td>
				<td>\${pageContext.servletContext}</td>
				<td>${pageContext.servletContext}</td>
			</tr>
			
			
			
			
			
			
		</tbody>
	</table>
</body>
</html>