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
    <link rel="stylesheet" href="${cpath}/css/main_css/recommend_travel_view.css" type="text/css">
    <link rel="stylesheet" href="${cpath }/css/main_css/lodge.css" type="text/css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
 <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />

<!--  각 페이지 css -->
    <title>TravelMaker</title>
</head>
<style>
	body > #header-top {
			top: 0;
            border: 1px solid #dedede;
	        height: 85px;
	        width: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 3px 16px -5px #99C;
            position: fixed;
    		background-color: white;
    		z-index: 9999;
           
        }
        body > #header-top > #left{
            width: 140px;
            height: 140px;
			margin-left: 50px;
            
        }
        body > #header-top > #left > a > img {
            width:100%;
            height:100%;
        }
        body > #header-top > #center {
            display: flex;
            width: 80%;
        }
        body > #header-top > #center {
            width: 800px;
        }
        body > #header-top > #center > ul {
            width: 100%;
            margin: auto;
            display: flex;
            padding-left: 0;
            justify-content: space-evenly;
        }
        body > #header-top > #center > ul > li {
            list-style: none;
            font-size: x-large;
            font-weight: bold;
        }
        body > #header-top > #right {
            height: 35px;
            width: 35px;
            margin-right: 50px;
        }
        body > #header-top > #right > a > img {
            width:85%;
            height:85%;
        }
        a {
        	text-decoration: none;
        	color: inherit;
        	cursor: pointer;
        }
        .LoginUser{
        	border:  1px solid black;
        	width: 200px;
        }
        
        </style>
   <link rel="stylesheet" href="${cpath }/css/main_css/login.css" type="text/css">
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
            <a class="header-loginBtn">
                <img src="https://korean.visitkorea.or.kr/resources/images/common/icon_header_profile1.png">
            </a>
        </c:if>
        <c:if test="${user!=null}">
        	<div class="LoginUser">
        		${user}
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
            <div id="kakao"><img src="${cpath}/img/kakao_login_medium_wide.png"></div>
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
                <button class="API_login_btn" style="background: url(${cpath}/img/kakaoIcon.png); background-size: cover;"></button>
                <button class="API_login_btn" style="background: url(${cpath}/img/naverIcon.png); background-size: cover;"></button>
                <button class="API_login_btn" style="background: url(${cpath}/img/googleIcon.png); background-size: cover;"></button>
            </div>
            <button class="header-joinBtn" style="margin-top: 10px;">일반가입</button>
            <form method="dialog">
                <button class="closeJoinBtn login_CloseBtn" style="margin-top: 50px;">나가기</button>
            </form>
        </div>
    </dialog>
    </div>
<script>
const header_loginBtn = document.querySelector('.header-loginBtn')
const model = document.getElementById('model')
//수정
const loginJoinBtn = document.getElementById('login_join_btn')
const loginJoinModal = document.getElementById('login_join_modal')

const header_joinBtn = document.querySelector('.header-joinBtn');

//로그인 확인하는 AJAX
const loginBtn = document.querySelector('.loginBtn');
const loginId = document.querySelector('input[name="travelMaker_Member_UserId"]')
const loginPw = document.querySelector('input[name="travelMaker_Member_UserPw"]')




loginBtn.addEventListener("click",async (event)=>{
	event.preventDefault();
	const userid = loginId.value
	const userpw = loginPw.value
	
	$.ajax({
		type:"POST",
		url :"${cpath}/ajax/checkLogin",
		data : JSON.stringify({
			travelMaker_Member_UserId:userid, 
			travelMaker_Member_UserPw:userpw
			}),
		contentType: 'application/json',
		success : function(resp){
			if(resp=='성공'){
			swal('성공','로그인 되었습니다.','success')				
			location.reload();
			}else{
				alert('일치하지 않는 정보입니다. 다시 시도해주세요.')
				
			}
		},
		error : function(){
			alert('일치하지 않는 정보입니다. 다시 시도해주세요.')
		}
		
	
	})
	
	
	
	
})
//수정

header_loginBtn.addEventListener("click", () => {
    model.showModal()
})
//수정
loginJoinBtn.addEventListener("click", () => {
    loginJoinModal.showModal()
})

//회원가입 버튼
header_joinBtn.addEventListener("click",() =>{
	console.log('클릭')
	location.href = '${cpath}/Member/join'
})
</script>