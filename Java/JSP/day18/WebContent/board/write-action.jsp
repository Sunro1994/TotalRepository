<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<c:set var="dto" value="${fileUtil.getDTO(pageContext.request) }" />
	<ul>
		<li>${dto.title }</li>
		<li>${dto.writer }</li>
		<li>${dto.content }</li>
		<li>${dto.uploadFile }</li>
	</ul>
	
	<c:set var="row" value="${boardDAO.insert(dto) }" />
<%-- 	<c:set var="max" value="${boardDAO.selectMaxIdx() }" /> --%>
<%-- 	<c:redirect url="/board/view.jsp?idx=${max }" /> --%>
</div>

</body>
</html>