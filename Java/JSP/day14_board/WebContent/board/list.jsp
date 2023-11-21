<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<c:set var="list" value="${boardDAO.selectList() }" />
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.idx }</td>
				<td>
					<a href="${cpath }/board/view.jsp?idx=${dto.idx}">${dto.title }</a>
				</td>
				<td>${dto.writer }</td>
				<td>${dto.wdate }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="sb">
		<div></div>
		<div>
			<a href="${cpath }/board/write.jsp"><button>새 글 작성</button></a>
		</div>
	</div>	
</div>

</body>
</html>









