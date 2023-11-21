<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01.jsp</title>
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

<h1>ex01.jsp - JSP Action Tag</h1>
<hr>

<h3>JSP에서 자주 사용되는 작동을 태그형식으로 만든 체계</h3>

<table>
	<thead>
	<tr>
		<th>태그</th>	
		<th>예시</th>	
		<th>설명</th>	
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>useBean</td>
		<td>&lt;jsp:useBean id="ob" class="day05.Member" /></td>
		<td>
			지정한 id로 변수를 만들고, <br>
			지정한 class의 기본생성자를 호출하여 빈 객체를 생성한다<br>
			useBean으로 생성된 객체는 지정한 scope의 attribute로 자동 추가된다<br>
			scope를 지정하지 않으면 기본값은 pageContext 이다<br>
			Member ob = new Member();
		</td>
	</tr>
	<tr>
		<td>setProperty</td>
		<td>&lt;jsp:setProperty name="ob" property="name" value="이지은" /></td>
		<td>
			name에 작성한 객체를 대상으로 property에 대한 setter를 호출하면서 value를 전달한다<br>
			ob.setName("이지은");
		</td>
	</tr>
	<tr>
		<td>getProperty</td>
		<td>&lt;jsp:getProperty name="ob" property="name" /></td>
		<td>
			name에 작성된 객체를 대상으로 property의 getter를 호출하여 값을 가져온다<br>
			출력 용도로 사용할 수 있다
		</td>
	</tr>
	<tr>
		<td>forward</td>
		<td>&lt;jsp:forward page="ex02.jsp" /></td>
		<td>
			page에 지정한 문서로 forward한다<br>
			내부 태그로 &lt;jsp:param name="" value="" />를 이용하여<br>
			추가 파라미터를 전달할 수도 있다
		</td>
	</tr>
	<tr>
		<td>include</td>
		<td>&lt;jsp:include page="ex02.jsp" /></td>
		<td>
			page에 지정한 문서의 내용을 현재 위치에 포함시킨다<br>
			대상이 되는 jsp를 실행한 후 만들어지는 최종 응답만 포함시키므로<br>
			현재 파일의 변수 영역과는 공유되지 않는다 (별도의 페이지이다)
		</td>
	</tr>
	
	</tbody>
</table>

<jsp:useBean id="ob" class="day05.Member" />

<h3>ob.name : <jsp:getProperty name="ob" property="name" /></h3>
<h3>ob.age : <jsp:getProperty name="ob" property="age" /></h3>

<jsp:setProperty name="ob" property="name" value="이지은" />
<jsp:setProperty name="ob" property="age" value="31" />

<h3>ob.name : <jsp:getProperty name="ob" property="name" /></h3>
<h3>ob.age : <jsp:getProperty name="ob" property="age" /></h3>

<%@ page import="day05.Member" %>
<%
	out.print("<h4>" + ob.getName() + "</h4>");
	out.print("<h4>" + ob.getAge() + "</h4>");
	
	Member test = (Member)pageContext.getAttribute("ob");
	out.print("<h5>" + test.getName() + "</h5>");
	out.print("<h5>" + test.getAge() + "</h5>");
%>
<hr>
<h3>ob.name : ${ob.name }</h3>
<h3>ob.age : ${ob.age }</h3>

<h3>ob.name : <%=((Member)pageContext.getAttribute("ob")).getName() %></h3>
<h3>ob.name : <%=((Member)pageContext.getAttribute("ob")).getAge() %></h3>

</body>
</html>











