<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01-form.jsp</title>
</head>
<body>

<h1>ex01-form.jsp</h1>
<hr>

<table border="1" cellpadding="10" cellspacing="0">
	<tr>
		<td>
			cookie.JSESSIONID.value<br>
			내가 마지막으로 사용한 세션의 ID
		</td>
		<td>${cookie.JSESSIONID.value }</td>
	</tr>
	<tr>
		<td>
			session.id<br>
			현재 사용중인 세션의 ID
		</td>
		<td>${pageContext.session.id }</td>
	</tr>
</table>

<c:if test="${empty login }">
	<h3>로그인 폼</h3>
	<form method="POST" action="ex01-action.jsp">
		<p><input type="text" name="userid" placeholder="ID" required autofocus autocomplete="off"></p>
		<p><input type="password" name="userpw" placeholder="Password" required></p>
		<p>
			<label>
				<input type="checkbox" name="autologin">
				자동 로그인
			</label>
		</p>
		<p><input type="submit" value="로그인"></p>
	</form>
</c:if>

<c:if test="${not empty login }">
	<h3>현재 접속된 사용자 : ${login.userid } (${login.username })</h3>
	<p>
		<a href="ex01-logout.jsp"><button>로그아웃</button></a>
	</p>
</c:if>


</body>
</html>