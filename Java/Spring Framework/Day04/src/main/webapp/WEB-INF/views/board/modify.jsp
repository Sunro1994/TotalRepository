<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<form method="POST" >
	<p><input type="hidden" name="id" value="${dto.id}"></p>
	<p><input type="text" name="title" placeholder="글 제목" value="${dto.title }"></p>
	<p><textarea name="content" placeholder="내용" >${dto.content}</textarea></p>
	<p><input type="submit"></p>
</form>
</body>

<script>
const pwd = ${dto.pwd}
window.onload = function(){
console.log('클릭');
const flag = prompt('비밀번호 입력');
if(flag == pwd){
	alert('글을 수정할 수 있습니다.');
	
	}
else{
	alert('비밀번호가 일치하지 않습니다. 다시 시도해주세요');
	history.go(-1);
}
}


</script>

</html>