<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	<div class="wrap">
	<c:forEach var="dto" items="${list }">
	<div class="item">
	<div class="thumbnail" style="background-image: url('${dto.thumbnail}')">
	<a href="${cpath}/view/${dto.idx}"></a></div>
		<div>
			<h4>		<!-- fn은 el태그와 함께 사용한다. length, substring, replace -->
			<c:if test="${fn:length(dto.title) >10 }">
				${fn:substring(dto.title,0,30)}...
			</c:if>
			<c:if test="${fn:length(dto.title)<=10 }">
				${dto.title }
			</c:if>
			 ${dto.channel }</h4>
		</div>
	</div>
	</c:forEach>
	</div>
</div>
</body>




</html>