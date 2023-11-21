<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!-- jqeury 불러오기-->
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- sweetalert2 불러오기-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>
    <link rel="stylesheet" href="${cpath }/css/main_css/join.css" type="text/css">
    <title>Document</title>
    <style>
        /* Hide Calendar Icon In Chrome */
        input[type="date"]::-webkit-inner-spin-button,
        input[type="date"]::-webkit-calendar-picker-indicator {
            display: none;
            -webkit-appearance: none;
        }
    </style>
</head>
<body>

<div class="main ">
    <div><img src="${cpath}/img/tm400.png"></div>
    <h2>회원가입</h2>

    <form id="form" method="POST" enctype="multipart/form-data" action="${cpath}/Member/join">
        <div class="join_items IdForm">
            <span>아이디</span>
            <div>
                <input class="join_input " type="text" name="travelMaker_Member_UserId" placeholder=" 아이디를 입력해주세요."  value="${user.travelMaker_Member_UserId}"
                autofocus required>
                <input id="idCheck" class="btn" type="button" value="확인">
            </div>
        </div>

        <div class="join_items PwForm">
            <span>비밀번호</span>
            <div class="join_item">
                <input id="userpw" class="unset" type="password" name="travelMaker_Member_UserPw" placeholder=" 비밀번호를 입력해주세요."   value="${user.travelMaker_Member_UserPw}"
                
                required>
            </div>
            
        </div>
        <div class="join_items">
            <span>이름</span>
            <div class="join_item">
                <input class="unset" type="text" name="travelMaker_Member_UserName" placeholder=" 이름을 입력해주세요." required>
            </div>
        </div>
        <div class="join_items">
            <span>이메일</span>
            <div>
                <input class="join_input"  id="email" type="email" name="travelMaker_Member_Email" placeholder=" 이메일을 입력해주세요."  required>
                <input id="emailCheck" class="btn" type="button" value="확인">
            </div>
        </div>
        <div  id="certification" class="join_items" style="display: none;">
            <span>인증번호</span>
            <div>
                <input class="join_input"  type="text" name="certification" placeholder=" 인증번호를 입력해주세요."  required>
                <input id="certificationCheck" class="btn" type="button" value="확인">
            </div>
        </div>

        <div class="join_items">
            <span>전화번호</span>
            <div class="join_item">
                <input class="unset" type="text" name="travelMaker_Member_Pnum" placeholder=" 전화번호를 숫자만 입력해주세요."
                       pattern="[0-9]{11}" title="11자리 숫자만 입력해 주세요." required>
            </div>
        </div>
        <div  class="join_items" style="display: flex;">
            <div>
                <span>성별</span>
                <div>
                    <select class="gender_left" form="form" name="travelMaker_Member_Gender" value="${dto.travelMaker_Member_Gender}">
                        <option value="남성">남성</option>
                        <option value="여성">여성</option>
                    </select>
                </div>
            </div>
            <div>
                <span>생년월일</span>
                <div class="birth_right">
                    <input type="text" name="travelMaker_Member_Birth" placeholder=" 8자리 숫자만 입력해주세요." 
                           pattern="[0-9]{8}" title="8자리 숫자만 입력해주세요." required>
                </div>
            </div>
        </div>
        <div class="join_items">
            <span>닉네임</span>
            <div>
                <input class="join_input" type="text" name="travelMaker_Member_UserNickName" placeholder=" 닉네임을 입력해주세요." value="${dto.travelMaker_Member_UserNickName}" required>
                <input id="nickCheck" class="btn" type="button" value="확인">
            </div>
        </div>

        <script>
           
        </script>

        <div class="join_items">
            <span>프로필사진</span>
            <div>
                <input id="upload_name" class="join_input" value="${dto.travelMaker_Member_EncodingProfileImg}" placeholder=" 첨부파일">
                <input id="input_file" type="file" name="upload" accept="image/*">
                <label class="file_label" for="input_file">첨부</label>
            </div>
        </div>
        <div>
            <input id="join_membership" type="submit" value="회원가입">
        </div>
    </form>
</div>

<script>
/* 아이디 중복 체크*/
 const checkDuplicationId = document.getElementById('idCheck')
