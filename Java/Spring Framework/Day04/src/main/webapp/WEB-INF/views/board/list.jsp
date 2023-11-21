<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>



<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>날짜</th>
		</tr>
	</thead>
<tbody>
<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.id }</td>
		<td><a href="${cpath}/board/view/${dto.id}">${dto.title}</a></td>
		<td>${dto.content}</td>
		<td>${dto.wdate}</td>
	</tr>	
</c:forEach>
</tbody>
</table>
<a href="${cpath}/board/add"><button>글 추가</button></a>
</body>
</html>