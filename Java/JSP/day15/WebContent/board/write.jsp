<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<c:if test="${empty login }">
	<c:redirect url="/member/login.jsp" />
</c:if>

<div class="container">
	<h3>게시글 쓰기</h3>
	<form method="POST" action="${cpath }/board/write-action.jsp">
		<div class="form-group">
			 <input class="form-control" type="hidden" name="writer" value="${login.userid }">
		</div>

		<div class="form-group">
			<input class="form-control" type="text" name="title" placeholder="제목을 입력하세요" autofocus required>
		</div>

		<div class="form-group">
			<textarea id="summernote" name="content"></textarea>
		</div>

		<button type="submit" class="btn btn-warning"> 글쓰기</button>
		<button class="btn btn-primary" type="button" onclick="javascript:history.go(-1)">돌아가기</button>
	</form>
</div>
<script>
	$(document).ready(function() {
		$('#summernote').summernote({
			tabsize: 2,
	        height: 300
		});
	});
</script>

</body>
</html>