<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ex02.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-form.jsp</title>
<style>
	.wrap {
		width: 900px;
		margin: auto;
		display: flex;
		flex-flow: wrap;
	}
	.item {
		width: 200px;
		margin: 10px;
	}
</style>
</head>
<body>

<h1>ex02-form.jsp</h1>
<hr>
<h3>문자열 포함 파일 전송</h3>

<form method="POST" action="ex02-action.jsp" enctype="multipart/form-data">
	<p><input type="text" name="title" placeholder="타이틀"></p>
	<p><input type="file" name="profileImage" accept="application/zip"></p>
	<p><input type="submit"></p>
</form>

<div class="wrap">
	<c:set var="fileUtil" value="${FileUtil.getInstance() }" />
	<c:set var="fileNameList" value="${fileUtil.getFileNameList() }" />
	
	<c:forEach var="fileName" items="${fileNameList }">
	<div class="item">
		<img src="upload/${fileName }" width="200">
	</div>
	</c:forEach>
</div>









</body>
</html>









