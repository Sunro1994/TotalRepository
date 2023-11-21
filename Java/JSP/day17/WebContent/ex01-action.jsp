<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ex01.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01-action.jsp</title>
</head>
<body>
<c:if test="${pageContext.request.method != 'POST' }">
	<c:redirect url="/ex01-form.jsp" />
</c:if>

<c:set var="fileUtil" value="${FileUtil.getInstance() }" />
<c:set var="fileName" value="${fileUtil.getFileName(pageContext.request) }" />

<h3>fileName : ${fileName }</h3>
<div>
	<img src="${cpath }/upload/${fileName}">
</div>
<p>
	<a href="${cpath }/ex01-form.jsp"><button>다시</button></a>
</p>

</body>
</html>