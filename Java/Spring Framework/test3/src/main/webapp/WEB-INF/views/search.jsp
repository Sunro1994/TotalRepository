<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<style>
	form{
		margin:auto;
	}
	input{
		width: 800px;
		background-color: rgba(255,255,255,0.2);
		padding : 20px 50px;
		color : white;
		font-size: 2em;
	}
	input::placeholder{
		text-align: center;
		color : white;
	}
	
</style>

	<div id="main">
	
	<form method="POST">
		<div><input type="text" name="findFood" placeholder="원하시는 음식을 검색해보세요" style="text-align: center"><button>검색</button></div>
	</form>

	</div>
	<c:if test="${list!=null }">
	<div id="main">
		<c:forEach items="${list }" var="dto">
			<div class="list-menuBox">
			<div class="menu-title"><a href="${cpath}/view/${dto.idx}">${dto.menu_name }</a></div>
			<div class="menu-price">${dto.menu_price }</div>
			<div class="menu-info">${dto.menu_intro }</div>
	</div>
</c:forEach>

</div>
	
	</c:if>




	
</body>
</html>