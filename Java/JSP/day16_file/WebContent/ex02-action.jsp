<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ex02.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-action.jsp</title>
</head>
<body>

<c:set var="fileUtil" value="${FileUtil.getInstance() }" />
<c:set var="dto" value="${fileUtil.getDTO(pageContext.request) }" />

<h3>타이틀 : ${dto.title }</h3>
<h3>파일경로 : ${dto.filePath }</h3>
<div>
	<img src="${dto.filePath }" width="200">
</div>

<a href="ex02-form.jsp"><button>돌아가기</button></a>

</body>
</html>