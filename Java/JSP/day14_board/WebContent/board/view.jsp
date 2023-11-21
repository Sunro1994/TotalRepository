<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />

	<h3>단일 글 조회</h3>
	<h3>${dto.idx} | ${dto.title }</h3>
	<h3>${dto.writer } | ${dto.wdate }</h3>
	<pre>${dto.content }</pre>
	
	<div class="sb">
		<div></div>
		<div>
			<a href="${cpath }/board/modify.jsp?idx=${dto.idx}"><button>수정</button></a>
			<button id="deleteBtn">삭제</button>
		</div>
	</div>
</div>

<script>
	const deleteBtn = document.getElementById('deleteBtn')
	deleteBtn.onclick = function() {
		const flag = confirm('정말 삭제하시겠습니까')
		if(flag) {
			location.href = '${cpath}/board/delete.jsp?idx=${dto.idx}'
		}
	}
</script>

</body>
</html>




