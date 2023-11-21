<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex06-form.jsp</title>
</head>
<body>

<h1>ex06-form.jsp</h1>
<hr>

<%--로그인 객체가 없을 경우 : 로그인을 위한 값을 입력받기 위한 form을 출력한다 --%>
<c:if test="${empty login }">
	<form method="POST" action="ex06-action.jsp">
		<p><input type="text" name="userid" placeholder="ID" 
				  value="${cookie.userid.value }"
			      autocomplete="off" required autofocus></p>
      	<p><input type="password" name="userpw" placeholder="Password"
      			  required autofocus></p>
		<p>
			<label>
				<input type="checkbox" name="storeId" 
				       ${not empty cookie.userid ? 'checked' : ''}>
				ID 저장
			</label>
		</p>
		<p><input type="submit" value="로그인"></p>      			  
	</form>
</c:if>

<%--로그인 객체가 있을 경우 --%>
<c:if test="${not empty login }">
	<h3>
		현재 사용자 : ${login.userid }
		(${login.username }) 
	</h3>
	<a href="ex06-logout.jsp"><button>로그아웃</button></a>
</c:if>

</body>
</html>