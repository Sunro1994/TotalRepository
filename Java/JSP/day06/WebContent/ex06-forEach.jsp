<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ex06.Test" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex06-forEach.jsp</title>
</head>
<body>

<h1>ex06-forEach.jsp</h1>
<hr>

<jsp:useBean id="test" class="ex06.Test" scope="application" />

<c:if test="${empty param.data }">
	<form>
		<p><input type="text" name="data" placeholder="추가할 데이터 입력"></p>
	</form>
	<ul>
		<c:forEach var="data" items="${test.getList() }" varStatus="st">
		<li>${st.index} : ${data }</li>			
		</c:forEach>
	</ul>
</c:if>

<c:if test="${not empty param.data }">
	<c:set var="list" value="${test.getList() }" />
	<h3>추가 결과 : ${list.add(param.data) }</h3>
	<a href="ex06-forEach.jsp"><button>다시 입력</button></a>
</c:if>


</body>
</html>



