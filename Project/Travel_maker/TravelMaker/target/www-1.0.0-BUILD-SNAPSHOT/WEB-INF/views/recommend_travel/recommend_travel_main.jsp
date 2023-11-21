<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../allUsedHeader.jsp" %>

<link rel="stylesheet" href="${cpath}/css/main_css/recommend_travel.css" type="text/css">

      <div class="top">
          <div class="kind_wrap">
              <div class="kind_slider">
                <ul class="slider flex" style="margin: 0; padding: 0;">
                  <li class="li_slider" >
                      <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&id=97352946-9e39-4e52-8b2c-bc311711ac4f&mode=raw" >
                  </li>
                  <li class="li_slider">
                      <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&id=727cae9b-49d2-4d36-a5ec-a5c5d8bd73c1&mode=raw">
                  </li>
                  <li class="li_slider">
                      <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&id=e19def1f-c59d-4f36-b829-ae5d12f0cce7&mode=raw">
                  </li>
                  <li class="li_slider">
                      <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&id=c0fee2b1-45ae-4d7e-ae78-4564bbe523dc&mode=raw">
                  </li>
                  <li class="li_slider">
                      <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&id=828ed0e2-bbee-403b-97e6-13b13c02b1ed&mode=raw">
                  </li>
                </ul>
              </div>
              <div class="arrow">
                  <div class="prev"> < </div>
                  <div class="next"> > </div>
              </div>
          </div>
      </div>

    <div class="bottom frame">
        <div class="bottom_logo flex">
            <h2>Travel 콕콕</h2>
            <h2>📌</h2>
        </div>
        <div class="bottom_main">
            <div class="bottom_bar">
                <p>TravelMaker가 추천하는 전국 여행지</p>
            </div>
            <p>당신이 마음에 쏙 들만한 여행지를 추천 드릴게요</p>
            <div class="bottom_area">
                <ul class="flex">
                	<li><a href="${cpath }/ajax/location" class="btn" value="전국">전국</a></li>
					<li><a href="${cpath }/ajax/location" class="btn" value="서울">서울</a></li>
					<li><a href="${cpath }/ajax/location" class="btn" value="인천">인천</a></li>
					<li><a href="${cpath }/ajax/location" class="btn" value="경기">경기</a></li>
					<li><a href="${cpath }/ajax/location" class="btn" value="강원">강원</a></li>
					<li><a href="${cpath }/ajax/location" class="btn" value="전라북도">전북</a></li>
					<li><a href="${cpath }/ajax/location" class="btn" value="전라남도">전남</a></li>
					<li><a href="${cpath }/ajax/location" class="btn" value="경상남도">경남</a></li>
					<li><a href="${cpath }/ajax/location" class="btn" value="경상북도">경북</a></li>
				</ul>	
            </div>
            <div class="bottom_img">
                <div class="bottom_nav">
					
                </div>
            </div>
        </div>
    </div>
    <!-- JavaScript 스크립트 시작 -->
