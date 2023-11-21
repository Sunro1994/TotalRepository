<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>quiz1.jsp</title>
<style>
	table {
		border: 2px solid black;
		border-collapse: collapse;
		margin: 20px auto;
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

<h1>quiz1.jsp</h1>
<hr>
<%@ page import="java.io.File, java.util.Scanner, java.util.ArrayList" %>
<%
	String filePath = application.getRealPath("passwd.txt");
	out.print(filePath);
	File f = new File(filePath);
	Scanner sc = new Scanner(f);
	ArrayList<String> list = new ArrayList<>();
	
	while(sc.hasNextLine()) {
		String line = sc.nextLine();
		list.add(line);
	}
	sc.close();
	
	pageContext.setAttribute("list", list);
%>
<table>
	<thead>
		<tr>
			<th>계정이름</th>
			<th>비밀번호</th>
			<th>UID</th>
			<th>GID</th>
			<th>comment</th>
			<th>HomeDirectory</th>
			<th>Shell</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="line" items="${list }">
		<tr>
<%-- 			<td>${line }</td> --%>

<%-- 			<c:forTokens var="str" items="${line }" delims=":"> --%>
<%-- 			<td>${str }</td> --%>
<%-- 			</c:forTokens> --%>

<%-- 			<c:forEach var="str" items="${line.split(':') }"> --%>
<%-- 				<td>${str }</td> --%>
<%-- 			</c:forEach> --%>

			<c:forEach var="i" begin="0" end="6">
				<td>${line.split(':')[i] }</td>
			</c:forEach>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>









