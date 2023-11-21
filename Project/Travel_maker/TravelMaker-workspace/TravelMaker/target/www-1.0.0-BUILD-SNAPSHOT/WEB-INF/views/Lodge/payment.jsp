<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" href="${cpath }/css/main_css/payment.css">
<!-- jqeury 불러오기-->
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<!-- sweetalert2 불러오기-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>
<c:if test="${empty user }">
	<c:redirect  url="/Member/Welcome-Login" />
</c:if>
 <div class="flex_center">
        <div id="paymentTop" class="flex_center">
            <div><img src="${cpath }/img/tm330.png"></div>
            <h2>숙소 결제</h2>
        </div>
        <div id="paymentMid">
            <span>결제자</span>
            <div class="paymentMid_item">${user.travelMaker_Member_UserNickName }</div>
            <span>객실명</span>
            <div class="paymentMid_item">${roomDTO.lodge_Room_Type_Name }</div>
            <span>날짜</span>
            <div class="paymentMid_item">${start } ~ ${end }</div>
            <div class="priceDiv">
                <span>결제 가격</span>
                <div id="roomPrice" class="paymentMid_item">${roomDTO.lodge_Room_Type_price }</div>
            </div>
            <c:if test="${user.travelMaker_Member_Coupon>0}">
            <div class="discountDiv">
                <span>할인 적용가</span>
                <div class="paymentMid_item discountResult"></div>
            </div>
            </c:if>
            <div><button class="paymentBtn couponBtn">쿠폰 적용</button></div>
            <div style="display: none;">${user.travelMaker_Member_Coupon }</div>
        </div>
        <div id="paymentBot">
            <div><button id="tossPayBtn"></button></div>
            <div><button id="kakaoPayBtn"></button></div>
        </div>
    </div>


<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script>
  	let price = ${roomDTO.lodge_Room_Type_price };
  	let roomPrice = document.getElementById("roomPrice");
  	let priceItem = document.getElementById("price_item");
  	const roomName = `${roomDTO.lodge_Room_Type_Name }`;
  	const roomIdx = ${roomDTO.lodge_Room_Type_Idx };
  	let coupon = ${user.travelMaker_Member_Coupon };
  	const couponBtn = document.querySelector('.couponBtn');
  	const discountResult = document.querySelector('.discountResult');
      const discountDiv = document.querySelector(".discountDiv");
      const priceDiv = document.querySelector(".priceDiv");
      const startDate = new Date('${start }');
      const endDate = new Date('${end }');
      price = ((endDate - startDate)/86400000) * price;
      roomPrice.innerText = price;
     let useCoupon = ${useCoupon};
    
  	const disCountHandler = function() {
  		if(useCoupon ==0 && coupon >0){
      		price = price-50000;
  		discountResult.innerText = price;
          priceDiv.style.display = 'none';
          discountDiv.style.display = 'block';
          coupon = -1;
          swal('쿠폰 적용완료','쿠폰이 적용되었습니다.','success')
          useCoupon = 1;
  		}
      	else if(coupon==-1){
      		swal('쿠폰 적용완료','이미 해당 쿠폰을 적용했습니다.','error')
      	}
      	else if(useCoupon!=0){
      		swal('쿠폰 사용횟수 초과','쿠폰을 이미 사용하셨습니다.','error')
      		
      	}else{
      		swal('쿠폰 미소지','소지하고 계신 쿠폰이 없습니다. 쿠폰을 먼저 발급받아주세요.','error')
      	}
  	}
  	couponBtn.addEventListener('click',disCountHandler);
	
//   	 결제
      IMP.init("imp42044727")
    
      const kakaoPayBtn = document.getElementById("kakaoPayBtn");
      const tossPayBtn = document.getElementById("tossPayBtn");
      const price2 = ${roomDTO.lodge_Room_Type_price };
  	const kakaoPay = async function kakaoPay() {
  	    
  	    	IMP.request_pay({
  		    	pg: "kakaopay",
  		    	pay_method: "card",
  			    amount: price,
  	 	    	name: roomName,
  		    	merchant_uid: "TM-" + new Date().getTime(),
  		        popup: true,
  		    	m_redirect_url: "${cpath}/lodge/reservationCheck/${roomDTO.lodge_Room_Type_Idx}/${start}/${end}/"+useCoupon,
  	    	}, function(rsp) {
  			      if(rsp.success){
  			    	  location.href='${cpath}/lodge/reservationCheck/${roomDTO.lodge_Room_Type_Idx}/${start}/${end}/'+useCoupon;
  			      } else {
                        swal('실패', rsp.error_msg, 'error')
  			      }
  	           })
      	 
      };
  	const tossPay = async function kakaoPay() {
  	    	IMP.request_pay({
  		    	pg: "tosspay",
  		    	pay_method: "card",
  			    amount: price,
  	 	    	name: roomName,
  		    	merchant_uid: "TM-" + new Date().getTime(),
  		        popup: true,
  		    	m_redirect_url: "${cpath}/lodge/reservationCheck/${roomDTO.lodge_Room_Type_Idx}/${start}/${end}/"+useCoupon,
  	    	}, function(rsp) {
  			      if(rsp.success){
  			    	  location.href='${cpath}/lodge/reservationCheck/${roomDTO.lodge_Room_Type_Idx}/${start}/${end}/'+useCoupon;
  			      } else {
  			          // alert(rsp.error_msg);
                      swal('실패', rsp.error_msg, 'error')
  			      };
  	           })
  	}
  	kakaoPayBtn.addEventListener("click", kakaoPay);
  	tossPayBtn.addEventListener("click", tossPay);
	
</script>
</body>
</html>