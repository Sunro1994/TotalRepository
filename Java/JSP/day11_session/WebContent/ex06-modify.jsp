<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex06-modify.jsp</title>
</head>
<body>

<h1>ex06-modify.jsp</h1>
<hr>


<h3>정보 수정</h3>
<form method="POST" action="ex06-action.jsp">
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<td>ID</td>
			<td>
				${login.userid }
	<%-- 			<input type="text" name="userid" value="${login.userid }" readonly> --%>
				<input type="hidden" name="userid" value="${login.userid }" readonly>
				<%--사용자가 직접 입력하지는 않지만, 파라미터로 전달하고 싶을 때 type="hidden" 을 사용한다 --%>
			</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>${login.userpw }</td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="username" value="${login.username }"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" value="${login.email }"></td>
		</tr>
		<tr>
			<td>Birth</td>
			<td><input type="date" name="birth" value="${login.birth }"></td>
		</tr>
	</table>
	<p>
		<input type="submit" value="수정하기">
		<a href="ex04-mypage.jsp"><input type="button" value="돌아가기"></a>
	</p>
</form>


</body>
</html>