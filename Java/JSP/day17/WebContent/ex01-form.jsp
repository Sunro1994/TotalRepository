<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01-form.jsp</title>
</head>
<body>

<h1>ex01-form.jsp</h1>
<hr>

<h3>파일을 프로젝트 외부 폴더에 업로드하기</h3>

<form method="POST" enctype="multipart/form-data" action="ex01-action.jsp">
	<p><input type="file" name="uploadFile"></p>
	<p><input type="submit"></p>
</form>

</body>
</html>