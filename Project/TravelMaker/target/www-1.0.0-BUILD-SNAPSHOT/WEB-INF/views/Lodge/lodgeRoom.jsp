<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp"%>


<!-- 먼저 jQuery를 포함합니다. -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Bootstrap CSS 및 JS를 포함합니다. -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<!-- Font Awesome CSS를 포함합니다. -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

   <link rel="stylesheet" href="${cpath }/css/main_css/lodgeRoom.css" type="text/css">


<div class="Lodge_Room_HeadContainer">
	<div class="Lodge_Room_FirstShowInfoBox">
		<div class="Lodge_Room_FirstShowImg">
			<c:choose>
							<c:when test="${lodgeDTO.lodge_realimgname.contains('//image')}">
								<img src="${lodgeDTO.lodge_realimgname}">
							</c:when>
							<c:otherwise>
								<img src="${cpath}/travelImg/${lodgeDTO.lodge_realimgname}">
							</c:otherwise>
						</c:choose>
		</div>
		<div class="Lodge_Room_FirstShowText">
			<div class="firstText title">${lodgeDTO.lodge_name }</div>
			<div class="firstText rate">${lodgeDTO.lodge_rate }.0</div>
			<div class="firstText address">${lodgeDTO.lodge_address }</div>
			<div class="firstText box"></div>
			<div class="firstText save">
			<button class="heartBtn">♡</button>
				</div>
	</div>
	<div class="Lodge_Room_List">
		<div class="Lodge_Room_Img"></div>
	</div>
</div>
</div>

<div class="Lodge_Room_MainContainer">
	<div class="Lodge_Room_NavBar">
		<ul>
			<li class="navTab nav_lodgeGuide" >객실안내/예약</li>
			<li class="navTab nav_lodgeInfo" >숙소정보</li>
			<li class="navTab nav_riview" >리뷰</li>
		</ul>
	</div>
	<div class="LodgeTab">
	
		<div class="container mt-100">
			 <div class="card">
            <div class="row">
                <div class="col-md-4">
                    <label>시작일</label>
                    <input type="date" class="form-control startDate">
                </div>
                <div class="col-md-4">
                    <label>종료일</label>
                    <input type="date" class="form-control endDate">
                </div>
                <div class="col-md-4">
                    <label class="adaptTransparent">Search</label>
                    <button class="btn btn-primary pro-button w-100" id="applyButton">적용하기</button>
                </div>
            </div>
        </div>
		</div>
	
	
		<div class="RoomListContainer">
			<c:forEach var="dto" items="${RoomList }">
				<div class="room_detail_container">

					<div class="room_detail_img">
						<c:choose>
							<c:when test="${dto.lodge_Room_Type_Img.contains('//image')}">
								<img src="${dto.lodge_Room_Type_Img}">
							</c:when>
							<c:otherwise>
								<img src="${cpath}/travelImg/${dto.lodge_Room_Type_Img}">
							</c:otherwise>
						</c:choose>
					</div>
					<div class="room_detail_infoContainer">
					<div class="room_detail_name">${dto.lodge_Room_Type_Name}(${dto.lodge_Room_Type_MinCapacity} ~ ${dto.lodge_Room_Type_MaxCapacity }인)</div>
					<div class="room_detail_payment"><button class="custom-btn btn-3 paymentBtn" value=${dto.lodge_Room_Type_Idx } ><span>결제</span></button></div>
					 </div>
					 <c:if test="${user.travelMaker_Member_IsAdmin == 'Y' }">
					 	<button id="roomCorrectionBtn" value=${dto.lodge_Room_Type_Idx }><span>수정</span></button>
					 	<button id="roomDeleteBtn" value=${dto.lodge_Room_Type_Idx }><span>삭제</span></button>
					 </c:if>
				</div>
			</c:forEach>
		</div>
</div> <!-- LodgeTab -->
	<div class="LodgeInfoTab hidden">
		<div class="TextBox">
			
		</div>
	</div>
	<div class="reviewTab hidden">
			<c:forEach var="list" items="${reviewList }">
		<div class="reviewBox">
			<div id="review_name">${list.lodge_Room_Type_Name }/${list.lodge_Review_Writer}</div>
			<div id="review_rateAndId"><span id="review_rate">${list.lodge_Review_Rate*2}.0</span > | <span id="review_userid">${list.lodge_review_date }</span></div>
			<div id="review_content">${list.lodge_Review_Content }</div>
		</div>
		</c:forEach>
		<c:if test="${empty reviewList}">
			<div class="emptyRivewContainer">
				리뷰가 없습니다.  😥  
			</div>
		</c:if>
	</div>
	</div>
	<div id="nextBtn">
	<c:if test="${user.travelMaker_Member_IsAdmin == 'Y' }">
		<button id="lodgecorrectionbtn">수정</button>
		<button id="Updatebtn">삭제</button>
		<button id="lodgeRoomInsert">숙소 상세 룸 추가</button>
	</c:if>
	</div>
