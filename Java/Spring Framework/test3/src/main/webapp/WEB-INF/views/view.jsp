<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<style>
	#view-main{
		width : fit-content;
		margin : auto;
	}
	.modifyBtn,.deleteBtn{
		all:unset;
		width : 100%;
		margin-bottom: 10px;
		text-align: center;
	}
	
</style>

<div id="view-main">
	
<div class="list-menuBox">
	<div class="menu-title"><a href="${cpath}/view/${dto.idx}">${dto.menu_name }</a></div>
	<div class="menu-price">${dto.menu_price }</div>
	<div class="menu-info">${dto.menu_intro }</div>
	<div><a href="${cpath}/modify/${dto.idx}" ><button class="modifyBtn">수정</button></a></div>
	<div><button class="deleteBtn">삭제</button></div>
</div>
</div>

</body>

<script>
	const deleteBtn = document.querySelector('.deleteBtn');
	const myPwd = '${dto.menu_pwd}';
	
	console.log(deleteBtn);
	deleteBtnHandler = function() {
		const answer = prompt('비밀번호를 입력해주세요');
		if(answer==myPwd)
			location.href='${cpath}/delete/${dto.idx}';
	}
	
	deleteBtn.addEventListener('click',deleteBtnHandler)
	
	const deleteBtn = document.querySelector('.modifyBtn');
	
	modifyBtnHandler = function() {
		const answer = prompt('비밀번호를 입력해주세요');
		if(answer==myPwd)
			location.href='${cpath}/modify/${dto.idx}';
	}
	
	deleteBtn.addEventListener('click',modifyBtnHandler)
</script>
</html>