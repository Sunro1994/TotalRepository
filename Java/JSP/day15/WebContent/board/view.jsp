<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

 <c:if test="${empty login }">
 	<c:redirect url="../member/login.jsp"></c:redirect>
 </c:if>

<div class="container">
	<c:set var="dto" value="${boardDAO.selectOne(param.idx) }"/>
	
	<h1>단일 글 조회</h1>
  
  <div>
		<div class="sb">
			<div></div>
			<div>
				<a href="${cpath }/board/list.jsp"><button class="btn btn-secondary">목록으로</button></a>
			<c:if test="${login.userid eq dto.writer}">
				<a href="${cpath}/board/modify.jsp?idx=${dto.idx }"><button class="btn btn-warning">수정</button></a>
				<button id="deleteBtn" class="btn btn-danger" >삭제</button>
			</c:if>
			</div>
		</div>
		<br /></br>
		<div class="d-flex justify-content-between">
			<span>글번호 : ${dto.idx}</span> <span>작성자 : ${dto.writer}</span>
		</div>
		<hr />
		<div>
			<h3>${dto.title}</h3>
		</div>
		<hr />
		<div>
			<div>${dto.content}</div>
		</div>
	</div>
</div>

<script>
	const deleteBtn = document.getElementById('deleteBtn');
	deleteBtn.onclick = function() {
		const flag = confirm('정말 삭제하시겠습니까??');
		if(flag) {
			location.href = '${cpath}/board/delete.jsp?idx=${dto.idx}';
		}
	}
</script>
	
	

</body>
</html>