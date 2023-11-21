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
 <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
   <link rel="stylesheet" href="${cpath }/css/main_css/login.css" type="text/css">
   <link rel="stylesheet" href="${cpath }/css/main_css/myPage.css" type="text/css">
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
                <li><a href="${cpath}" class="navBtn">만남</a></li>
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
        		<div><span class="UserProfileImg"><img src="${user.travelMaker_Member_EncodingProfileImg}" ></span><a href="${cpath}/Member/myPage"> ${user.travelMaker_Member_UserNickName}</a></div>
        	</div>
        	<div><a href="${cpath}/Member/logout">로그아웃</a></div>
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
                    <li class="my_locker_dropDown_option">
                        <button class="my_locker_dropDown_btn" id="my_reserved_btn">예약 내역</button>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
        </c:if>
        </div>
        <dialog id="model">
        <div class="model">
            <img src="${cpath}/img/tm400.png" id="mark">
            <form id="login" method="POST" >
                <div>
                    <img class="idIcon" src="${cpath}/img/id.png">
                    <input type="text" name="travelMaker_Member_UserId" placeholder="아이디" autofocus required autocomplete="off">
                </div>
                <div>
                    <img class="pwIcon" src="${cpath}/img/pw.png">
                    <input type="password" name="travelMaker_Member_UserPw" placeholder="비밀번호" required>
                </div>
                <input class="loginBtn" type="submit" value="로그인">
            </form>
            <div id="member">
                <a>회원찾기</a>
                <span>|</span>
                <!-- 수정 -->
                <button id="login_join_btn">회원가입</button>
                <!-- 수정 -->
            </div>

            <div id="kakao">
            <a class="KaKaoLoginBtn" href="https://kauth.kakao.com/oauth/authorize?client_id=9810e4d47aa744b120cb9d4c343b295f&redirect_uri=http://localhost:8080/www/Member/KaKaoLogin&response_type=code">
            <img src="${cpath}/img/kakao_login_medium_wide.png">
            </a>
            </div>
            <div id="naver"><img src="https://vendor-cdn.imweb.me/images/naver_login2x.png">네이버 로그인</div>
            <div id="google"><img src="https://vendor-cdn.imweb.me/images/google_icon.png">Google 로그인</div>

            <form method="dialog">
                <!-- 수정 -->
                <button class="closeLoginBtn login_CloseBtn">나가기</button>
                <!-- 수정 -->
            </form>
        </div>
    </dialog>
    <!-- 수정 -->
    <dialog id="login_join_modal">
        <div class="flex_center">
            <img src="${cpath}/img/tm400.png" id="mark">
            <div id="API_login_btn_box">
                <button class="API_login_btn KaKaoJoinBtn" style="background: url(${cpath}/img/kakaoIcon.png); background-size: cover;"></button>
                <button class="API_login_btn NaverJoinBtn" style="background: url(${cpath}/img/naverIcon.png); background-size: cover;"></button>
                <button class="API_login_btn GoogleJoinBtn" style="background: url(${cpath}/img/googleIcon.png); background-size: cover;"></button>
            </div>
            <button class="header-joinBtn" style="margin-top: 10px;">일반가입</button>
            <form method="dialog">
                <button class="closeJoinBtn login_CloseBtn" style="margin-top: 50px;">나가기</button>
            </form>
        </div>
    </dialog>
    </div>
    <dialog id="my_coupon">
        <div class="flex_center">
            <div class="mylocker_top">
                <img src="${cpath}/img/tm330.png">
                <div>
                    <h1>쿠폰함</h1>
                </div>
            </div>
            <!-- c:forEach -->
            <div class="my_coupon_img_box">
                <div class="my_coupon_name">
                    쿠폰이름
                    <!-- ${coupon_name} -->
                </div>
                <img class="my_coupon_img" src="${cpath}/img/coupon.jpg">
              
            </div>
            <!-- c:forEach -->
            <!-- c:forEach -->
            <div class="my_coupon_img_box">
                <div class="my_coupon_name">
                    쿠폰 이름
                    <!-- ${coupon_name} -->
                </div>
                <img class="my_coupon_img" src="${cpath}/img/coupon.jpg">
             
            </div>
            <!-- c:forEach -->
            <form method="dialog">
                <button class="my_coupon_close_btn">나가기</button>
            </form>
    </div>
    </dialog>
    <dialog id="my_favorite">
        <div class="flex_center">
            <div class="mylocker_top">
                <img src="${cpath}/img/tm330.png">
                <div>
                    <h1>찜숙소</h1>
                </div>
            </div>
            <!-- c:forEach -->
            <div class="my_favorite_item_box">
            </div>
            <!-- c:forEach -->
            <form method="dialog">
                <button class="my_coupon_close_btn">나가기</button>
            </form>
        </div>
    </dialog>
    <dialog id="my_reserved">
        <div class="flex_center">
            <div class="mylocker_top">
                <img src="${cpath}/img/tm330.png">
                <div>
                    <h1>예약내역</h1>
                </div>
            </div>
            <!-- c:forEach -->
            <div class="my_reserved_item_box">
                <div class="my_reserved_item_top">
                    <img class="my_reserved_item_img" src="${cpath}/img/lodge.jfif">
                    <div>
                        <p class="my_reserved_item_lodge_name">숙소이름</p>
                        <!-- ${lodge_detail_name} -->
                        <span class="my_reserved_item_room_name">방이름</span>
                        <!-- ${lodge_room_type_name} -->
                    </div>
                </div>
                <div class="my_reserved_item_mid">
                    <div class="my_reserved_item_chek">
                        <div class="my_reserved_item_inout">
                            <span class="my_reserved_item_room_name">체크인</span>
                            <p class="reserved_lodge_cuurent_state_date">2023-10-28</p>
                            <!-- ${reserved_lodge_cuurent_state_date} -->
                        </div>
                        <div class="my_reserved_item_inout">
                            <span class="my_reserved_item_room_name">체크아웃</span>
                            <p class="reserved_lodge_cuurent_end_date">2023-10-29</p>
                            <!-- ${reserved_lodge_cuurent_end_date} -->
                        </div>
                    </div>
                </div>
                <div class="my_reserved_item_bottom">
                        <button class="my_reserved_cancel_btn">예약 취소</button>
                        <div class="my_reserved_unCancel_btn">예약 취소</div>
                        <button class="my_reserved_review_btn">리뷰 쓰기</button>
                        <div class="my_reserved_unReview_btn">리뷰 쓰기</div>
                </div>
            </div>
            <!-- c:forEach -->
            <form method="dialog">
                <button class="my_coupon_close_btn">나가기</button>
            </form>
        </div>
    </dialog>