const checkId = document.querySelector('input[name="travelMaker_Member_UserId"]');
 checkDuplicationId.onclick = async function(){
     console.log(checkId.value);
     if(checkId.value == ''){
         swal('경고','ID를 입력해주세요','warning');
         checkId.focus()
         return
     }
     const url = '${cpath }/ajax/checkDuplicationId?travelMaker_Member_UserId=' + checkId.value

     // 지정한 주소로 요청한 후, 응답이 오면 json 형태로 변환 / result 에 저장

     const result = await fetch(url).then(resp => resp.text())
     if (result == 1) {
         swal('성공.','사용이 가능한 ID','success');
     }
     else {
         swal('실패','중복된 ID 입니다','error');
     }
 };
 
	 const hiddenId = document.querySelector('.IdForm');
	 const hiddenPw = document.querySelector('.PwForm');


	 /* 닉네임 중복 체크 */
	  const nickCheck = document.getElementById('nickCheck');
            nickCheck.onclick = async () => {
                const nickname = document.querySelector('input[name="travelMaker_Member_UserNickName"]')
               	
                if(nickname.value == ''){
                    swal('경고','닉네임을 입력해주세요','warning');
                    nickname.focus()
                    return
                }
                const url = '${cpath }/ajax/checkDuplicationNickname?nickname=' + nickname.value

                // 지정한 주소로 요청한 후, 응답이 오면 text 형태로 변환 / result 에 저장

                const result = await fetch(url).then(resp => resp.text())
                if (result == 1) {
                    swal('성공.','사용이 가능한 닉네임','success');
                }
                else {
                    swal('실패','중복된 닉네임 입니다','error');
                }
            }
            
    /* 이메일 체크*/
    const emailCheck = document.getElementById('emailCheck')
    const certification = document.getElementById('certification')
    const inputFile = document.getElementById("input_file");
    const uploadName = document.getElementById("upload_name");

    emailCheck.addEventListener('click', function() {
        certification.style = 'display: block;'
    })
    // emailCheck.addEventListener('click', function() {
    //     alert("인증번호가 발송되었습니다")
    // })
    inputFile.addEventListener("change", function() {
        const fileName = inputFile.value;
        uploadName.value = fileName;
    })

    // emailCheck 버튼을 클릭하면, MemberAjaxController 에 있는
    // sendAuthNumber 함수 실행
    const sendAuthNumber = document.getElementById('emailCheck')
    sendAuthNumber.onclick = function (event){
        const url = '${cpath}/ajax/sendAuthNumber'
        const email = document.getElementById('email')

        // 이메일이 공백이면, 알림을 띄우고
        // 다시 이메일 창으로 focus 시킨다.
        if(email.value == ''){
            swal('경고','인증번호를 받으실 이메일을 입력해주세요.','warning');
            email.focus()
            return
        }

        fetch(url + '?email=' + email.value)
            .then(resp => resp.text())
            .then(text => {
                swal('성공','인증번호 발송 완료','success');
            })
    }
    // 회원가입시 인증번호 부터 체크하고 이후 일치한다면 가입 진행

    const form = document.querySelector('input[id="certificationCheck"]')

    const CertifyHandler = async function (event) {
        const authNumber = document.querySelector('input[name="certification"]')

        if(authNumber.value == ''){
            swal('실패.','인증번호를 확인해주세요','error');
            email.focus()
            return
        }
            // @PathVeriable 형태로 전달--%>
            const url = '${cpath}/ajax/checkAuthNumber/' + authNumber.value

            // 요청결과는 1 or 0--%>
            const authResult = await fetch(url).then(resp => resp.text())

            console.log(authResult)

            if(authResult == 0) {                           // 결과값이 0이면--%>
                swal('실패.','인증번호를 확인해주세요','error');   // 경고창을 띄우고--%>
                authNumber.value = ''
                return                                      // 함수를 종료 ( 가입 진행하지 않는다)--%>
            }
             else {                      // 결과값이 1이면 인증이 성공된 것이므로, 가입으로 진행한다.--%>
                swal('성공.','인증 성공','success');
            }
    }
    form.addEventListener('click',CertifyHandler)
</script>


</body>
</html>