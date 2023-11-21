<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="youtube.YoutubeDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03.jsp</title>
<style>
	.thumbnail > img {
		width: 250px;
	}
</style>
</head>
<body>

<h1>ex03.jsp</h1>
<hr>

<h3>커넥션풀과 싱글톤이 적용된 dao를 이용하여 목록을 화면에 띄어보세요</h3>
<h3>select * from youtube order by idx</h3>

<c:set var="dao" value="${YoutubeDAO.getInstance() }" />
<%-- dao : ${dao }<br> --%>
<c:set var="list" value="${dao.selectList() }" />
<%-- list : ${list }<br> --%>

<div id="root">
	<c:forEach var="dto" items="${list }">
	<div class="item">
		<div class="title">${dto.title }</div>
		<div class="channel">${dto.channel }</div>
		<div class="viewCount">${dto.viewCount }</div>
		<div class="thumbnail">
			<img src="${dto.thumbnail }">
		</div>
	</div>
	</c:forEach>
</div>





















</body>
</html>