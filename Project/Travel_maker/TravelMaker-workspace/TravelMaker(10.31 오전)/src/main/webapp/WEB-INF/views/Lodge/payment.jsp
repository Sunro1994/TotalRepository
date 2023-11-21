<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp" %>
<style>
.paymentContainer{
	margin-top : 100px;
}
</style>
<div class="paymentContainer">
<div>결제자 : ${user.travelMaker_Member_UserNickName }</div>
<div>객실명 : ${roomDTO.lodge_Room_Type_Name }</div>
<!-- <div>인원 : < </div> 나중에 만들 기능 현페이지에서만 단순 사용, 최소 최대 인원 내에서만 적용될수있게 -->
<div>쿠폰 적용 : ${user.travelMaker_Member_Coupon }<span><button class="discountBtn">적용하기</button></span></div>
<div>결제 가격 : ${roomDTO.lodge_Room_Type_price }
<c:if test="${user.travelMaker_Member_Coupon>0}">
(할인적용가 :<span class="discountResult">${roomDTO.lodge_Room_Type_price }</span>)
</c:if>
</div>
<!-- payment누르면 결제하도록하기 할인적용가는 그냥 예시로 보여주기 -->
<div><button class="payment">결제하기</button></div>
</div>

<script>
	const price = ${roomDTO.lodge_Room_Type_price }
	const discountBtn = document.querySelector('.discountBtn');
	const discountResult = document.querySelector('.discountResult');
	let resultPrice = price;
	const disCountHandler = function() {
		resultPrice = price-50000;
		discountResult.innerText = '';
		discountResult.innerText = resultPrice;
	}
	discountBtn.addEventListener('click',disCountHandler);
</script>
</body>
</html>