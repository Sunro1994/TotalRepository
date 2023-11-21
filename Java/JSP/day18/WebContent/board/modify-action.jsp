<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<c:set var="dto" value="${fileUtil.getDTO(pageContext.request) }" />
	<c:set var="row" value="${boardDAO.modify(dto) }" />
	<c:redirect url="/board/view.jsp?idx=${dto.idx }" />
</div>

</body>
</html>