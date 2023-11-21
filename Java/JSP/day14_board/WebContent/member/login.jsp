<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<h3>로그인</h3>
	<form method="POST" action="${cpath }/member/login-action.jsp">
		<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
		<p><input type="password" name="userpw" placeholder="Password" required></p>
		<p>
			<label>
				<input type="checkbox" name="storeId">
				ID 저장
			</label>
			<label>
				<input type="checkbox" name="autologin">
				자동 로그인
			</label>
		</p>
		<p><input type="submit" value="로그인"></p>
	</form>
	<a href="${cpath }/member/join.jsp">아직 회원이 아니십니까</a>
</div>



</body>
</html>