<script>

    const headerLoginBtn = document.querySelector('.headerLoginBtn');
    const model = document.getElementById('model');
    // 수정
    const loginJoinBtn = document.getElementById('login_join_btn');
    const loginJoinModal = document.getElementById('login_join_modal');
    
    const header_joinBtn = document.querySelector('.header-joinBtn');
    
    // 로그인 확인하는 AJAX
    const loginBtn = document.querySelector('.loginBtn');
    const loginId = document.querySelector('input[name="travelMaker_Member_UserId"]');
    const loginPw = document.querySelector('input[name="travelMaker_Member_UserPw"]');
    
    // 로그인 버튼
    if(headerLoginBtn && loginJoinBtn && header_joinBtn) {
    headerLoginBtn.addEventListener("click", ()=> {
        model.showModal();
    });
    // 회원가입 버튼
    loginJoinBtn.addEventListener("click", ()=> {
        loginJoinModal.showModal();
    });
    
    // 회원가입 버튼
    header_joinBtn.addEventListener("click", ()=> {
        location.href = '${cpath}/Member/term';
    });
    
    /* 카카오 API 회원가입 연동 버튼 */
    const KaKaoJoinBtn = document.querySelector('.KaKaoJoinBtn');
    const GoogleJoinBtn = document.querySelector('.GoogleJoinBtn');
    
    KaKaoJoinBtn.addEventListener("click", () => {
    	location.href= 'https://kauth.kakao.com/oauth/logout?client_id=9810e4d47aa744b120cb9d4c343b295f&logout_redirect_uri=http://localhost:8080/www/Member/logoutKAKAO';
    		
    });
    GoogleJoinBtn.addEventListener("click", () => {
    	url = 'https://accounts.google.com/o/oauth2/auth?';
    	url += 'client_id=1051611122531-fpva2ogee41oq126prt05gnvfa2uc6it.apps.googleusercontent.com';
    	url += '&redirect_uri=http://localhost:8080/www/Member/GoogleLogin';
    	url += '&response_type=code';
    	url += '&scope=email profile';
        location.href = url;
      
    });
    
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
                    alert('로그인 되었습니다.');
                    location.reload();
                } else {
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
    
    myReservedBtn.addEventListener("click", () => {
        const nowDate = new Date();
        for (var i = 0; i < myReservedCancelBtn.length; i++) {
            const stateDate = new Date(reservedLodgeCuurentStateDate[i].innerHTML);
            const endDate = new Date(reservedLodgeCuurentEndDate[i].innerHTML);
            if (endDate > nowDate) {
                myReservedReviewBtn[i].style.display = "none";
                myReservedUnReviewBtn[i].style.display = "block";
            }
            if (nowDate > stateDate) {
                myReservedCancelBtn[i].style.display = "none";
                myReservedUnCancelBtn[i].style.display = "block";
            }
            endDate.setDate(endDate.getDate() + 14);
            console.log("endDate : " + endDate);
            if (nowDate > endDate) {
                myReservedReviewBtn[i].style.display = "none";
                myReservedUnReviewBtn[i].style.display = "block";
            }
        }
    });

    }
</script>