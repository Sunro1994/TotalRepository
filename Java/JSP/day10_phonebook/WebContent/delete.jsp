<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>삭제</h3>
<div>
	<c:set var="row" value="${dao.delete(param.idx) }" />
	<script>
		const row = '${row}'
		
		if(row == 0) {
			alert('삭제하지 못했습니다')
		}
		else {
			alert(row + '개 행이 삭제되었습니다')
		}
		location.href = '${cpath}/list.jsp'
		
		// <a href="${cpath}/list.jsp"><button>목록으로</button></a>
	</script>
</div>

</body>
</html>