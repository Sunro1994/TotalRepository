<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<details>
	<summary>ex01.jsp</summary>
	<fieldset>
		<legend>ex01.jsp</legend>
		<jsp:include page="jsp-action.jsp"/>
	</fieldset>
	</details>
	
	<details>
		<summary>ex02.jsp</summary>
		<fieldset>
			<legend>ex02.jsp</legend>
			<jsp:include page="ex02.jsp"></jsp:include>
		</fieldset>
	</details>


</body>
</html>