<script>
    

	window.onload = function() {
	    const kindWrap = document.querySelector('.kind_wrap');
	    const slider = kindWrap.querySelector('.slider');
	    const slideLis = slider.querySelectorAll('.li_slider');
	    const moveButton = kindWrap.querySelector('.arrow');
	    const top = document.querySelector('.top');
	    const bottomBar = document.querySelector('.bottom_bar');
	    const bottomArea = document.querySelector('.bottom_area');
	    const navBtn = document.querySelectorAll('.navBtn');
	
	    // 슬라이더의 첫 번째와 마지막 이미지를 복제하여 무한 루프를 위해 준비합니다.
	    const clone1 = slideLis[0].cloneNode(true);
	    const cloneLast = slideLis[slideLis.length - 1].cloneNode(true);
	    slider.insertBefore(cloneLast, slideLis[0]);
	    slider.appendChild(clone1);
	
	    // 슬라이더와 이미지 이동에 필요한 초기 설정을 합니다.
	    let currentIdx = 0; // 현재 슬라이드 인덱스
	    let translate = 0; // 현재 슬라이더의 위치
	    const speedTime = 500; // 슬라이드 이동 속도 (밀리초)
	
	    // 슬라이더의 CSS 스타일을 설정합니다.
	    const sliderCloneLis = slider.querySelectorAll('li');
	    const liWidth = slideLis[0].clientWidth;
	    const sliderWidth = liWidth * sliderCloneLis.length;
	    slider.style.width = sliderWidth + 'px'; // 수정된 부분
	    currentIdx = 1; // 시작 시 첫 번째 슬라이드로 이동
	    translate = -liWidth;
	    slider.style.transform = 'translateX(' + translate + 'px)'; // 수정된 부분
	    const topColorArray = ['#dc564c', '#2cb4ff', '#e3af7f','#8d6f9f', '#9fb774']
	    let colorIdx= 0;
		top.style.backgroundColor=topColorArray[colorIdx];
		bottomBar.style.backgroundColor=topColorArray[colorIdx];
		bottomArea.style.backgroundColor=topColorArray[colorIdx];
		navBtn.forEach(e=> e.style.Color=topColorArray[colorIdx]);

	
	    
	
	    // 이전 및 다음 버튼에 클릭 리스너를 추가합니다.
	    moveButton.addEventListener('click', moveSlide);
	
	    // 슬라이더를 이동시키는 함수
	    function move(D) {
	        currentIdx += (-1 * D); // 다음 슬라이드로 이동 또는 이전 슬라이드로 이동
	        translate += liWidth * D; // 슬라이더를 이동할 거리 계산
	        slider.style.transform = 'translateX(' + translate + 'px)'; // 수정된 부분
	        slider.style.transition = 'all ' + speedTime + 'ms ease'; // 수정된 부분
	
// 	        top.style.backgroundColor = topColorArray[colorIdx]
	    }
	
       

        // 이전 또는 다음 버튼을 클릭할 때 호출되는 함수
        function moveSlide(event) {
            event.preventDefault();
            if (event.target.className == 'next') {
                // "다음" 버튼을 클릭한 경우
                move(-1);
                if (currentIdx == sliderCloneLis.length - 1) {
                    setTimeout(() => {
                        // 끝까지 도달하면 순환하기 위해 슬라이더 위치를 조정합니다.
                        slider.style.transition = 'none';
                        currentIdx = 1;
                        translate = -liWidth;
                        slider.style.transform = 'translateX(' + translate + 'px)';
                    }, speedTime);
					
                }
            
           	
           	
           	
               
                
                if(colorIdx ==4){
					colorIdx = colorIdx%4
					top.style.backgroundColor = topColorArray[colorIdx]
					bottomBar.style.backgroundColor=topColorArray[colorIdx];
					bottomArea.style.backgroundColor=topColorArray[colorIdx];
					navBtn.forEach(e=> {
						e.style.color=topColorArray[colorIdx];
						e.style.transition ='2s'
					})
					top.style.transition = '2s';
					bottomBar.style.transition = '2s';
					bottomArea.style.transition = '2s';
					
					
				}
                else{
                	 colorIdx+=1
                     top.style.backgroundColor = topColorArray[colorIdx]
                	 bottomBar.style.backgroundColor=topColorArray[colorIdx];
             		bottomArea.style.backgroundColor=topColorArray[colorIdx];
             		navBtn.forEach(e=> {
						e.style.color=topColorArray[colorIdx];
						e.style.transition ='2s'
					})
                	 top.style.transition = '2s';
                	 bottomBar.style.transition = '2s';
 					bottomArea.style.transition = '2s';
 					
                }
                console.log(colorIdx)
                
				
                
            } else {
                // "이전" 버튼을 클릭한 경우
                move(1);
                if (currentIdx == 0) {
                    // 처음까지 도달하면 순환하기 위해 슬라이더 위치를 조정합니다.
                    setTimeout(() => {
                        slider.style.transition = 'none';
                        currentIdx = sliderCloneLis.length - 2;
                        translate = -(liWidth * currentIdx);
                        slider.style.transform = 'translateX(' + translate + 'px)';
                    }, speedTime);
                    
                }
                if(colorIdx ==0){
					colorIdx = 4
					top.style.backgroundColor = topColorArray[colorIdx]
					bottomBar.style.backgroundColor=topColorArray[colorIdx];
					bottomArea.style.backgroundColor=topColorArray[colorIdx];
					navBtn.forEach(e=> {
						e.style.color=topColorArray[colorIdx];
						e.style.transition ='2s'
					})
					top.style.transition = '2s';
					bottomBar.style.transition = '2s';
					bottomArea.style.transition = '2s';
 					

				}
                else{
                	 colorIdx-=1
                     top.style.backgroundColor = topColorArray[colorIdx]
                	 bottomBar.style.backgroundColor=topColorArray[colorIdx];
             		bottomArea.style.backgroundColor=topColorArray[colorIdx];
             		navBtn.forEach(e=> {
						e.style.color=topColorArray[colorIdx];
						e.style.transition ='2s'
					})
                	 top.style.transition = '2s';
                	 bottomBar.style.transition = '2s';
 					bottomArea.style.transition = '2s';
 					

                }
               
            }



        }
    }

      

	const btns = document.querySelectorAll('.btn');
	const bottom_nav = document.querySelector('.bottom_nav')
	
	
	
	
	const Handler =async function(event) {
		event.preventDefault(); 
		
		bottom_nav.innerHTML = ``
		
		const liElement = event.target.parentElement;
		const value = liElement.querySelector('a').getAttribute('value');
		console.log(value);
		
		const link = event.target.getAttribute('href');
		const recommend = await fetch(link + '?value=' + value)
			.then(resp => resp.json())
			.then(data => {
				data.forEach(e => {
					const img = new Image();
					const div = document.createElement('div')
					const p = document.createElement('p')
					const a = document.createElement('a');
					img.src = e.recommend_travel_img
					p.innerText = e.recommend_travel_title
					a.href = '${cpath}/Travel_Recommend_View/'+e.recommend_travel_idx;
					a.appendChild(img);
					div.appendChild(a)
					div.appendChild(p)
					bottom_nav.appendChild(div)
			
				})
			});
	
	};
		
	
	
	btns.forEach(btn => {
		btn.addEventListener('click', Handler);
	})
</script>

</body>
</html>