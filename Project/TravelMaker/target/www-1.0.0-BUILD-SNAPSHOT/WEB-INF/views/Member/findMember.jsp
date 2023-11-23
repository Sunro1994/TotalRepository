<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- jqeury 불러오기-->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <!-- sweetalert2 불러오기-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>
    <link rel="stylesheet" href="${cpath }/css/main_css/join.css" type="text/css">
    <title>Document</title>
</head>
<style>
    body {
        background-color: #F8F8FF;
    }
    .container{
        width: 500px;
        margin: 0 auto;

    }
    .logo{
        text-align: center;
    }
    .logo > img{
        width: 300px;
        height: 300px;

    }
    .findEmail{
        text-align: center;
    }
    .fineMemberEmailForm{
        all:unset;
        width: 220px;
        height: 30px;
        padding-right: 40px;
    }
    .mailForm {
        display: flex;
        justify-content: center;
        border: 2px solid darkgray;
        width: 300px;
        height: 30px;
        margin: 0 auto;
        padding: 5px;
        border-radius: 10px;
    }
    .mailForm > img{
        width: 25px;
        height: 25px;
    }
    #nextBtn{
        margin-top: 10px;
        width: 315px;
        height: 40px;
        opacity: 0.3;
        border-radius: 10px;
        background-color: inherit;
    }
    #certification{
        border: 2px solid darkgrey;
        width: 310px;
        height: 35px;
        margin: 10px auto;
        border-radius: 10px;
        display: none;
    }
    .inputCertification{
        all:unset;
        width: 220px;
        height: 35px;
    }
    #confirmBtn{
        all:unset;
        width: 40px;
        height: 30px;
        background-color: #FF2052;
        border-radius: 5px;
        color: white;
    }
    #updatePwBtn{
        all:unset;
        background-color: #FF2052;
        margin: 10px auto;
        width: 315px;
        height: 40px;
        border-radius: 10px;
        color:white;
        display: none;
    }

    input[type="number"]::-webkit-outer-spin-button,
    input[type="number"]::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
</style>
<body>

<div class="container">
    <div class="logo">
        <img src="${cpath}/img/tm400.png">
    </div>
    <div class="findEmail">
        <h2><strong>비밀번호 재설정</strong></h2>
        <p>회원가입 시 등록한 이메일 주소를 입력해주세요</p>
        <form method="POST">
            <div class="mailForm">
                <img src="${cpath}/img/mail.png">
                <input type="email" id="email" class="fineMemberEmailForm" name="travelMaker_Member_Email" placeholder="이메일 주소" autocomplete="off">
            </div>
            <div id="certification">
                <input type="number" class="inputCertification"  placeholder="인증번호" autocomplete="off">
                <button id="confirmBtn">확인</button>
            </div>
            <input id="nextBtn" type="button" value="확인">
        </form>
        <a href="${cpath}/Member/findPw"><button type="button" id="updatePwBtn">비밀번호 재설정</button></a>

    </div>
</div>

<script>
    const nextBtn = document.getElementById('nextBtn')
    const emailForm = document.querySelector('.fineMemberEmailForm')
    const certification = document.getElementById('certification')
    const email = document.getElementById('email')
    const confirmBtn = document.getElementById('confirmBtn')
    const updatePwBtn = document.getElementById('updatePwBtn')

    emailForm.addEventListener('input', function() {
        // 만약 emailForm 의 값이 공백이 아니라면,
        if(emailForm.value.trim() !== '')(
            // nextBtn 의 스타일을 바꾼다
            nextBtn.style.opacity = 1,
                nextBtn.style.backgroundColor = '#FF2052',
                nextBtn.style.border = '#FF2052',
                nextBtn.style.color = 'white'
        )
        else {
            nextBtn.style.opacity = 0.3,
                nextBtn.style.backgroundColor = 'darkgrey',
                nextBtn.style.color='black'
        }
    })

    nextBtn.onclick = async () => {
        const checkExistEmail = document.querySelector('input[name="travelMaker_Member_Email"]')
        if(checkExistEmail.value == '') {
            swal('경고', '이메일을 정확히 입력해주세요', 'warning')
            checkExistEmail.focus()
            return
        }
        const url = '${cpath}/ajax/checkExistEmail?email=' + checkExistEmail.value
        // 지정한 주소로 요청 / 응답이 오면 text 로 result 에 저장

        const result = await fetch(url).then(resp => resp.text())
        if(result == 1){
            // result 1이면 존재하지 않는 이메일 이므로 알림창을 띄워주고 email input 창으로 focus 시킨다.
            swal('실패', '존재하지 않는 이메일 입니다', 'error')
            checkExistEmail.focus()
            return
        }
        else {
            // result 가 1이 아니면 0 이므로, 존재하는 이메일 이다.
            // 숨겨져 있던 인증번호 창을 display = block 으로 나타나게 하고
            certification.style.display = 'block'
            // 만들어 두었던 mailComponent 함수를 이용해서 email 전송
            const sendMail = '${cpath}/ajax/sendAuthNumber'
            const email = document.getElementById('email')
            fetch(sendMail + '?email=' + email.value)
                .then(resp => resp.text())
                .then(text => {
                    swal('성공', '인증번호가 발송 되었습니다', 'success')
                })
            }
        }
        const CertifyHandler = async (event) => {
            event.preventDefault()
            const authNumber = document.querySelector('input[class="inputCertification"]')

            if(authNumber.value == '') {
                swal('경고', '인증번호를 입력해주세요', 'warning')
                authNumber.focus()
                return
            }
            // memberAjaxController 에 전달
            const url = '${cpath}/ajax/checkAuthNumber/' + authNumber.value

            // 요청 결과는 1 or 0
            const authResult = await fetch(url).then(resp => resp.text())

            if(authResult == 0) {                              // 결과값이 0 이면
                swal('실패', '인증번호를 다시 확인해주세요', 'error')  // 알림창 (실패시) 를 띄워주고
                authNumber.value = ''                             // 인증번호 입력창으로 다시 focus시킨다
                return
            }
            else {
                swal('성공', ' 인증 성공', 'success')             // 인증의 결과값이 1이면,
                updatePwBtn.style.display='block'              // 숨겨져있던 비밀번호 재설정 버튼을 나타나게 한다.
            }
        }
        confirmBtn.addEventListener('click', CertifyHandler)




</script>
</body>
</html>