<script>
	
//초기 화면에서 

const navLodgeGuide = document.querySelector(".nav_lodgeGuide");
const nav_lodgeInfo = document.querySelector('.nav_lodgeInfo');
const nav_riview = document.querySelector('.nav_riview');
navLodgeGuide.classList.add("active");
const textBox = document.querySelector(".TextBox");
const LodgeTab = document.querySelector('.LodgeTab');
const LodgeInfoTab = document.querySelector('.LodgeInfoTab');
const reviewTab = document.querySelector('.reviewTab');
const room_detail_container = document.querySelectorAll('.room_detail_container');


//숙소 정보 탭 활성화
InfoTabHandler = function(){
	nav_lodgeInfo.classList.add("active");
	LodgeInfoTab.classList.remove("hidden");
	
	navLodgeGuide.classList.remove("active");
	LodgeTab.classList.add("hidden");
	
	nav_riview.classList.remove("active");
	reviewTab.classList.add("hidden");
};


nav_lodgeInfo.addEventListener('click',InfoTabHandler);


//숙소리뷰 탭 활성화
reviewTabHandler = function(){
	nav_riview.classList.add("active");
	reviewTab.classList.remove("hidden")
	
	navLodgeGuide.classList.remove("active")
	LodgeTab.classList.add("hidden")
	
	nav_lodgeInfo.classList.remove("active")
	LodgeInfoTab.classList.add("hidden")
};


nav_riview.addEventListener('click',reviewTabHandler);

//숙소 객실안내 탭 활성화
GuideTabHandler = function(){
	navLodgeGuide.classList.add("active");
	LodgeTab.classList.remove("hidden")
	
	nav_lodgeInfo.classList.remove("active")
	LodgeInfoTab.classList.add("hidden")
	
	nav_riview.classList.remove("active")
	reviewTab.classList.add("hidden")
};


