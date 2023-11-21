<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
                <a href="${cpath}/Member/findMember">회원찾기</a>
                <span>|</span>
                <!-- 수정 -->
                <button id="login_join_btn">회원가입</button>
                <!-- 수정 -->
            </div>

		<!--  KAKAO -->
            <div id="kakao">
            <a class="KaKaoLoginBtn" href="https://kauth.kakao.com/oauth/authorize?client_id=9810e4d47aa744b120cb9d4c343b295f&redirect_uri=http://localhost:8080/www/Member/KaKaoLogin&response_type=code">
            <img src="${cpath}/img/kakao_login_medium_wide.png">
            </a>
            </div>
            
       <!-- Naver -->
            <div id="naver">
            <a class="NaverLoginBtn" href="
            https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=90TeRuXWOlklHroO_ywb&redirect_uri=http://localhost:8080/www/Member/NaverLogin&state=123456
            ">
            <img src="https://vendor-cdn.imweb.me/images/naver_login2x.png">네이버 로그인
            </a>
            </div>

		<!--  Google -->
            <a id="google" class="googleLoginBtn"><img src="https://vendor-cdn.imweb.me/images/google_icon.png" >Google 로그인</a>

            <form method="dialog">
                <button class="closeLoginBtn login_CloseBtn">나가기</button>
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
    <dialog id="my_coupon">
        <div class="flex_center">
            <div class="mylocker_top">
                <img src="${cpath}/img/tm330.png"> 
                <div>
                    <h1>쿠폰함</h1>
                </div>
            </div>
            <div id="my_coupon_container">
            
            </div>
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
                <button class="my_coupon_close_btn" id="my_favorite_close_btn">나가기</button>
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
            <div class="my_reserved_container">
          
            </div>
            <form method="dialog">
                <button class="my_coupon_close_btn">나가기</button>
            </form>
        </div>
    </dialog>