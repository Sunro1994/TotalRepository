<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<c:if test="${empty login }">
		<c:redirect url="/" />
	</c:if>

	<h3>새 글 작성</h3>
	<form action="${cpath }/board/write-action.jsp" method="POST" enctype="multipart/form-data">
		<p><input type="text" name="title" placeholder="제목" required autofocus></p>
		<p><input type="hidden" name="writer" value="${login.userid }" required></p>
		<p><textarea name="content" placeholder="내용을 작성하세요" required></textarea></p>
		<p><input type="file" name="uploadFile"></p>
		<p><input type="submit"></p>
	</form>
</div>

<script>
	const uploadFile = document.querySelector('input[name="uploadFile"]')
	
	uploadFile.onchange = function(event) {
		console.log(event.target.files)			// 첨부파일이 있는지 확인하는 첨부파일 리스트
		console.log(event.target.files[0])		// 첨부파일 중 첫번째 파일
		console.log(event.target.files[0].type)	// 첨부파일 중 첫번째 파일의 content-type
		const type = event.target.files[0].type.split('/')[0]
		console.log(type)
		
		if(type != 'image') {
			alert('이미지만 첨부해주세요')
			location.reload()
		}
	}
</script>

</body>
</html>










