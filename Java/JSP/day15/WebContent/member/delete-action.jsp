<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<c:if test="${empty login }">
	<c:redirect url="/member/login.jsp" />
</c:if>

<c:set var="userid" value="${param.userid }"/>

<c:set var="row" value="${memberDAO.delete(userid) }"/>

<c:if test="${row == 0 }">
	<script>
		alert('회원탈퇴 실패');
		history.go(-1);
	</script>
</c:if>

<c:if test="${row != 0 }">
	<script>
		alert('회원탈퇴 성공');
		<c:set var="login" value="${user}" scope="session"/>
		location.href='${cpath}/index.jsp';
	</script>
</c:if>


</body>
</html>