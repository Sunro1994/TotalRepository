<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<!-- bootsStrap, Jquery 가져오는 CDN -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>
 <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
 <script src="https://apis.google.com/js/platform.js" async defer></script>
   <link rel="stylesheet" href="${cpath }/css/main_css/login.css" type="text/css">
   <link rel="stylesheet" href="${cpath }/css/main_css/myPage.css" type="text/css">
     <link rel="stylesheet" href="${cpath }/css/main_css/meeting_main.css" type="text/css">
   <link rel="stylesheet" href="${cpath }/css/main_css/allUsedHeader.css" type="text/css">

<!--  각 페이지 css -->
    <title>TravelMaker</title>
</head>
<body>
        <div id="header-top">
        <div id="left">
            <a href="${cpath}">
                <img src="${cpath}/img/TravelMakerlogo.png">
            </a>
        </div>
        <div id="center">
            <ul>
                <li><a href="${cpath}" class="navBtn">홈</a></li>
                <li><a href="${cpath}/lodge/lodge_main" class="navBtn">숙소</a></li>
                <li><a href="${cpath}/Meeting/meeting_main" class="navBtn">만남</a></li>
                <li><a href="${cpath}/recommend_travel/recommend_travel_main" class="navBtn">여행지추천</a></li>
            </ul>
        </div>
        <div id="right">
        <c:if test="${user==null }">
            <a class="headerLoginBtn">
                <img src="https://korean.visitkorea.or.kr/resources/images/common/icon_header_profile1.png">
            </a>
        </c:if>
        <c:if test="${user!=null}">
        	<div class="LoginUser">
        		<div>
	        		<span class="UserProfileImg">
	        			<c:if test="${not empty user.travelMaker_Member_EncodingProfileImg}">
	        			<img src="${cpath}/travelImg/${user.travelMaker_Member_EncodingProfileImg}" >
	        			</c:if>
	        			<c:if test="${empty user.travelMaker_Member_EncodingProfileImg }">
	        			<img src="${cpath}/img/tm330.png">
	        			</c:if>
	        		</span>
	        			<a href="${cpath}/Member/myPage" class="userName"> ${user.travelMaker_Member_UserNickName}</a>
        		</div>
        	</div>
        	<div><a  class="logoutBtn">로그아웃</a></div>
        	<div id="my_locker">
        <ul>
            <li>
                <div id="my_locker_img_box">
                    <img id="my_locker_img" src="${cpath }/img/locker.png">
                </div>
                <ul id="my_locker_dropDown">
                    <li class="my_locker_dropDown_option">
                        <button class="my_locker_dropDown_btn" id="my_coupon_btn">쿠폰함</button>
                    </li>
                    <li class="my_locker_dropDown_option">
                        <button class="my_locker_dropDown_btn" id="my_favorite_btn">찜숙소</button>
                    </li>
                    <li class="my_locker_dropDown_option ReservationDetail">
                        <button class="my_locker_dropDown_btn ReservationDetail" id="my_reserved_btn">예약 내역</button>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
        </c:if>
        </div>
        
        <%@ include file="headerDialog.jsp" %>
        </div>
