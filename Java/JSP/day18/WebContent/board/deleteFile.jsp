<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
	
	<c:if test="${not empty dto.uploadFile }">
		<c:set var="deleted" value="${fileUtil.delete(dto.uploadFile) }" />
	</c:if>
	
	<c:set var="row" value="${boardDAO.removeFile(param.idx) }" />
	
	<c:redirect url="${header['referer'] }" />
</div>



</body>
</html>