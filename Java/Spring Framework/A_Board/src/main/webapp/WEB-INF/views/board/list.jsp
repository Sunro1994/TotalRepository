<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<form method="post" > 
	<p><input type="text" name="title" placeholder="검색할 제목을 입력하세요"><input type="submit" value="검색"></p>
</form>

<table>
<c:forEach var="dto" items="${list }">
	<tr>
		<td><a href="${cpath}/board/view/${dto.board_idx}">${dto.title }</a></td>
		<td>${dto.writer }</td>
		<td>${dto.wdate }</td>
	</tr>
</c:forEach>
</table>
<p><a href="${cpath }/board/add"><button>추가하기</button></a></p>

</body>
</html>