<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set  var="cpath" value="${pageContext.request.contextPath }"/>
    <%@ include file="../allUsedHeader.jsp" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${cpath }/css/main_css/login.css" type="text/css">
<body>
	
    <button id="btn">로그인</button>
    <dialog id="model">
        <div class="model">
            <img src="${cpath}/img/tm400.png" id="mark">
            <form id="login" method="POST">
                <div>
                    <img class="idIcon" src="${cpath}/img/id.png">
                    <input type="text" name="TRAVELMAKER_MEMBER_USERID" placeholder="아이디" autofocus required>
                </div>
                <div>
                    <img class="pwIcon" src="${cpath}/img/pw.png">
                    <input type="password" name="TRAVELMAKER_MEMBER_USERPW" placeholder="비밀번호" required>
                </div>
                <input class="loginBtn login&CloseBtn" type="submit" value="로그인">
            </form>
            <div id="member">
                <a>회원찾기</a>
                <span>|</span>
                <!-- 수정 -->
                <button id="login_join_btn">회원가입</button>
                <!-- 수정 -->
            </div>
            <div id="kakao"><img src="${cpath}/img/kakao_login_medium_wide.png"></div>
            <div id="naver"><img src="https://vendor-cdn.imweb.me/images/naver_login2x.png">네이버 로그인</div>
            <div id="google"><img src="https://vendor-cdn.imweb.me/images/google_icon.png">Google 로그인</div>

            <form method="dialog">
                <!-- 수정 -->
                <button class="closeBtn login&CloseBtn">나가기</button>
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
            <button class="loginBtn login&CloseBtn" style="margin-top: 10px;">일반가입</button>
            <form method="dialog">
                <button class="loginBtn login&CloseBtn" style="margin-top: 50px;">나가기</button>
            </form>
        </div>
    </dialog>
    <!-- 수정 -->
    <script>
		/* 로그인 , 회원가입 모달 버튼 */
        const btn = document.getElementById('btn')
        const model = document.getElementById('model')
        //수정
        const loginJoinBtn = document.getElementById('login_join_btn')
        const loginJoinModal = document.getElementById('login_join_modal')
        //수정

        btn.addEventListener("click", () => {
            model.showModal()
        })
        //수정
        loginJoinBtn.addEventListener("click", () => {
            loginJoinModal.showModal()
        })
        
        /* 카카오 API 회원가입 연동 버튼 */
 		const KaKaoJoinBtn = document.getElementById('.KaKaoJoinBtn')
 		console.log(KaKaoJoinBtn)
        
        
        
        
    </script>
    
</body>
</html>