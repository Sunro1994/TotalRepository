<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
	
	<c:if test="${not empty dto.uploadFile }">
		<c:set var="deleted" value="${fileUtil.delete(dto.uploadFile) }" />
	</c:if>
	
	<c:set var="row" value="${boardDAO.delete(param.idx) }" />
</div>

<script>
	const deleted = '${deleted}'
	const row = '${row}'
	
// 	if(deleted == 'true') {
// 		alert('첨부 파일 [${dto.uploadFile}]이 삭제되었습니다')
// 	}
	if(row != 0) {
		alert('게시글이 삭제되었습니다')
		location.href = '${cpath}/board/list.jsp'
	}
	else {
		history.go(-1)
	}
</script>

</body>
</html>