<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div>
	<jsp:useBean id="dto" class="phonebook.PhoneBookDTO" />
	<jsp:setProperty property="*" name="dto" />
	
	<c:set var="row" value="${dao.insert(dto) }" />
	<h3>${row }행이 추가되었습니다</h3>
	<a href="${cpath }/list.jsp"><button>목록으로</button></a>
	
<%-- 	<c:redirect url="/list.jsp" /> --%>
</div>


</body>
</html>