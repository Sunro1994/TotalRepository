<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<c:if test="${empty login }">
	<c:redirect url="/member/login.jsp" />
</c:if>

<c:set var="row" value="${boardDAO.delete(param.idx) }" />

<c:if test="${row == 0 }">
	<c:redirect url="/board/view.jsp?idx=${param.idx }" />
</c:if>
<c:if test="${row != 0 }">
	<c:redirect url="/board/list.jsp" />
</c:if>

</body>
</html>