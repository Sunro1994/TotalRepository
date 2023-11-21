<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>




<div id="main">
<c:forEach items="${list }" var="dto">
<div class="list-menuBox">
	<div class="menu-title"><a href="${cpath}/view/${dto.idx}">${dto.menu_name }</a></div>
	<div class="menu-price">${dto.menu_price }</div>
	<div class="menu-info">${dto.menu_intro }</div>
	<div class="menu-get"><a href="${cpath}/intoBasket/${dto.idx}">메뉴 담기</a></div>
</div>
</c:forEach>

</div>






</body>
</html>