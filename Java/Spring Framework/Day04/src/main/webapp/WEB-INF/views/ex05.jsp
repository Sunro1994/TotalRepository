<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>






<h3>MultipartFile을 포함하는 DTO형식의 업로드</h3>

<form method="POST" enctype="multipart/form-data">
	<p><input type="file" name="upload" accept="image/*">
	<p><input type="text" name="title" placeholder=""></p>
	<p><input type="submit"></p>
</form>
</body>
</html>