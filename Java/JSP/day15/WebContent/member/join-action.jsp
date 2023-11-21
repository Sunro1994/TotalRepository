<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<jsp:useBean id="user" class="member.MemberDTO" />
<jsp:setProperty property="*" name="user"/>

<c:set var="row" value="${memberDAO.addMember(user) }"/>

<c:if test="${row == 0 }">
	<script>
		alert('회원가입 실패');
		history.go(-1);
	</script>
</c:if>

<c:if test="${row != 0 }">
	<script>
		alert('회원가입 성공');
		location.href='${cpath}/index.jsp';
	</script>
</c:if>

</body>
</html>