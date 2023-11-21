<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<jsp:useBean id="user" class="member.MemberDTO" />
	<jsp:setProperty property="*" name="user" />
	
	<c:set var="login" value="${memberDAO.login(user) }" scope="session" />
	<script>
		const login = '${login}'
		if(login == '') {
			alert('로그인 실패')
			history.go(-1)
		}
		else {
			location.href = '${cpath}'
		}
	</script>
</div>

</body>
</html>