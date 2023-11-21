<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<jsp:useBean id="dto" class="board.BoardDTO" />
	<jsp:setProperty property="*" name="dto" />
	<c:set var="row" value="${boardDAO.insert(dto) }" />
	<c:if test="${row == 0 }">
		<c:redirect url="/board/write.jsp" />
	</c:if>
	<c:if test="${row != 0 }">
		<c:set var="idx" value="${boardDAO.selectMaxIdx() }" />
		<c:redirect url="/board/view.jsp?idx=${idx }" />
	</c:if>
</div>

</body>
</html>