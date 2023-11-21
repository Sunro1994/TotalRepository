<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="list" value="${dao.selectList() }" />

<table border="1" cellpadding="10" cellspacing="0">
<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.idx }</td>
		<td>${dto.name }</td>
		<td>${dto.pnum }</td>
		<td>
			<a href="${cpath }/delete.jsp?idx=${dto.idx}">
				<button>삭제</button>
			</a>
		</td>
	</tr> 
</c:forEach>
</table>

</body>
</html>