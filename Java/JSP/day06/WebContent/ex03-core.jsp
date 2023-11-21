<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ex03.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03-core.jsp</title>
</head>
<body>

<h1>ex03-core.jsp</h1>
<hr>

<h3>c:set == setAttribute(var, value)</h3>
<c:set var="test1" value="Hello" scope="page" />
<c:set var="test2" value="world" scope="request" />
<c:set var="test3" value="Java" scope="session" />
<c:set var="test4" value="JSP" scope="application" />

<ul>
	<li>${pageScope.test1 }</li>
	<li>${requestScope.test2 }</li>
	<li>${sessionScope.test3 }</li>
	<li>${applicationScope.test4 }</li>
</ul>

<h3>특정 객체에 대해 속성(필드)을 지정할 수도 있다</h3>

<jsp:useBean id="m1" class="ex03.Member" />
<ul>
	<li>m1.name : ${m1.name }</li>
	<li>m1.age : ${m1.age }</li>
</ul>
<c:set target="${m1 }" property="name" value="이지은" />
<c:set target="${m1 }" property="age" value="31" />
<ul>
	<li>m1.name : ${m1.name }</li>
	<li>m1.age : ${m1.age }</li>
</ul>
<c:remove var="m1" scope="page" />	<%--removeAttribute(m1) --%>
<ul>
	<li>m1.name : ${m1.name }</li>
	<li>m1.age : ${m1.age }</li>
</ul>

</body>
</html>







