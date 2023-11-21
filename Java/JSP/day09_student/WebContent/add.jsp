<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	<h3>추가</h3>
	<form method="POST" action="${cpath }/add-action.jsp">
		<p><input type="text" name="name" placeholder="name"></p>
		<p><input type="number" name="kor" placeholder="kor" min="0" max="100"></p>
		<p><input type="number" name="eng" placeholder="eng" min="0" max="100"></p>
		<p><input type="number" name="math" placeholder="math" min="0" max="100"></p>
		<p><input type="submit" value="등록">
	</form>
</div>

</body>
</html>