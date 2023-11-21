<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<%@ include file="../allUsedHeader.jsp" %>


<style>
	body {
		padding: 0;
		margin: 0 auto;
		background-color: white;
	}
	body::-webkit-scrollbar {
    	width: 10px;
  	}
  	body::-webkit-scrollbar-thumb {
	    background-color: #2f3542;
	    border-radius: 10px;
	    background-clip: padding-box;
	    border: 2px solid transparent;
  	}
  	body::-webkit-scrollbar-track {
	    background-color: grey;
	    border-radius: 10px;
	    box-shadow: inset 0px 0px 5px white;
  	}

	video {
		position : fixed;
		top : 0; 
		left : 0;
		min-width : 100%;
		min-height : 100%;
		width : auto;
		height : auto;
	}
	source {
		width: 100%;
		height: 100%;
	    top: 0;
    	left: 0;
	}
	.coupon {
		height: 625px;
		width: 440px;
		margin: 0 auto;
		margin-bottom: 60px;
		overflow:hidden;
		
	}
	img {
		width:100%;
	    height:100%;
	    object-fit:cover;
	    position: relative;
	    
	}
	#head{
	margin-top: 190px;
	}
	#but1 {
		 position: absolute;
		 transform: translate(15%,1463%);
		 width: 120px;
		 height: 40px;
		 line-height: 50px;
		 font-size: 15px;
		 text-align: center;
		 font-family: sans-serif;
		 text-decoration: none;
		 text-transform: uppercase;
		 letter-spacing: 2px;
		 background: #ccc;
		 line-height:36px;
	}
	#but1:before{
	  content: attr(data-text);
	  position: absolute;
	  top: 0;
	  left: 0;
	  width: 100%;
	  height: 100%;
	  text-align: center;
	  font-weight: bold;
	  background: #ffcd0e;
	  color: black;
	  transition: 0.5s;
	  transform-origin: bottom;
	  transform: translatey(-100%) rotatex(90deg);
	}
	#but1:hover:before
	{
	  transform: translatey(0) rotatex(0deg);
	}
	
	#but1:after{
	  content: attr(data-text);
	  position: absolute;
	  top: 0;
	  left: 0;
	  width: 100%;
	  height: 100%;
	  text-align: center;
	  font-weight: bold;
	  background: #343434;
	  color: #ffec51;
	  transition: 0.5s;
	  transform-origin: top;
	  transform: translatey(0) rotatex(0deg);
	}
	#but1:hover:after
	{
	  transform: translatey(100%) rotatex(90deg);
	}

	
</style>


<div id="head">
	<div id="main">
		<div id="video1">
			<video muted autoplay loop>
				<source src="${cpath }/img/promotion1.mp4" type="video/mp4">
			</video>
		<div class="coupon">
			<img src="${cpath }/img/promotion_img1.png">
			<button id="but1" data-text="Down!" value="1">${hasCoupon}</button>
		</div>
		
<!-- 		<div class="coupon"> -->
<%-- 			<img src="${cpath }/img/promotion_img2.png"> --%>
<!-- 			<button id="but2" data-text="Down!" value="2"></button> -->
<!-- 		</div> -->
		</div>
		
	</div>
</div>

<script>
	const button1 = document.getElementById('but1')

	const buttonHandler = async function(event) {
  	const url = `${cpath}/promotion/insertCoupon`; // 백틱(`)을 사용하여 문자열을 생성해야 합니다.
  	const flag = '${user}' != ''
  		if (flag) {
  		  const response = await fetch(url, {
  		    method: 'POST',
  		    body: JSON.stringify(event.target.value), // 데이터를 JSON 문자열로 변환
  		    headers: {
  		      'Content-Type': 'application/json' // 데이터 유형 설정
  		    }
  		  })
  		    .then(resp => {
  		      return resp.json();
  		    })
  		    .then(data => {
  		      
  		      if (data === 0) {
  		        swal('쿠폰 재발급 불가','해당 쿠폰은 이미 발급되었습니다','error');
  		        return;
  		      }else{
  		    	  swal('쿠폰 발급 완료','쿠폰이 발급되었습니다\n 마이페이지 > 쿠폰함','success');
  		      }
  		    });
	 }
	 
};
	button1.addEventListener('click', buttonHandler)
	
</script>


</body>
</html>