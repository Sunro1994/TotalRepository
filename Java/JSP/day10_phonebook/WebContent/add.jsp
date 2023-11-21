<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>추가 페이지</h3>
<form method="POST" action="${cpath }/add-action.jsp">
	<p><input type="text" name="name" placeholder="이름"></p>
	<p><input type="text" name="pnum" placeholder="전화번호"></p>
	<p><input type="submit"></p>
</form>

</body>
</html>