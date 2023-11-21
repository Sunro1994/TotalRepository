<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<main>
<h3>목록</h3>

<div id="root">
	<jsp:useBean id="dao" class="youtube.YoutubeDAO" />
	<c:set var="list" value="${dao.selectList() }" />
	
	<div class="wrap">
	<c:forEach var="dto" items="${list }">
		<div class="item">
			<div class="thumbnail">
				<a href="${cpath }/view.jsp?idx=${dto.idx}"><img src="${dto.thumbnail }"></a>
			</div>
			<div class="title">
				<a href="${cpath }/view.jsp?idx=${dto.idx}">${dto.title }</a>
			</div>
			<div class="channel">${dto.channel }</div>
			<div class="viewCount">
				조회수 : ${MyUtil.convertViewCount(dto.viewCount) }
			</div>
		</div>
	</c:forEach>
	</div>
</div>

</main>




</body>
</html>