navLodgeGuide.addEventListener('click',GuideTabHandler);
	
	
	
	
	let content ='${lodgeDTO.lodge_content }';
	content = content.replace("한마디",'한마디\n\n')
	content = content.replace("기본정보",'\n\n기본정보\n\n')
	content = content.replace("추가정보",'\n\n추가 정보\n\n')
	content = content.replace("인원 추가 정보",'\n인원 추가 정보\n\n')
	content = content.replace("주차장",'\n\n주차장\n\n')
	content = content.replace("주변 정보",'\n\n주변 정보\n\n')
	content = content.replace("주변정보",'\n\n주변 정보\n\n')
	content = content.replace("결제취소 및 환불 규정",'\n\n주변 결제취소 및 환불 규정\n\n')
	content = content.replace("확인사항 및 기타",'\n확인사항 및 기타\n\n')
	textBox.innerText =  content.replaceAll('다 ','다.\n\n');
	textBox.innerText =  content.replaceAll('다 ','다.\n\n');
	textBox.innerText =  content.replaceAll('•  ','.\n\n•');
	textBox.innerText =  content.replaceAll('▶','.\n\n▶');
		
	

    
   
    

    let selectedStartDate = document.querySelector('.startDate').value;
    let selectedEndDate = document.querySelector('.endDate').value;
    $(document).ready(function () {
        $('#applyButton').on('click', function () {
            // 시작일과 종료일을 가져오기
            const selectedStartDate = $('.startDate').val();
            const selectedEndDate = $('.endDate').val();
            const lodge_idx = '${lodgeDTO.lodge_idx}';

            if (!selectedStartDate || !selectedEndDate) {
                swal('날짜 지정 오류','시작일과 종료일을 다시 지정하고 적용하기를 눌러주세요!','error');
            } else if (new Date(selectedStartDate) >= new Date(selectedEndDate)) {
                swal('날짜 지정 오류','종료일은 시작일과 같을 수 없으며 시작일보다 빠를 수 없습니다.','error');
            } else {
                // 오늘 날짜를 가져오기
                const today = new Date();
                
                // 선택한 시작일을 Date 객체로 변환
                const startDate = new Date(selectedStartDate);
                
                // 시작일이 오늘 이전 날짜인 경우
               if (
			        startDate.getFullYear() < today.getFullYear() ||
			        (startDate.getFullYear() === today.getFullYear()
							&& startDate.getMonth() < today.getMonth()) ||
			        (startDate.getFullYear() === today.getFullYear() && startDate.getMonth() === today.getMonth()
							&& 	startDate.getDate() < today.getDate())
			    ) {
			        swal('날짜 지정 오류', '오늘 이전 날짜를 선택할 수 없습니다.', 'error');
			    }else {
                    // 시작일과 종료일이 유효한 경우에만 AJAX 요청을 보냅니다.
                    $.ajax({
                        type: 'POST',
                        url: '${cpath}/lodge/getselectedRoom',
                        data: JSON.stringify({ lodge_Idx: lodge_idx, startDate: selectedStartDate, endDate: selectedEndDate }),
                        contentType: 'application/json',
                        success: function (resp) {
							// 일수 계산하는 함수
							const timeDiff = new Date(selectedEndDate) - new Date(selectedStartDate);

							const daysDiff = Math.ceil(timeDiff / (1000 * 3600 * 24));
                            // 최상위 태그
                            const parentElement = document.querySelector('.RoomListContainer');
                            parentElement.innerHTML = '';

                            resp.forEach(e => {
                            	if(e.lodge_Room_Type_Count<=0){
                            		return
                            	}
                                // 새로운 room_detail_container 요소 생성
                                const roomDetailContainer = document.createElement('div');
                                roomDetailContainer.className = 'room_detail_container';

                             // 이미지 URL이 "//image"로 시작하는 경우
                                const roomDetailImg = document.createElement('div');
                                roomDetailImg.className = 'room_detail_img';
                                const img = document.createElement('img');
                                if(e.lodge_Room_Type_Img.includes('//image')){
                                img.src =e.lodge_Room_Type_Img; 
                                }else{
                                	img.src='${cpath}/travelImg/'+e.lodge_Room_Type_Img
                                }
                                roomDetailImg.appendChild(img);

                                // room_detail_infoContainer 요소 생성
                                const roomDetailInfoContainer = document.createElement('div');
                                roomDetailInfoContainer.className = 'room_detail_infoContainer';

                                // room_detail_name 요소 생성
                                const roomDetailName = document.createElement('div');
                                roomDetailName.className = 'room_detail_name';
                                roomDetailName.textContent = e.lodge_Room_Type_Name + '(' + e.lodge_Room_Type_MinCapacity + ' ~ ' + e.lodge_Room_Type_MaxCapacity + '인)';

                                // room_detail_count 요소 생성
                                const roomDetailCount = document.createElement('div');
                                roomDetailCount.className = 'room_detail_count';
                                roomDetailCount.textContent = '남은 호실 개수 :' + e.lodge_Room_Type_Count;

                                // room_detail_price 요소 생성
                                const roomDetailPrice = document.createElement('div');
                                roomDetailPrice.className = 'room_detail_price';
                                roomDetailPrice.textContent = '가격 :' + e.lodge_Room_Type_price*daysDiff;



                                // room_detail_capacity 요소 생성
                                const roomDetailCapacity = document.createElement('div');
                                roomDetailCapacity.className = 'room_detail_capacity';
                                roomDetailCapacity.textContent = '예약시작 및 종료일 :' + selectedStartDate + '~' + selectedEndDate + '(' + (daysDiff ) + '박' + (daysDiff+1) + '일)';

                                // room_detail_payment 요소 생성
                                const roomDetailPayment = document.createElement('div');
                                roomDetailPayment.className = 'room_detail_payment';
                                const paymentBtn = document.createElement('button');
                                paymentBtn.className = 'custom-btn btn-3 paymentBtn';
                                paymentBtn.value = e.lodge_Room_Type_Idx; // 버튼 값 설정
                                paymentBtn.innerHTML = '<span>결제</span>';
                                roomDetailPayment.appendChild(paymentBtn);

                                // 생성한 모든 하위 요소를 room_detail_infoContainer에 추가
                                roomDetailInfoContainer.appendChild(roomDetailName);
                                roomDetailInfoContainer.appendChild(roomDetailCount);
                                roomDetailInfoContainer.appendChild(roomDetailPrice);
                                roomDetailInfoContainer.appendChild(roomDetailCapacity);
                                roomDetailInfoContainer.appendChild(roomDetailPayment);

                                // room_detail_container를 RoomListContainer에 추가
                                roomDetailContainer.appendChild(roomDetailImg);
                                roomDetailContainer.appendChild(roomDetailInfoContainer);

                                // RoomListContainer에 생성한 room_detail_container 요소 추가
                                parentElement.appendChild(roomDetailContainer);

                                const payBtn = document.querySelectorAll('.paymentBtn');

                                payBtn.forEach(e => {
                                    e.addEventListener('click', () => {
                                        if (selectedStartDate && selectedEndDate) {
                                            location.href = '${cpath}/lodge/Payment/' + e.value + '/' + selectedStartDate + '/' + selectedEndDate;
                                        } else {
                                            swal('날짜 지정 오류','시작일과 종료일을 다시 지정하고 적용하기를 눌러주세요!','error');
                                        }
                                    });
                                });
                            });
                        }
                    });
                }
            }
        });
    });

    // 찜 버튼
   	const save = document.querySelector('.save')
   	let userid = '${user.travelMaker_Member_UserId}'
   	let lodge_idx = '${lodgeDTO.lodge_idx}'
   	let user = '${user}'
   	const heartBtn = document.querySelector('.heartBtn')
   	
    
    const LikeHandler = function () {
		if(user){
			$.ajax({
	            url: '${cpath}/lodge/insertSave',
	            method: 'GET',
	            data: { lodge_idx: lodge_idx, userid: userid },
	            success: function (resp) {
	                    if(resp == '1') {
	                        alert('찜 목록에 추가 되었습니다.')
	                        heartBtn.innerText = '♥'
	                        heartBtn.style.color = 'red'
	                    }
	                    else {
	                        alert('이미 찜 목록에 추가 되어있습니다')
	                        heartBtn.innerText = '♥'
	                        heartBtn.style.color = 'red'
	                    }
	                }
	            
	        });
			}else{
				swal('로그인필요','로그인을 먼저 해주세요','error')
			}
		}
   		
        
    
	heartBtn.addEventListener('click',LikeHandler)
    const payBtn = document.querySelectorAll('.paymentBtn');
	console.log(payBtn)
    payBtn.forEach(e => {
        e.addEventListener('click', () => {
            if (selectedStartDate && selectedEndDate) {
                location.href = '${cpath}/lodge/Payment/' + e.value + '/' + selectedStartDate + '/' + selectedEndDate;
            } else {
                swal('날짜 지정 오류','시작일과 종료일을 다시 지정하고 적용하기를 눌러주세요!','error');
            }
        });
    });
	
	const lodgecorrectionbtn = document.getElementById('lodgecorrectionbtn')
	const roomCorrectionBtn = document.querySelectorAll('#roomCorrectionBtn')
	const roomDeleteBtn = document.querySelectorAll('#roomDeleteBtn')
	const lodgeRoomInsert = document.getElementById('lodgeRoomInsert')
	const Updatebtn = document.getElementById('Updatebtn')
	
	// 상세 숙소 추가 스크립트
	let idx = '${lodgeDTO.lodge_idx}'
	console.log(idx)
	if(lodgeRoomInsert){
		
		lodgeRoomInsert.addEventListener('click', function() {
		if (confirm("해당 숙소에 방을 추가 하시겠습니까?")) {
			location.href = '${cpath}/Admin/lodgeRoomWrite/' + idx;
	        
	    } else {
	        alert("해당 숙소에 룸에 추가가 취소되었습니다.");
	    }
		});
	}
	
	if(Updatebtn){
		
	Updatebtn.addEventListener('click', function() {
			
			if (confirm("다시는 되돌릴 수 없습니다\n삭제하시겠습니까?")) {
				location.href = '${cpath}/Admin/lodgeUpdateOne/' + idx;
		    } else {
		        alert("삭제가 취소되었습니다.");
		    }
	});
	}
		if(lodgecorrectionbtn){
			lodgecorrectionbtn.addEventListener('click', function() {
				let lodge = '${lodgeDTO.lodge_isdeleted}'
				let idx = '${lodgeDTO.lodge_idx}'
				
					if(lodge == 'Y'){
						alert('삭제 된 숙소입니다')
					}
					else {
						if (confirm("숙소 정보를 수정하시겠습니까?")) {
							location.href = '${cpath}/Admin/lodgecorrectionOne/' + idx;
							
					    } else {
					        alert("수정이 취소되었습니다.");
					    }
					}
					
			});
		}
		

		if(roomCorrectionBtn){
			roomCorrectionBtn.forEach(e => {
				e.addEventListener('click', function() {
					let idx = e.value;
				
					let lodge = '${lodgeDTO.lodge_isdeleted}'
					
					if(lodge == 'Y'){
						alert('삭제 된 숙소 입니다')
					}else {
						if(confirm("상세 숙소 정보를 수정하시겠습니까?")) {
							location.href= '${cpath}/Admin/roomcorrection/' + idx;
						}else {
							alert('상세 숙소 정보 수정을 취소하였습니다')
						}
					}
					
				})	
					
				})
		}
		
		
		if(roomDeleteBtn){
			roomDeleteBtn.forEach(e => {
				e.addEventListener('click', function() {
					let idx = e.value;
				
					let lodge = '${lodgeDTO.lodge_isdeleted}'
					
					if(lodge == 'Y'){
						alert('삭제 된 숙소 입니다')
					}else {
						if(confirm("상세 숙소를 삭제하시겠습니까?")) {
							location.href= '${cpath}/Admin/deleteRoom/' + idx;
						}else {
							alert('상세 숙소 정보 수정을 취소하였습니다')
						}
					}
					
				})	
					
				})
		}
		
	</script>
	
	
	
	

</body>
</html>
