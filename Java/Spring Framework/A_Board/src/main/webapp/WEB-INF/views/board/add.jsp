<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../check.jsp" %>

	<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="title" placeholder="제목"required></p>
	<p><input type="text" name="writer_idx" placeholder="작성자 고유번호" value="${login.member_idx}" readonly></p>
	<p><input type="text" name="writer" placeholder="작성자" value="${login.userid}" readonly></p>
	<p><input type="file" name="contentImg" ></p>
	<p><textarea name="content"></textarea></p>
	<p><input type="submit"></p>
	</form>

</body>
</html>