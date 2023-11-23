<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <!--Jquery불러오기 -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <!-- sweetalert2 불러오기-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>
    <link rel="stylesheet" href="${cpath }/css/main_css/join.css" type="text/css">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        margin-bottom: 15%;
    }
    .logo > img{
        width: 300px;
        height: 300px;
    }
    .updatePw{
        margin: 0 auto;
        text-align: center;
    }
    .idForm{
        display: flex;
        justify-content: center;
        border: 2px solid darkgray;
        width: 300px;
        height: 30px;
        margin: 20px auto;
        padding: 5px;
        border-radius: 10px;

    }
    .idInputForm{
        all:unset;
        width: 220px;
        height: 30px;
        padding-right: 20px;
    }
    .pwInputForm{
        all:unset;
        width: 220px;
        height: 30px;
        padding-right: 20px;
    }
    .pwForm {
        display: flex;
        justify-content: center;
        border: 2px solid darkgray;
        width: 300px;
        height: 30px;
        margin: 20px auto;
        padding: 5px;
        border-radius: 10px;
    }

    .pwConfirmForm{
        display: flex;
        justify-content: center;
        border: 2px solid darkgray;
        width: 300px;
        height: 30px;
        margin: 20px auto;
        padding: 5px;
        border-radius: 10px;

    }
    .confirmPw{

        all:unset;
        width: 220px;
        height: 30px;
        padding-right: 20px;
    }

    .confirmBtn{
        background-color: #FF2052;
        color: black;
        margin-top: 10px;
        width: 315px;
        height: 40px;
        border-radius: 10px;
        background-color: inherit;
    }


</style>
<body>
<div class="container">
    <div class="logo">
        <img src="${cpath}/img/tm400.png">
    </div>

    <div class="updatePw">
        <h2><strong>비밀번호 재설정</strong></h2>

        <form method="POST" id="confirmBtn">
            <div class="idForm">
                <input type="text" class="idInputForm" placeholder="ID를 입력해주세요" name="travelMaker_Member_UserId" autocomplete="off" required>
            </div>
            <div class="pwForm">
                <input type="password" class="pwInputForm" name="travelMaker_Member_UserPw" placeholder="새로운 비밀번호를 입력해주세요" autocomplete="off" required>
            </div>
            <div class="pwConfirmForm">
                <input type="password" class="confirmPw" placeholder="비밀번호를 확인해주세요" autocomplete="off" required>
            </div>
            <input class="confirmBtn" type="submit" value="확인">
        </form>
    </div>
</div>

<script>
    const idForm = document.querySelector('input[name="travelMaker_Member_UserId"]')
    const confirm = document.getElementById('confirmBtn')
    const pwForm = document.querySelector('.pwInputForm')
    const pwConfirmForm = document.querySelector('.confirmPw')

    confirm.onsubmit = async (event) => {
        event.preventDefault()
        if(idForm.value == ''){
            swal('경고', 'ID를 정확하게 입력해주세요', 'warning')
            idForm.focus()
            return
        }
        console.log(pwConfirmForm.value)
        console.log(pwForm.value)
        if(pwForm.value !== pwConfirmForm.value){
            swal('경고', '비밀번호가 일치하지 않습니다.', 'warning')
            pwConfirmForm.focus()
            return
        }
        const idCheckUrl = '${cpath}/ajax/checkDuplicationId?travelMaker_Member_UserId=' + idForm.value

        const result =  await fetch(idCheckUrl).then(resp => resp.text())
        console.log(result)
        if(result == 0){    // result == 0 이면 userId가 있는거 (null이 아님)
            swal('성공', '비밀번호 변경 완료', 'success')
            setTimeout(() => {
                confirmBtn.submit();
            }, 2000); // 2초 이후 submit 실행
        }
        else {
            swal('실패','비밀번호 변경 실패','error')
            pwForm.value = '';
            pwForm.focus()
            return
        }
    }


</script>

</body>
</html>