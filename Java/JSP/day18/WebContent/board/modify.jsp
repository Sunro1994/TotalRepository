<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
	
	<c:if test="${empty login or login.userid != dto.writer }">
		<c:redirect url="/" />
	</c:if>

	<h3>게시글 수정</h3>
	<form action="${cpath }/board/modify-action.jsp" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="idx" value="${param.idx }" />
		<p><input type="text" name="title" placeholder="제목" value="${dto.title }" required autofocus></p>
		<p><input type="hidden" name="writer" value="${login.userid }" required></p>
		<p><textarea name="content" placeholder="내용을 작성하세요" required>${dto.content }</textarea></p>
		
		<c:if test="${not empty dto.uploadFile}">
		<p>
			기존 첨부 파일 : ${dto.uploadFile }
			<a href="${cpath }/board/deleteFile.jsp?idx=${dto.idx}">
				<input type="button" value="첨부파일 삭제"></a>		
		</p>
		</c:if>
		
		<p>
			<input type="file" name="uploadFile">
		</p>
		<p><input type="submit"></p>
	</form>
</div>

</body>
</html>






