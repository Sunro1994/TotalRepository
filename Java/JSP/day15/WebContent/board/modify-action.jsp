<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<c:if test="${empty login }">
	<c:redirect url="/member/login.jsp" />
</c:if>

<jsp:useBean id="dto" class="board.BoardDTO" />
<jsp:setProperty property="*" name="dto"/>

<c:set var="row" value="${boardDAO.update(dto) }" />

<script>
	const row = '${row}';
	
	if(row == 0){
		alert('수정 실패');
		history.go(-1);
	}else{
		alert('수정 성공');
		location.href='${cpath}/board/view.jsp?idx=${dto.idx}';
	}
</script>
</body>
</html>