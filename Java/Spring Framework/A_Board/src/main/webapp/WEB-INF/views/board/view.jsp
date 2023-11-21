<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../check.jsp" %>
<style>
	img{
		max-width: 400px;
	}
	
	.makeReply{
	width: fit-content;
	margin : 10px 0;
		border : 1px solid black;
		padding: 10px 40px;
	}
	.replyBox{
	width: 300px;
	padding : 10px 30px;
	height : 100px;
		border : 1px solid black;
	}
	table{
		border-collapse: collapse;
	}
	td,tr{
		border: 1px solid black;
	}
	td{
		background-color: rgba(255,255,255,0.4);
	}
	
</style>


<table>
	<tr>
		<td>${dto.title }</td>
	</tr>
	<tr>
		<td>${dto.writer }</td>
		</tr>
		<tr>
		<td>${dto.wdate }</td>
		</tr>
		<tr class="ImgTag">
		<td><img src="${cpath}/upload/${dto.storedFileName}"></td>
		</tr>
		<tr>
		<td>${dto.content }</td>
		</tr>
</table>
<c:if test="${dto.writer==login.userid}">
<p><a href="${cpath}/board/modify/${dto.board_idx}"><button>수정</button></a>
<a href="${cpath}/board/delete/${dto.board_idx}"><button>삭제</button></a></p>
</c:if>

	<c:forEach var="replyDTO" items="${replyList }"> 
	<div class="replyBox">
		<p>${replyDTO.writer }</p>
		<p>${replyDTO.content }</p>
	</div>

		</c:forEach>
	<h2>댓글 추가하기</h2>
	<div class="makeReply">
	<form method="POST">
	<h2>댓글 작성하기</h2>
	<p><input type="hidden" name="board_idx" value=${dto.board_idx } ></p>
	<p><input type="text" name="writer" placeholder="작성자" value=${login.userid }></p>
	<p><input type="number" name="reply_h_idx" value="${dto.board_idx}"></p>
	<p><textarea name="content"></textarea></p>
	<p><input type="submit"></p>
	</form>
	</div>
	

</body>
<script>
const test = '${dto.storedFileName}';
const ImgTag = document.querySelector('.ImgTag');
if(test=='') {
	ImgTag.style.display='none';
}
</script>
</html>