<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<%
		session.invalidate();
		response.sendRedirect(request.getContextPath());
	%>
</div>
</body>
</html>