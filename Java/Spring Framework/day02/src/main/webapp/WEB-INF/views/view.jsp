<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<div id="main">
	<div>${dto.movieTag}</div>
	<div>
		<h3>${dto.title }</h3>
		<h3>${dto.channel}| 조회 수 : ${dto.viewCount }</h3>
	</div>
	
	<p align="right">
		<button id="deleteBtn"> 삭제</button>
	</p>
	</body>
	
	
	<script>
		const deleteBtn = document.getElementById('deleteBtn');

		function deleteHandler() {
			const idx = '${dto.idx}';
			const flag = confirm('정말 삭제할거니?');
			if(idx != '' && flag) {
				location.href='${cpath}/delete/'+idx;
			}
		}
		deleteBtn.addEventListener('click',deleteHandler);
	</script>
	</html>