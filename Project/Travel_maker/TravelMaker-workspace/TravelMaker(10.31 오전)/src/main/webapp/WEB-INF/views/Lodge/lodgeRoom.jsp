<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../allUsedHeader.jsp" %>
    <style>
    .RoomListContainer{
    	margin-top : 100px;
    }
    </style>
	<div class="RoomListContainer">
	<c:forEach var="dto" items="${RoomList }">
	<div>
		
		<div><img src="${dto.lodge_Room_Type_Img}"></div>
		<div> 가격 : ${dto.lodge_Room_Type_price}</div>
		<div>호실명 : ${dto.lodge_Room_Type_Name}</div>
		<div>남은 호실 개수 : ${dto.lodge_Room_Type_Count}</div>
		<div><button class="payment" value="${dto.lodge_Room_Type_Idx }">결제</button></div>
	</div>
	</c:forEach>
	</div>
	
	
	<script>
		const payBtn = document.querySelector('.payment');
		console.log(payBtn)
		
		
		
		
		payBtn.addEventListener('click',() => {
			location.href='${cpath}/lodge/Payment/'+payBtn.value
		});
	</script>

</body>
</html>