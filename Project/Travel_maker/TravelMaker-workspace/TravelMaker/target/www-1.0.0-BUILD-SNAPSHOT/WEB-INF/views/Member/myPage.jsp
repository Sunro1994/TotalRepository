<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="cpath" value="${pageContext.request.contextPath }" />
    <%@ include file="../allUsedHeader.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cpath }/css/main_css/myPage.css" type="text/css">
</head>
<style>
	.hidden{
		display: none;
	}
</style>
<body>
 <div id="mypage" class="flex_center">
        <div class="profile flex_center">
            <div class="profile_top">
                <img src="${cpath}/img/tm330.png">
                <div>
                    <h2>마이 페이지</h2>
                </div>
            </div>
            <div class="profile_main">
                <div id="profile_img" class="flex_center" style="background-image: url('${cpath}/travelImg/${user.travelMaker_Member_EncodingProfileImg}');">
                    <!-- url(${TRAVELMAKER_MEMBER_ENCODINGPROFILEIMG}) -->
                    <button id="profile_modify_btn">
                        <img src="${cpath}/img/modify.png">
                    </button>
                </div>
                <div class="flex_center">
                    <h2 id="flex_id1">${user.travelMaker_Member_UserNickName}</h2>
                </div>
            </div>
        </div>
        <div class="info flex_center">
            <div class="info_top">
                <h2 id="flex_id2">프로필</h2>
            </div>
            <div class="info_item flex_center">
                <div class="border_bottom">
                    <img src="${cpath}/img/name.png">
                    <span>${user.travelMaker_Member_UserName}</span>
                </div>
            </div>
            <div class="info_item flex_center">
                <div class="border_bottom">
                    <img src="${cpath}/img/pun.png">
                    <span>${user.travelMaker_Member_Pnum}</span>
                </div>
            </div>
            <div class="info_item flex_center">
                <div>
                    <img src="${cpath}/img/mail.png">
                    <span>${user.travelMaker_Member_Email}</span>
                </div>
            </div>
        </div>
        <button id="membership_quit">회원 탈퇴 ></button>
         <c:if test="${user.travelMaker_Member_IsAdmin == 'Y' }">
	      <button id="adminEnterBtn">관리자 페이지 이동 ></button>
        </c:if>
    </div>
    <dialog id="membership_quit_check">
        <div class="flex_center">
            <div class="profile_top">
                <img src="${cpath}/img/tm330.png">
                <div style="margin-bottom: 50px;">
                    <h2>회원탈퇴</h2>
                </div>
            </div>
            <form method="get">
                <div class="join_items">
                    <span>비밀번호 확인</span>
                    <div class="join_item">
                        <input id="membership_quit_userpw_check"  class="unset" type="password" name="TRAVELMAKER_MEMBER_USERPW" placeholder="현재 비밀번호를 입력해주세요."  
                        autocomplete="off" required>
                    </div>
                	<!-- value=${TRAVELMAKER_MEMBER_USERPW} -->
                </div>
                <input id="membership_quit_complete" type="submit" value="확인">
            </form>
        </div>
        <form method="dialog">
            <button id="membership_quit_close">취소</button>
        </form>
    </dialog>
    <dialog id="profile_modify_check">
        <div class="flex_center">
            <div class="profile_top">
                <img src="${cpath}/img/tm330.png">
                <div style="margin-bottom: 50px;">
                    <h1>회원정보 수정</h1>
                </div>
            </div>
            <div class="join_items">
                <span>비밀번호 확인</span>
                <div class="join_item">
                    <input id="userpw_check" class="unset" type="password" name="TRAVELMAKER_MEMBER_USERPW" placeholder="현재 비밀번호를 입력해주세요." 
                    autocomplete="off" required>
                </div>
            </div>
        </div>
        <button id="profile_modify_check_btn">확인</button>
        <form method="dialog">
            <button id="profile_modify_close">취소</button>
        </form>
    </dialog>
    <dialog id="profile_modify">
    
        <form method="POST" encType="multipart/form-data" class="flex_center" autocomplete="off">
            <div class="profile_top">
                <img src="${cpath}/img/tm330.png">
                <div>
                    <h1>회원정보 수정</h1>
                </div>
            </div>
            <div class="flex_center">
        		<img id="profile_img_modify" src="${cpath}/travelImg/${user.travelMaker_Member_EncodingProfileImg}">       
            </div>
            <div class="join_items">
                <span>닉네임</span>
                <div>
                    <input class="join_input" type="text" name="travelMaker_Member_UserNickName" value="${user.travelMaker_Member_UserNickName}" required>
                    <!-- value=${TRAVELMAKER_MEMBER_USERNICKNAME} -->
                    <input id="nickCheck" class="btn" type="button" value="확인">
                </div>
            </div>
          <c:if test="${empty isGoogle and empty isKakao and empty isNaver}">
            <div class="join_items">
                <span>비밀번호</span>
                <div class="join_item">
                    <input id="userpw" class="unset" type="password" name="travelMaker_Member_UserPw" placeholder="변경할 비밀번호를 입력해주세요."  required>
                </div>
            </div>
          </c:if>
            
            <div class="join_items">
                <span>전화번호</span>
                <div class="join_item">
                    <input class="unset" type="text" name="travelMaker_Member_Pnum" value="${user.travelMaker_Member_Pnum}"
                    pattern="[0-9]{11}" title="11자리 숫자만 입력해 주세요." required>
                    <!-- value=${TRAVELMAKER_MEMBER_PNUM} -->
                </div>
            </div>
            <div class="join_items">
                <span>프로필사진</span>
                <div>
                    <input id="upload_name" class="join_input" value="" placeholder="변경할 프로필사진 첨부">
                    <input id="input_file" type="file" name="upload" accept="image/*">
                    <label class="file_label" for="input_file">첨부</label>
                </div>
            </div>
            <input id="profile_modify_complete" type="submit" value="확인">
        </form>
        
        <form method="dialog">
            <button id="profile_modify_close">취소</button>
        </form>
    </dialog>
	 <dialog id="ApiUser_quit_check">
    <div class="flex_center">
         <div class="ApiUser_quit_check_top flex_center">
             <img src="${cpath}/img/tm330.png">
            <div>
                <h1>회원 탈퇴</h1>
            </div>
        </div>
        <div class="join_items">
            <span>email인증</span>
            <div>
                <input class="EmailSendInput join_input" type="email" placeholder="인증할 E-mail을 입력해주세요" value=${user.travelMaker_Member_Email}>
                <button class="CheckValidNumber_API btn">확인</button>
            </div>
        </div>
        <div class="join_items">
            <span>인증번호</span>
            <div>
                <input class="EmailCheckInput join_input" type="email" placeholder="인증번호를 입력해주세요." >
                <button class="APIValidNumber_CheckBtn btn">확인</button>
            </div>
        </div>
        <form method="dialog">
            <button id="ApiUser_quit_check_close">취소</button>
        </form>
    </div>
    </dialog>
    <script>
        const profileModifyBtn = document.getElementById("profile_modify_btn")
        const profileModify = document.getElementById("profile_modify")
        const profileModifyCheck = document.getElementById("profile_modify_check")
        const profileModifyCheckBtn = document.getElementById("profile_modify_check_btn")
       
        const userpwCheck = document.getElementById("userpw_check");
        const inputFile = document.getElementById("input_file")
        const uploadName = document.getElementById("upload_name")
        const profileImg = document.getElementById("profile_img")
        const myPage_ProfileImg = document.querySelector("myPage_ProfileImg")
        
        const membershipQuit = document.getElementById("membership_quit")
        const membershipQuitCheck = document.getElementById("membership_quit_check")
        const membershipQuitUserpwCheck = document.getElementById("membership_quit_userpw_check")
        const membershipQuitUserpwNone = document.getElementById("membership_quit_userpw_none")
        const membershipQuitComplete = document.getElementById("membership_quit_complete")


        membershipQuit.addEventListener("click", () => {
        	if('${isGoogle}'=='y' || '${isKakao}'=='y'||'{isNaver}'=='y'){
        		ApiUser_quit_check.showModal()
        	}else{
        		membershipQuitCheck.showModal()    
        	}
        })
        profileModifyBtn.addEventListener("click", () => {
        	if('${isGoogle}'=='y' || '${isKakao}'=='y'||'{isNaver}'=='y'){
        		profileModify.showModal()
        	}else{
            	profileModifyCheck.showModal()
        		
        	}
        })
        profileModifyCheckBtn.addEventListener("click", () => {
        	console.log(userpwCheck.value)
        	
        		/* 비동기로 비밀번호를 salt와 섞어서 가져와야함 */
            	$.ajax({
            		 type:'POST',  
                 	  url : '${cpath}/ajax/getPassword',
       	          contentType : 'application/json',
       	          data : {password : userpwCheck.value},
       	          success:function(resp) { 
       	        	  if(resp == '${user.travelMaker_Member_UserPw}' ){
       	        		profileModify.showModal()
       	        	  }
       	        	  else{
       	        		  alert('비밀번호가 일치하지 않습니다.')
       	        	  }
       	          }//success
            	})//ajax
        	})//Listener         
        
      
        inputFile.addEventListener("change", function() {
            const fileName = inputFile.value;
            uploadName.value = fileName;
        })
        function changeHandler(event) {
            const profileImgModify = document.getElementById('profile_img_modify')
            if(event.target.files && event.target.files[0]) {
                const reader = new FileReader()
                reader.onload = (e) => {

                	profileImgModify.src= e.target.result;
                }
                reader.readAsDataURL(event.target.files[0])
            }
            else {
                preview.style.backgroundImage = ''
            }
        }
        inputFile.addEventListener('change', changeHandler)
        
        
        const checkbtn = document.getElementById('membership_quit_complete')
        const inputpw = document.getElementById('membership_quit_userpw_check') // membership_quit_userpw_check
        

        const handler = async function(event) {
        	event.preventDefault();
	        const numpw = inputpw.value; 
			console.log('numpw',numpw)
	        const url = '${cpath}/ajax/myPage/secession';
	        
            if (numpw === '') {
                alert('비밀번호를 입력해주세요.');
            } 
            else {
              		await fetch(url, {
                    method: 'POST',
                    body: JSON.stringify(numpw), 
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                .then(resp => {
                   return resp.json();
                })
                .then(data => {
                   alert(data.res);
                   if(data.res  == '탈퇴실패' || data.res == '비밀번호 불일치'){
                	   return
                   }
                   if(data.res  == '탈퇴되었습니다\n그동안 이용해주셔서 감사합니다') {
// 	               	   alert(data.result);
	                   location.href='${cpath}'
                	   
                   }
                })
            };
        }

        checkbtn.addEventListener('click', handler);
        
        const nickCheck = document.getElementById('nickCheck');
        nickCheck.onclick = async () => {
            const nickname = document.querySelector('input[name="travelMaker_Member_UserNickName"]')

            if(nickname.value == ''){
               alert('닉네임을 입력해주세요')
                nickname.focus()
                return
            }
            const url = '${cpath }/ajax/checkDuplicationNickname?nickname=' + nickname.value

            // 지정한 주소로 요청한 후, 응답이 오면 text 형태로 변환 / result 에 저장

            const result = await fetch(url).then(resp => resp.text())
            if (result == 1) {
                alert('사용 가능한 닉네임 입니다')
            }
            else {
              alert('중복된 닉네임 입니다')
            }
        }
        
        
        /* API user 이메일 전송 Ajax Script*/
        
        CheckValidNumber_API = document.querySelector('.CheckValidNumber_API');
        EmailSendInput = document.querySelector('.EmailSendInput').value;
		APIValidNumber_CheckBtn = document.querySelector('.APIValidNumber_CheckBtn');
		
        CheckValidNumber_API.addEventListener('click',()=>{
        	$.ajax({
        		url : '${cpath}/ajax/checkValidNumber',
        		method: 'GET',
        		data : {
        			email: EmailSendInput
        		},
        		contentType : 'application/json',
        		success : function(e){
        			
        			APIValidNumber_CheckBtn.addEventListener('click',()=>{
		EmailCheckInput = document.querySelector('.EmailCheckInput').value;
        				console.log(e);
    					console.log(EmailCheckInput)
        				if(EmailCheckInput == e){
        					
        					alert('인증번호 일치, 성공적으로 확인되었습니다. 탈퇴를 진행합니다.')
        					location.href='${cpath}/Member/withdrawMember'
        				}else{
        					alert('인증번호 불일치','인증번호를 다시 입력해주세요 .','error')        					
        				}
        			}) // APIValidNumber_CheckBtn.addEventListener
        			
        		}
        	}) //ajax
        })
        
        
          const adminEnterBtn = document.getElementById('adminEnterBtn')

    adminEnterBtn.addEventListener('click', async (e) => {
        e.preventDefault();

        const { value: getPW } = await swal({
            title: '비밀번호를 입력해주세요',
            input: 'password',
            inputPlaceholder: '비밀번호를 입력해주세요',
            showCancelButton: true, // 취소 버튼 표시
        });

        if (getPW) { // 사용자가 비밀번호를 입력하고 확인 버튼을 누른 경우
            $.ajax({
                type: 'POST',
                url: '${cpath}/ajax/adminCheck',
                data: { password: getPW },
                success: function (resp) {
                    if (resp == '${user.travelMaker_Member_UserPw}') {
                        location.href = '${cpath}/Admin/admin';
                    } else {
                        swal('실패', '비밀번호를 확인해주세요', 'error');
                    }
                }
            });
        }
    }); 
        </script>


</body>
</html>