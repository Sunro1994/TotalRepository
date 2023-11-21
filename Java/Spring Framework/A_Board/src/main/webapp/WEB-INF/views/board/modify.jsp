<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../check.jsp" %>

<style>
	img{
		max-width: 300px;
	}
	.deleteBtn{
		border: 1px solid black;
		border-radius: 20px;
		background-color: #aaa;
		color : white;
		padding : 5px 10px;
		font-weight: bold;
	}
	.deleteBtn:hover {
		opacity: 0.7;
	}
</style>
	<form method="POST" enctype="multipart/form-data">
		<p><input type="text" name="title" value="${dto.title }"></p>
		<p><textarea name="content">${dto.content }</textarea></p>
		<p class="FilePtag"><img class="FilePtag" src="${cpath}/upload/${dto.storedFileName}">
			<span class="deleteBtn">기존 파일삭제하기</span>
		</p>
		<p class="getImgBtn"><input type="file" name="contentImg" value="${dto.originalFileName }"></p>
		<p><input type="submit"></p>
	</form>

</body>

<script>
	const fileImgExist = document.querySelector('.img');
	const getImgBtn = document.querySelector('.getImgBtn');
	const FilePtag = document.querySelector('.FilePtag');
	const deleteBtn = document.querySelector('.deleteBtn');
	const test = '${dto.storedFileName}';
	const ext = test.substring(32);
	console.log(test=='')
	if(test=='') {
		FilePtag.style.display='none';
	}
	deleteBtn.onclick = function(){
		const flag = confirm('정말 삭제하시겠습니까?');
		if(flag&& test!=''){			
		location.href= '${cpath}/board/deleteImg/${dto.storedFileName}/${dto.board_idx}';
		}
		else{
			alert('현재 저장된 사진이 없습니다. 먼저 첨부해주세요')
		}
	}
</script>
</html>