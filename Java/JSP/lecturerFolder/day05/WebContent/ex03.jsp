<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ex03.jsp</title>
</head>
<body>

<h1>ex03.jsp</h1>
<hr>

<details>
	<summary>ex01.jsp</summary>
	<fieldset>
		<legend>ex01.jsp</legend>
		<jsp:include page="ex01.jsp" />
	</fieldset>
</details>

<details>
	<summary>ex02.jsp</summary>
	<fieldset>
		<legend>ex02.jsp</legend>
		<jsp:include page="ex02.jsp" />
	</fieldset>
</details>

</body>
</html>