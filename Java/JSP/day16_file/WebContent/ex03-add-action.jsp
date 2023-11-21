<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ex03-header.jsp" %>

<div>
	<c:set var="dto" value="${fileUtil.getDTO(pageContext.request) }" />
	
	<c:if test="${not empty dto }">
		<c:set var="row" value="${dao.insert(dto) }" />
		<c:redirect url="/ex03-list.jsp" />
	</c:if> 
	
	<c:if test="${empty dto }">
		<script>
			alert('모든 항목을 입력하고, 파일은 이미지만 가능합니다')
			history.go(-1)
		</script>
	</c:if>
</div>

</body>
</html>