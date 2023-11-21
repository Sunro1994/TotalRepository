<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
	<table class="boardView">
		<tr>
			<td colspan="2">${dto.idx }. ${dto.title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<td>작성일시</td>
			<td>
				<fmt:formatDate value="${dto.wdate }" pattern="yyyy-MM-dd a hh:mm"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<pre>${dto.content }</pre>
			</td>
		</tr>
		<c:if test="${not empty dto.uploadFile }">
		<tr>
			<td colspan="2"><img src="${cpath }/upload/${dto.uploadFile}"></td>
		</tr>
		</c:if>
	</table>
	<div class="sb">
		<div>
			<a href="${cpath }/board/list.jsp"><button>목록</button></a>
		</div>
		<div>
			<a href="${cpath }/board/modify.jsp?idx=${dto.idx}"><button>수정</button></a>
			<button id="deleteBtn">삭제</button>
		</div>
	</div>
</div>

<script>
	const deleteBtn = document.getElementById('deleteBtn')
	const userid = '${login.userid}'
	const writer = '${dto.writer}'
	
	deleteBtn.onclick = function() {
		if(userid != writer) {
			alert('본인의 글만 삭제할 수 있습니다')
			return
		}
		
		const flag = confirm('정말 삭제하시겠습니까')
		if(flag) {
			location.href = '${cpath }/board/delete.jsp?idx=${dto.idx}'
		}
	}
</script>













</body>
</html>