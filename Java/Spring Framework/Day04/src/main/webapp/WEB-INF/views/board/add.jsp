<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<form method="POST" >
	<p><input type="text" name="title" placeholder="글 제목"></p>
	<p><textarea name="content" placeholder="내용"></textarea></p>
	<p><input type="password" name="pwd" placeholder="비밀번호" autocomplete="off"></p>
	<p><input type="submit"></p>
</form>
</body>
</html>