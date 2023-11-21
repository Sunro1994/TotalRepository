<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>음원 목록</h3>
<hr>
<table>
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.id }</td>
			<td>${dto.isTitle }</td>
			<td>아티스트명 : ${dto.artist_name }</td>
			<td>앨범명: ${dto.album_name }</td>
			<td>${dto.name }</td>
			<td>${dto.genre }</td>
			<td>${dto.playTime }</td>
		<td>
			<c:if test="${fn:length(dto.lyrics)>10 }">
				${fn:substring(dto.lyrics,0,10) }...
			</c:if>
			<c:if test="${fn:length(dto.lyrics)>10 ==false}">
			${dto.lyrics }
			</c:if>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>