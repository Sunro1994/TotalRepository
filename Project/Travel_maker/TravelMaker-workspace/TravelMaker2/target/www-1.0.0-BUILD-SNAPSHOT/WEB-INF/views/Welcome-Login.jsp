<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${cpath}/css/main_css/recommend_travel_view.css" type="text/css">
    <link rel="stylesheet" href="${cpath }/css/main_css/lodge.css" type="text/css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
 <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
 <link rel="stylesheet" href="${cpath }/css/main_css/login.css" type="text/css">
   <link rel="stylesheet" href="${cpath }/css/main_css/myPage.css" type="text/css">
   <link rel="stylesheet" href="${cpath }/css/main_css/allUsedHeader.css" type="text/css">
   <link rel="stylesheet" href="${cpath }/css/main_css/lodge_main.css" type="text/css">
<body>
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
                <a href="${cpath}/Member/findMember">회원찾기</a>
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
            <a id="google" class="googleLoginBtn"><img src="https://vendor-cdn.imweb.me/images/google_icon.png" >Google 로그인</a>

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
    
</body>
<script>
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
    model.showModal();
// 회원가입  모달 버튼
loginJoinBtn.addEventListener("click", ()=> {
    loginJoinModal.showModal();
});

// 회원가입 모달 버튼
header_joinBtn.addEventListener("click", ()=> {
    location.href = '${cpath}/Member/term';
});
/* 카카오 API 회원가입 연동 버튼 */
const KaKaoJoinBtn = document.querySelector('.KaKaoJoinBtn');
const GoogleJoinBtn = document.querySelector('.GoogleJoinBtn');
const googleLoginBtn = document.querySelector('.googleLoginBtn')
if(KaKaoJoinBtn){
	KaKaoJoinBtn.addEventListener("click", () => {
    	location.href= 'https://kauth.kakao.com/oauth/authorize?client_id=9810e4d47aa744b120cb9d4c343b295f&redirect_uri=http://localhost:8080/www/Member/KaKaoJoin&response_type=code';
    });
}

/* 카카오 로그아웃*/
	console.log(logoutBtn)
if(logoutBtn){
logoutBtn.addEventListener("click", (event) => {
	
	location.href= '${cpath}/Member/logout';
});
}
if(KaKaoJoinBtn){
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
            	console.log('로그인 성공');
                location.href="${cpath}"
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


</script>
</html>