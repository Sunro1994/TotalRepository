<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>날짜</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
<tbody>
	<tr>
		<td>${dto.id }</td>
		<td><a href="${cpath}/board/view/${dto.id}">${dto.title}</a></td>
		<td>${dto.content}</td>
		<td>${dto.wdate}</td>
		<td><a href="${cpath}/board/modify/${dto.id}">수정</a></td>
		<td><a><button class="deleteBtn">삭제</button></a></td>
	</tr>	
</tbody>
</table>
<script>
	const deleteBtn = document.querySelector('.deleteBtn')
	console.log(deleteBtn);
	const pwd = ${dto.pwd}
	deleteHandler = function(){
	console.log('클릭');
	const flag = prompt('비밀번호 입력');
	if(flag == pwd){
		alert('글이 삭제됩니다.')
		location.href='${cpath}/board/delete/${dto.id}';
		}
	else{
		alert('비밀번호가 일치하지 않습니다.')
	}
	}
	
	deleteBtn.addEventListener('click',deleteHandler)
</script>
</body>
</html>