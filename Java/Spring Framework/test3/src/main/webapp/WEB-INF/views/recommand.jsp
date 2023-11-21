<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<style>
	#recommand-main{
	background-color : black;
		width: 350px;
		margin: auto;
	}
</style>

	<div id="recommand-main">
		<div class="list-menuBox">
		<div ><h1>오늘의 추천 메뉴!</h1></div>
		<div class="menu-title"><a href="${cpath}/view/${dto.idx}">${dto.menu_name }</a></div>
		<div class="menu-price">${dto.menu_price }</div>
		<div class="menu-info">${dto.menu_intro }</div>
</div>
	</div>
</body>
</html>