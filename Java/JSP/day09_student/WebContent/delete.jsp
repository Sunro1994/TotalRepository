<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	삭제할 항목 : ${param.name }
	<c:set var="row" value="${dao.delete(param.name) }" />
	<h3>${row }행이 삭제되었습니다</h3>
</div>

</body>
</html>