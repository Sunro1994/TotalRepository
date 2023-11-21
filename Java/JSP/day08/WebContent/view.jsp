<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<main>
	<h3>영상 보기 : ${param.idx }</h3>
	<jsp:useBean id="dao" class="youtube.YoutubeDAO" />
	<c:set var="dto" value="${dao.selectOne(param.idx) }" />
	<div>${dto.movieTag }</div>
	<div>${dto.title }</div>
	<div>${dto.channel } | ${dto.viewCount }</div>
</main>
</body>
</html>