<script>

	/*
		로그인 유저 이름 길이 최대 8글자
	*/


    const headerLoginBtn = document.querySelector('.headerLoginBtn');
    const model = document.getElementById('model');
    // 수정
    const loginJoinBtn = document.getElementById('login_join_btn');
    const loginJoinModal = document.getElementById('login_join_modal');
    
    const header_joinBtn = document.querySelector('.header-joinBtn');
    const logoutBtn = document.querySelector('.logoutBtn');
    
    // 로그인 확인하는 AJAX
    const loginBtn = document.querySelector('.loginBtn');
    const loginId = document.querySelector('input[name="travelMaker_Member_UserId"]');
    const loginPw = document.querySelector('input[name="travelMaker_Member_UserPw"]');
    
    // 로그인 모달 버튼
    if(headerLoginBtn && loginJoinBtn && header_joinBtn) {
    headerLoginBtn.addEventListener("click", ()=> {
        model.showModal();
    });
    // 회원가입  모달 버튼
    loginJoinBtn.addEventListener("click", ()=> {
        loginJoinModal.showModal();
    });
    
    // 회원가입 모달 버튼
    header_joinBtn.addEventListener("click", ()=> {
        location.href = '${cpath}/Member/term';
    });
    }
    /* 카카오 API 회원가입 연동 버튼 */
    const KaKaoJoinBtn = document.querySelector('.KaKaoJoinBtn');
    
    
    if(KaKaoJoinBtn){
    	KaKaoJoinBtn.addEventListener("click", () => {
            url=''
        	location.href= 'https://kauth.kakao.com/oauth/authorize?client_id=9810e4d47aa744b120cb9d4c343b295f&redirect_uri=http://localhost:8080/www/Member/KaKaoJoin&response_type=code';
        });
    }
    
    /* 카카오 로그아웃*/
    if(logoutBtn){
    logoutBtn.addEventListener("click", (event) => {
    	
    	location.href= '${cpath}/Member/logout';
    });
    }
    
    const GoogleJoinBtn = document.querySelector('.GoogleJoinBtn');
    const googleLoginBtn = document.querySelector('.googleLoginBtn');
    if(GoogleJoinBtn){
    /* 구글 회원가입시 요청 */
    GoogleJoinBtn.addEventListener("click", () => {
    	url = 'https://accounts.google.com/o/oauth2/auth?';
    	url += 'client_id=1051611122531-fpva2ogee41oq126prt05gnvfa2uc6it.apps.googleusercontent.com';
    	url += '&redirect_uri=http://localhost:8080/www/Member/GoogleJoin';
    	url += '&response_type=code';
    	url += '&scope=email profile';
        location.href = url;
    });
    }
    if(googleLoginBtn){
    	
    /* 구글 로그인시 요청 */
    googleLoginBtn.addEventListener("click", () => {
    	url = 'https://accounts.google.com/o/oauth2/auth?';
    	url += 'client_id=1051611122531-fpva2ogee41oq126prt05gnvfa2uc6it.apps.googleusercontent.com';
    	url += '&redirect_uri=http://localhost:8080/www/Member/GoogleLogin';
    	url += '&response_type=code';
    	url += '&scope=email profile';
        location.href = url;
    });
    }
    
    
    const naverJoinBtn =document.querySelector('.NaverJoinBtn');
    
    /*naver 회원가입 요청*/
    if(naverJoinBtn){
    	naverJoinBtn.addEventListener("click",()=>{
    		url = 'https://nid.naver.com/oauth2.0/authorize?response_type=code';
    		url+= '&client_id=90TeRuXWOlklHroO_ywb';
    		url+= '&redirect_uri=http://localhost:8080/www/Member/NaverJoin';
    		url+= '&state=123456';
    		
    		location.href=url;
    	})
    }
    
    
    if(loginBtn){
    	
    loginBtn.addEventListener("click", async (event) => {
        event.preventDefault();
        const userid = loginId.value;
        const userpw = loginPw.value;
    
        $.ajax({
            type: "POST",
            url: "${cpath}/ajax/checkLogin",
            data: JSON.stringify({
                travelMaker_Member_UserId: userid,
                travelMaker_Member_UserPw: userpw
            }),
            contentType: 'application/json',
            success: function(resp) {
            	
                if (resp == '성공') {
                    location.reload();
                } else if(resp =='실패') {
                    alert('일치하지 않는 정보입니다. 다시 시도해주세요.');
                }
            },
            error: function() {
                alert('일치하지 않는 정보입니다. 다시 시도해주세요.');
                
            }
        });
    });
    }
   
    
    // 쿠폰 유효기간 체크
    const myLockerImgBox = document.querySelector("#my_locker_img_box");
    const myLockerDropDown = document.getElementById("my_locker_dropDown");
    const myLockerImg = document.getElementById("my_locker_img");
    const myCouponBtn = document.getElementById("my_coupon_btn");
    const myCoupon = document.getElementById("my_coupon");
    const myFavorite = document.getElementById("my_favorite");
    const myFavoriteBtn = document.getElementById("my_favorite_btn");
    const myReserved = document.getElementById("my_reserved");
    const myReservedBtn = document.getElementById("my_reserved_btn");
    const myReservedCancelBtn = document.querySelectorAll(".my_reserved_cancel_btn");
    const myReservedUnCancelBtn = document.querySelectorAll(".my_reserved_unCancel_btn");
    const myReservedReviewBtn = document.querySelectorAll(".my_reserved_review_btn");
    const myReservedUnReviewBtn = document.querySelectorAll(".my_reserved_unReview_btn");
    const reservedLodgeCuurentStateDate = document.querySelectorAll(".reserved_lodge_cuurent_state_date");
    const reservedLodgeCuurentEndDate = document.querySelectorAll(".reserved_lodge_cuurent_end_date");
    
    //로그인 이전에 읽을 수 없는 요소를 거르는 제어문
    if(myLockerImgBox&&myCouponBtn&&myFavoriteBtn&&myReservedBtn&&myReservedBtn){
    myLockerImgBox.addEventListener("click", ()=> {
        if (myLockerDropDown.style.display == "block") {
            myLockerDropDown.style.display = "none";
            myLockerImg.src = "${cpath}/img/locker.png";
            myLockerImg.style.width = "35px";
            myLockerImg.style.height = "35px";
        } else {
            myLockerDropDown.style.display = "block";
            myLockerImg.src = "${cpath}/img/openLoker.png";
            myLockerImg.style.width = "40px";
            myLockerImg.style.height = "40px";
        };
    });
    
    myCouponBtn.addEventListener("click", () => {
        myCoupon.showModal();
    });
    
    myFavoriteBtn.addEventListener("click", () => {
        myFavorite.showModal();
    });
    
    myReservedBtn.addEventListener("click", () => {
        myReserved.showModal();
    });
    
   
   } 
    
  
  const ReservationDetail = document.querySelector('.ReservationDetail');
  if(ReservationDetail) {
	  
    /* 예약 내역 불러오기 */
    const LoadDetailHandler = function() {
    const userid = `${user.travelMaker_Member_UserId}`
    if (userid) {
        $.ajax({
            method: 'POST',
            url: "${cpath}/ajax/getReservedList",
            data: { userid: userid },
            contentType: 'application/json',
            success: function (resp) {
            	const my_reserved_container = document.querySelector('.my_reserved_container');
            	my_reserved_container.innerHTML = '';
            	resp.forEach(e => {
            		console.log(e)
                    const itemBox = document.createElement("div");
                    itemBox.classList.add("my_reserved_item_box");

                    const itemTop = document.createElement("div");
                    itemTop.classList.add("my_reserved_item_top");

                    const itemImg = document.createElement("img");
                    itemImg.classList.add("my_reserved_item_img");
                    itemImg.src = e.lodge_realimgname;

                    const itemName = document.createElement("p");
                    itemName.classList.add("my_reserved_item_lodge_name");
                    itemName.textContent = e.lodge_name;

                    const roomName = document.createElement("span");
                    roomName.classList.add("my_reserved_item_room_name");
                    roomName.textContent = e.lodge_Room_Type_Name;

                    const itemMid = document.createElement("div");
                    itemMid.classList.add("my_reserved_item_mid");

                    const checkIn = document.createElement("div");
                    checkIn.classList.add("my_reserved_item_chek");


                    // 시작날짜 및 종료날짜 시간으로 변환
                    const Startdate = new Date(e.reserved_Lodge_Current_State_StartDate);
					// date 객체를 사용하여 원하는 형식으로 날짜를 표시할 수 있음
					const year = Startdate.getFullYear();
					const month = Startdate.getMonth() + 1; // 월은 0부터 시작하므로 1을 더함
					const day = Startdate.getDate();
					const hours = Startdate.getHours();
					const minutes = Startdate.getMinutes();
					const seconds = Startdate.getSeconds();
					
					const endDate = new Date(e.reserved_Lodge_Current_State_EndDate)
					
					const year1 = endDate.getFullYear();
					const month1 = endDate.getMonth() + 1; // 월은 0부터 시작하므로 1을 더함
					const day1 = endDate.getDate();
					const hours1 = endDate.getHours();
					const minutes1 = endDate.getMinutes();
					const seconds1 = endDate.getSeconds();
					
                    const checkInDate = document.createElement("span");
                    checkInDate.classList.add("my_reserved_item_room_name");
                    checkInDate.textContent = "체크인 : \t";
					
					
					// 날짜를 원하는 형식으로 출력
					const start = year+'-'+month+'-'+day;
					const end = year1+'-'+month1+'-'+day1;
					
					
                    const checkInValue = document.createElement("p");
                    checkInValue.classList.add("reserved_lodge_cuurent_state_date");
                    checkInValue.textContent = start

                    const checkOut = document.createElement("div");
                    checkOut.classList.add("my_reserved_item_chek");

                    const checkOutDate = document.createElement("span");
                    checkOutDate.classList.add("my_reserved_item_room_name");
                    checkOutDate.textContent = "체크아웃 : \t";

                    const checkOutValue = document.createElement("p");
                    checkOutValue.classList.add("reserved_lodge_cuurent_end_date");
                    checkOutValue.textContent = end
                    
                    const itemBottom = document.createElement("div");
                    itemBottom.classList.add("my_reserved_item_bottom");

                    const cancelBtn = document.createElement("button");
                    cancelBtn.classList.add("my_reserved_cancel_btn");
                    cancelBtn.classList.add("testt");
                    cancelBtn.textContent = "예약 취소";

                    const unCancelBtn = document.createElement("div");
                    unCancelBtn.classList.add("my_reserved_unCancel_btn");
                    unCancelBtn.textContent = "예약 취소";

                    const reviewBtn = document.createElement("button");
                    reviewBtn.classList.add("my_reserved_review_btn");
                    const reviewLink = document.createElement("a");
                    reviewLink.href = '${cpath}/lodge/review/'+e.lodge_idx+'/'+e.lodge_Room_Type_Idx;
                    reviewLink.textContent = "리뷰 쓰기";	
                    reviewBtn.appendChild(reviewLink);

                    const unReviewBtn = document.createElement("div");
                    unReviewBtn.classList.add("my_reserved_unReview_btn");
                    unReviewBtn.textContent = "리뷰 쓰기";

                    // Append the created elements to their respective parents
                    itemTop.appendChild(itemImg);
                    itemTop.appendChild(itemName);
                    itemTop.appendChild(roomName);

                    checkIn.appendChild(checkInDate);
                    checkIn.appendChild(checkInValue);

                    checkOut.appendChild(checkOutDate);
                    checkOut.appendChild(checkOutValue);

                    itemMid.appendChild(checkIn);
                    itemMid.appendChild(checkOut);

                    itemBottom.appendChild(cancelBtn);
                    itemBottom.appendChild(unCancelBtn);
                    itemBottom.appendChild(reviewBtn);
                    itemBottom.appendChild(unReviewBtn);
                    
                    itemBox.appendChild(itemTop);
                    itemBox.appendChild(itemMid);
                    
                    
                    itemBox.appendChild(itemBottom);
                    
                    my_reserved_container.appendChild(itemBox);
                    
                	const nowDate = new Date();
                    const cssStateDate = new Date(start);
                    const cssEndDate = new Date(end);
                    if (cssEndDate > nowDate) {
                    	reviewBtn.style.display = "none";
                    	unReviewBtn.style.display = "block";
                    }
                    if (nowDate > cssStateDate) {
                    	cancelBtn.style.display = "none";
                    	unCancelBtn.style.display = "block";
                    }
                    cssEndDate.setDate(cssEndDate.getDate() + 14);

                    if (nowDate > cssEndDate) {
                    	reviewBtn.style.display = "none";
                    	unReviewBtn.style.display = "block";
                    }    
                    if (e.isReview == 'Y') {
                        reviewBtn.style.display = "none";
                        unReviewBtn.style.display = "block";
                    }

    const my_reserved_cancel_btn = document.querySelectorAll('.my_reserved_cancel_btn');
    
    my_reserved_cancel_btn.forEach(event=>{
    	
    	event.addEventListener('click',()=>{
        	location.href='${cpath}/Member/cancleReservation/'+e.reserved_Lodge_current_state_idx;
    	})
    })
    
    
    
                });
            }
        });
    }
}
  ReservationDetail.addEventListener('click', LoadDetailHandler);
  }
  
  if(myCouponBtn) {
	  const myCouponHandler = function() {
		  const userid = '${user.travelMaker_Member_UserId}';
		  const userCoupon = '${hasCoupon}';
		  if(userid) {
			  if(userCoupon == 1) {
				$.ajax({
		        	method: 'POST',
		            url: "${cpath}/ajax/getCouponList",
		            data: { userCoupon: userCoupon },
		            contentType: 'application/json',
		            success: function (resp) {
		            	const myCouponContainer = document.getElementById('my_coupon_container');
		            	resp.forEach(e => {
		            	myCouponContainer.innerHTML = "";
	                    const myCouponImgBox = document.createElement("div");
	                    myCouponImgBox.classList.add("my_coupon_img_box");
	                    const myCouponName = document.createElement("div");
	                    myCouponName.classList.add("my_coupon_name");
	                    myCouponName.textContent = e.coupon_name;
	                    const myCouponImg = document.createElement("img");
	                    myCouponImg.classList.add("my_coupon_img");
	                    myCouponImg.src = "${cpath}/img/myConpon.png";
	                    
	                    myCouponImgBox.appendChild(myCouponName);
	                    myCouponImgBox.appendChild(myCouponImg);
	                    myCouponContainer.appendChild(myCouponImgBox);
		            	});
		            }
		        })			  
			  }
		  }
	  };
	  myCouponBtn.addEventListener('click', myCouponHandler);
	}
  
  const SaveHandler = function (event) {
      // 여기에 찜 버튼을 클릭했을 때의 동작을 추가하세요.
      $.ajax({
          url: '${cpath}/lodge/selectSaveList',
          method: 'GET',
          success: function (resp) {
                	
              	const my_favorite_item_box = document.querySelector('.my_favorite_item_box')
                	my_favorite_item_box.innerHTML = ''
                	
              resp.forEach(e=>{
                	const div = document.createElement('div')
                	div.className = 'my_favorite_items'
                	
              	const div_img = document.createElement('div')
              	const img = document.createElement('img')
              	div_img.className = 'my_favorite_img'
              	img.src = e.lodge_realimgname
              	div_img.appendChild(img)
              	div.appendChild(div_img)
              	
              	const div_title = document.createElement('div')
              	const title_href = document.createElement('a')
              	div_title.className = 'my_favorite_title'
              	div_title.appendChild(title_href)
              	title_href.href = '${cpath}/lodge/LodgeRoom/' + e.lodge_idx
              	title_href.innerText = e.lodge_name
              	div.appendChild(div_title)
              	
              	const div_delete = document.createElement('div')
              	const favoriteDelete = document.createElement('button')
              	div_delete.className = 'my_favorite_delete'
              	favoriteDelete.innerText = 'X'
              	favoriteDelete.value = e.lodge_idx
              	favoriteDelete.className = 'favoriteDeleteBtn'
              	div_delete.appendChild(favoriteDelete)
              	div.appendChild(div_delete)
					
                	my_favorite_item_box.appendChild(div)
                	
                	const favoriteDeleteBtn = document.querySelectorAll('.favoriteDeleteBtn')
                	favoriteDeleteBtn.forEach(e => {
                		e.onclick = function(event) {
                			let flag = confirm('정말 삭제 하시겠습니까')
                			if(flag) {
	                  			location.href = '${cpath}/lodge/deleteFavorite/' + event.target.value
                			}
                		}
                		
                	})
              })
              // 이 부분에서 적절한 처리를 수행하도록 수정하세요.
          }
      });
  	
  };
  if(myFavoriteBtn){
	  
  myFavoriteBtn.addEventListener('click',SaveHandler)
  }
  
 
 
  
  
  	
 </script> 