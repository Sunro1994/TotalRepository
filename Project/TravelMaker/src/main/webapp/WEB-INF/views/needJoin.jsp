<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>

   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
 <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
 
 <script src="https://apis.google.com/js/platform.js" async defer></script>
   <link rel="stylesheet" href="${cpath }/css/main_css/login.css" type="text/css">
   <link rel="stylesheet" href="${cpath }/css/main_css/allUsedHeader.css" type="text/css">

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>오류 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f8f8f8;
            background-image: url("http://localhost:8080/img/jingu.jpeg");
        }
        .error-container {
            margin: 100px auto;
            padding: 20px;
            border: 1px solid #e0e0e0;
            border-radius: 5px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #ff0000;
        }
    </style>
</head>
<body>
<dialog id="login_join_modal">
        <div class="flex_center">
            <img src="${cpath}/img/tm400.png" id="mark">
            <div id="API_login_btn_box">
                <button class="API_login_btn KaKaoJoinBtn" style="background: url(${cpath}/img/kakaoIcon.png); background-size: cover;"></button>
                <button class="API_login_btn NaverJoinBtn" style="background: url(${cpath}/img/naverIcon.png); background-size: cover;"></button>
                <button class="API_login_btn GoogleJoinBtn" style="background: url(${cpath}/img/googleIcon.png); background-size: cover;"></button>
            </div>
            <button class="header-joinBtn" style="margin-top: 10px;">일반가입</button>
            <div >
                <a href="${cpath}"><button class="closeJoinBtn login_CloseBtn" style="margin-top: 50px;">홈으로</button></a>
            </div>
        </div>
    </dialog>

<script>


	const header_joinBtn = document.querySelector('.header-joinBtn');
	
	 // 회원가입 모달 버튼
    header_joinBtn.addEventListener("click", ()=> {
        location.href = '${cpath}/Member/term';
    });
	
	
	
	
  alert('회원가입이 필요합니다.')
  const loginJoinModal = document.getElementById('login_join_modal');
  loginJoinModal.showModal();
  
  /* 카카오 API 회원가입 연동 버튼 */
  const KaKaoJoinBtn = document.querySelector('.KaKaoJoinBtn');
  const GoogleJoinBtn = document.querySelector('.GoogleJoinBtn');
  const googleLoginBtn = document.querySelector('.googleLoginBtn')
  if(KaKaoJoinBtn){
  	KaKaoJoinBtn.addEventListener("click", () => {
      	location.href= 'https://kauth.kakao.com/oauth/authorize?client_id=9810e4d47aa744b120cb9d4c343b295f&redirect_uri=http://localhost:8080/www/Member/KaKaoJoin&response_type=code';
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
   </script>
   
</body>
</html>
