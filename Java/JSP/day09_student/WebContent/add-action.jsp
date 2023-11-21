<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	<c:if test="${pageContext.request.method != 'POST' }">
		<c:redirect url="/list.jsp" />
	</c:if>

	<jsp:useBean id="dto" class="student.StudentDTO" />
	<jsp:setProperty property="*" name="dto" />
	<c:set var="row" value="${dao.insert(dto) }" />
	<h3>${row }행이 추가되었습니다</h3>
	<a href="${cpath }/list.jsp"><button>목록으로</button></a>	
</div>

</body>
</html>