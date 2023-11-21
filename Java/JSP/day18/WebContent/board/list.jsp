<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<table class="boardList">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="list" value="${boardDAO.selectList() }" />
			<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.idx }</td>
				<td>
					<a href="${cpath }/board/view.jsp?idx=${dto.idx}">
						${dto.title }</a>
					${not empty dto.uploadFile ? '💾': '' }
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
			<button id="writeBtn">새 글 작성</button>
		</div>
	</div>
</div>

<script>
	const writeBtn = document.getElementById('writeBtn')
	writeBtn.onclick = function() {
		const login = '${login}'
		if(login == '') {
			alert('로그인한 사용자만 글을 작성할 수 있습니다')
		}
		else {
			location.href = '${cpath }/board/write.jsp'
		}
	}
</script>

</body>
</html>











