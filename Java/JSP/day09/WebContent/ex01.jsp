<%@page import="day09.SingletonTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01.jsp</title>
</head>
<body>

<h1>ex01.jsp - singleton</h1>
<hr>

<%
	Object ob1 = new Object();

	// The constructor SingletonTest() is not visible
	// 기본 생성자의 접근제한자가 private 이므로 외부에서 생성자를 호출할 수 없다
// 	SingletonTest ob2 = new SingletonTest();
	
	SingletonTest ob2 = SingletonTest.getInstance();
	
	Object ob3 = new Object();
	
	SingletonTest ob4 = SingletonTest.getInstance();
%>
<h3>ob1 : <%=ob1 %></h3>
<h3>ob2 : <%=ob2 %></h3>
<h3>ob3 : <%=ob3 %></h3>
<h3>ob4 : <%=ob4 %></h3>
<h3><%=ob1 == ob3 %></h3>
<h3><%=ob2 == ob4 %></h3>

<c:set var="ob5" value="${SingletonTest.getInstance() }" />

<h3>ob5 : ${ob5 }</h3>








</body>
</html>












