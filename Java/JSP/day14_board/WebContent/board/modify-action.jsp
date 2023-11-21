<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<jsp:useBean id="dto" class="board.BoardDTO" />
	<jsp:setProperty property="*" name="dto"/>
	<c:set var="row" value="${boardDAO.modify(dto) }" />
	<c:redirect url="/board/view.jsp?idx=${dto.idx }" />
</div>

</body>
</html>