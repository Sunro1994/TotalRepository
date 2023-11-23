<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../allUsedHeader.jsp" %>

<link rel="stylesheet" href="${cpath}/css/main_css/recommend_travel.css" type="text/css">

       <div class="top">
          <div class="kind_wrap">
              <div class="kind_slider">
                <ul class="slider flex" style="margin: 0; padding: 0;">
                  <li class="li_slider" >
                        <!-- 강진 춤추는 갈대 -->
                      <a href="${cpath }/Travel_Recommend_View/28"><img src="https://mblogthumb-phinf.pstatic.net/MjAyMjEwMDZfMjA0/MDAxNjY0OTkyNzY3NjQ3.A4tl0NqJ8dnuy4Xt8nkoSoQiY_yt5Rwm2O4iF4fStxQg.ziEXYyaIG2qCORIhLhVD9u45s6jN5JUwBBbwGbuux_Yg.JPEG.happyrain012/902A3921.jpg?type=w800" ></a>

                  </li>
                  <li class="li_slider">
                        <!-- 기장 멸치축제-->
                      <a href="${cpath }/Travel_Recommend_View/98"><img src="https://a.cdn-hotels.com/gdcs/production123/d1230/d3ed36fc-c77c-4843-9b5e-7a5bfe80151d.jpg?impolicy=fcrop&w=800&h=533&q=medium"></a>
                  </li>
                  <li class="li_slider">
                          <!-- 강릉 단오제 -->
                      <a href="${cpath }/Travel_Recommend_View/13"><img src="https://img.freepik.com/premium-photo/bukchon-hanok-village-with-seoul-city-skyline-cityscape-of-south-korea_255553-4695.jpg"></a>
                  </li>
                  <li class="li_slider">
                        <!-- 고창 핑크 뮬리 -->
                      <a href="${cpath }/Travel_Recommend_View/76"><img src="https://www.junggi.co.kr/data/article/20230324/641d0c3b94d5a.jpg"></a>
                  </li>
                  <li class="li_slider">
                        <!-- 거창 감악산 꽃&별 여행 -->
                      <a href="${cpath }/Travel_Recommend_View/5"><img src="https://www.ilyosisa.co.kr/data/photos/20230417/art_16826585521464_7c6f5e.jpg"></a>
                  </li>
                </ul>
              </div>
              <div class="arrow">
                  <div class="prev"> </div>
                  <div class="next"> </div>
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
                    <li><a href="${cpath }/ajax/location" class="btn" value="전라">전라</a></li>
                    <li><a href="${cpath }/ajax/location" class="btn" value="경상">경상</a></li>
                    <li><a href="${cpath }/ajax/location" class="btn" value="충청">충청</a></li>
                    <li><a href="${cpath }/ajax/location" class="btn" value="부산">부산</a></li>
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




    // 페이지가 로드되면 실행되는 함수
    window.onload = function() {
        // DOM에서 필요한 요소들을 선택
        const kindWrap = document.querySelector('.kind_wrap');
        const slider = kindWrap.querySelector('.slider');
        const slideLis = slider.querySelectorAll('.li_slider');
        const moveButton = kindWrap.querySelector('.arrow');
        const top = document.querySelector('.top');
        const bottomBar = document.querySelector('.bottom_bar');
        const bottomArea = document.querySelector('.bottom_area');
        const navBtn = document.querySelectorAll('.navBtn');

        // 슬라이더의 첫 번째와 마지막 이미지를 복제하여 무한 루프를 위해 준비
        const clone1 = slideLis[0].cloneNode(true);
        const cloneLast = slideLis[slideLis.length - 1].cloneNode(true);
        slider.insertBefore(cloneLast, slideLis[0]);
        slider.appendChild(clone1);

        // 슬라이더와 이미지 이동에 필요한 초기 설정
        let currentIdx = 0; // 현재 슬라이드 인덱스
        let translate = 0; // 현재 슬라이더의 위치
        const speedTime = 500; // 슬라이드 이동 속도 (밀리초)

        // 슬라이더의 CSS 스타일을 설정
        const sliderCloneLis = slider.querySelectorAll('li');
        const liWidth = slideLis[0].clientWidth;
        const sliderWidth = liWidth * sliderCloneLis.length;
        slider.style.width = sliderWidth + 'px'; // 수정된 부분
        currentIdx = 1; // 시작 시 첫 번째 슬라이드로 이동
        translate = -liWidth;
        slider.style.transform = 'translateX(' + translate + 'px)'; // 수정된 부분

        // 슬라이더의 색상 배열 및 인덱스 초기화
        const topColorArray = ['#dc564c', '#2cb4ff', '#e3af7f', '#8d6f9f', '#9fb774']
        let colorIdx = 0;
        top.style.backgroundColor = topColorArray[colorIdx];
        bottomBar.style.backgroundColor = topColorArray[colorIdx];
        bottomArea.style.backgroundColor = topColorArray[colorIdx];
        navBtn.forEach(e => e.style.color = topColorArray[colorIdx]);

        // 다음 및 이전 버튼에 클릭 이벤트 리스너 추가
        moveButton.addEventListener('click', moveSlide);

        // 슬라이더를 이동시키는 함수
        function move(D) {
            currentIdx += (-1 * D); // 다음 슬라이드로 이동 또는 이전 슬라이드로 이동
            translate += liWidth * D; // 슬라이더를 이동할 거리 계산
            slider.style.transform = 'translateX(' + translate + 'px)'; // 수정된 부분
            slider.style.transition = 'all ' + speedTime + 'ms ease'; // 수정된 부분
        }

        // 다음 또는 이전 버튼 클릭시 호출되는 함수
        function moveSlide(event) {
            event.preventDefault();
            if (event.target.className == 'next') {
                // "다음" 버튼을 클릭한 경우
                move(-1);
                if (currentIdx == sliderCloneLis.length - 1) {
                    // 끝까지 도달하면 순환하기 위해 슬라이더 위치를 조정
                    setTimeout(() => {
                        slider.style.transition = 'none';
                        currentIdx = 1;
                        translate = -liWidth;
                        slider.style.transform = 'translateX(' + translate + 'px)';
                    }, speedTime);
                }

                // 색상 인덱스 업데이트 및 색상 적용
                if (colorIdx == 4) {
                    colorIdx = colorIdx % 4;
                    updateColors();
                } else {
                    colorIdx += 1;
                    updateColors();
                }
            } else {
                // "이전" 버튼을 클릭한 경우
                move(1);
                if (currentIdx == 0) {
                    // 처음까지 도달하면 순환하기 위해 슬라이더 위치를 조정
                    setTimeout(() => {
                        slider.style.transition = 'none';
                        currentIdx = sliderCloneLis.length - 2;
                        translate = -(liWidth * currentIdx);
                        slider.style.transform = 'translateX(' + translate + 'px)';
                    }, speedTime);
                }

                // 색상 인덱스 업데이트 및 색상 적용
                if (colorIdx == 0) {
                    colorIdx = 4;
                    updateColors();
                } else {
                    colorIdx -= 1;
                    updateColors();
                }
            }
        }

        // 색상 업데이트 함수
        function updateColors() {
            top.style.backgroundColor = topColorArray[colorIdx];
            bottomBar.style.backgroundColor = topColorArray[colorIdx];
            bottomArea.style.backgroundColor = topColorArray[colorIdx];
            navBtn.forEach(e => {
                e.style.color = topColorArray[colorIdx];
                e.style.transition = '2s';
            });
            top.style.transition = '2s';
            bottomBar.style.transition = '2s';
            bottomArea.style.transition = '2s';
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
	
	btns[0].click();
	
	  const notDoubleClick = function() {
	        var accessibleCount = 2;
	        accessibleCount = accessibleCount - 1;

	        if (accessibleCount <= 0) {
	            alert("이미 작업이 수행중입니다.");
	        } else {
	            doSomething();
	        }
	            accessibleCount = accessibleCount + 1;

	    };

	    btns.forEach(btn => {
	        btn.addEventListener('click', notDoubleClick);
	    })
</script>

</body>
</html>