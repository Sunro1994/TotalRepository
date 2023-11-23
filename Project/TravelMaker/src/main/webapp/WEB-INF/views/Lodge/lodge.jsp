<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../allUsedHeader.jsp"%>

	
<link rel="stylesheet"
	href="${cpath}/css/main_css/recommend_travel_view.css" type="text/css">
<link rel="stylesheet" href="${cpath }/css/main_css/lodge.css"
	type="text/css">	




<aside class="Lodge-Filter">
	<div>
		<div class="DateFilterName"></div>
		<span style="    width: 100%;    display: inline-block; text-align: center;">시작일</span>
		<input type="date" id="startDate" /> 
		<span style="    width: 100%;    display: inline-block; text-align: center;">종료일</span>
		<input type="date" id="endDate" />
	</div>
	<div class="ApplyFilterName">상세조건</div>
	<div class="ApplyFilter">
		<div class="ApplyBox">
			<button class="ResetBtn">초기화</button>
			<button class="ApplyBtn">적용</button>
		</div>
	</div>
	<div class="LocationFilterName">지역</div>
	<div class="LocationFilter">
		<div>



			<div class="form-check">
				<p>
					<input class="form-check-input" type="checkbox" value=" "
						id="flexCheck "> <label class="form-check-label"
						for="flexCheck "> 서울 </label>
				</p>
				<p>
					<input class="form-check-input" type="checkbox" value=" "
						id="flexCheck 2"> <label class="form-check-label"
						for="flexCheck 2"> 부산 </label>
				</p>
				<p>
					<input class="form-check-input" type="checkbox" value=" "
						id="flexCheck 3"> <label class="form-check-label"
						for="flexCheck 3">광주</label>
				</p>
				<p>
					<input class="form-check-input" type="checkbox" value=" "
						id="flexCheck 4"> <label class="form-check-label"
						for="flexCheck 4"> 강원 </label>
				</p>
				<p>
					<input class="form-check-input" type="checkbox" value=" "
						id="flexCheck 5"> <label class="form-check-label"
						for="flexCheck 5"> 경기 </label>
				</p>
				<p>
					<input class="form-check-input" type="checkbox" value=" "
						id="flexCheck 5"> <label class="form-check-label"
						for="flexCheck 5"> 대전 </label>
				</p>
				<p>
					<input class="form-check-input" type="checkbox" value=" "
						id="flexCheck 6"> <label class="form-check-label"
						for="flexCheck 6"> 인천 </label>
				</p>
			</div>
		</div>
		<div>

			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 7"> <label class="form-check-label"
					for="flexCheck 7"> 경북 </label>
			</p>
			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 8"> <label class="form-check-label"
					for="flexCheck 8"> 경남 </label>
			</p>
			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 9"> <label class="form-check-label"
					for="flexCheck 9"> 전북 </label>
			</p>
			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 10"> <label class="form-check-label"
					for="flexCheck 10"> 전남 </label>
			</p>
			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 11"> <label class="form-check-label"
					for="flexCheck 11"> 충남 </label>
			</p>
			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 12"> <label class="form-check-label"
					for="flexCheck 12"> 충북 </label>
			</p>
		</div>
	</div>
	<div class="TypeFilterName">타입</div>
	<div class="TypeFilter">
		
		<div class="form-check TypeForm">
			<div>
			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 13"> <label class="form-check-label"
					for="flexCheck 13"> 모텔 </label>
			</p>
			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 14"> <label class="form-check-label"
					for="flexCheck 14"> 호텔 </label>
			</p>
			</div>
			<div>
			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 15"> <label class="form-check-label"
					for="flexCheck 15"> 펜션 </label>
			</p>
			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 16"> <label class="form-check-label"
					for="flexCheck 16"> 캠핑 </label>
			</p>
			</div>
		</div>
	</div>
</aside>
<!--필터-->
<main>
<article class="Lodge-Filter-Result">
	<div class="Result-Info-Box">
		<input type="text" placeholder="숙소 이름을 검색해보세요." class="searchText" onkeyup="if(window.event.keyCode==13){(searchEnter())}" autocomplete="off"><button class="searchBtn">검색</button>
	</div>
</article>
<!-- 필터 결과  -->
<article class="Lodge-Result-List"></article>
<!-- 숙소 내용 --> 
</main>

<script>


function showList(){
	
	$.ajax({  
          type:'GET',
      	  url : '${cpath}/lodge/getRandomList',
          contentType : 'application/json',  
          success:function(resp) { 
			const LodgeResultList = document.querySelector(".Lodge-Result-List");  
			
        	resp.forEach(e=>{
        		

        		const urlText = e.lodge_realimgname;
        		const InfoBox = document.createElement('div');  
        		InfoBox.className = "Lodge-List-InfoBox";  
			
        		const a = document.createElement('a');  
        		a.style.position = "relative";  
    			a.href= "${cpath}/lodge/LodgeRoom/"+e.lodge_idx;
        		a.style.width = "560px";  
        		a.style.height = "300px";  
        		a.style.display = "inline-block"  
        			a.style.zIndex = 1;  
  		
        		const img = document.createElement('img');  
        		img.src = urlText;  
        		img.style.width = "560px";  
        		img.style.height = "300px";  

        		const TextWrapper = document.createElement('div');  
        		TextWrapper.style.background = "linear-gradient(to bottom, rgba(255,255,255,0) 56%,rgba(0,0,0,0.75) 90%)";  
        		TextWrapper.style.position = "absolute";  
        		TextWrapper.style.width = "100.3%";  
        		TextWrapper.style.top = "0";  
        		TextWrapper.style.bottom = "-4px";  
        		TextWrapper.style.left = "0";  
        		TextWrapper.style.right = "-4px";  
        		TextWrapper.style.color = "white";  

        		const Name = document.createElement('div');  
        		Name.className = "Lodge-Info-Name";  
        		Name.innerText = e.lodge_name;  

        		const Rate = document.createElement('div');  
        		Rate.className = "Lodge-Info-Rate";  
        		Rate.innerText = e.lodge_rate+'.0 점';  

        		const Address = document.createElement('div');  
        		Address.className = "Lodge-Info-Address";  
        		Address.innerText = e.lodge_address;  

        		TextWrapper.appendChild(Name);  
        		TextWrapper.appendChild(Rate);  
        		TextWrapper.appendChild(Address);  
			
        		a.appendChild(img)  
        		a.appendChild(TextWrapper)  
  		
        		InfoBox.appendChild(a);  

        		LodgeResultList.appendChild(InfoBox);  

        	})  
  	  
          }  
  	
    
      })
}
	



    document.addEventListener("DOMContentLoaded", function() {

		showList();
		/* 초기화 버튼*/
      const ResetBtn = document.querySelector('.ResetBtn');
		/* 적용 버튼*/
      const ApplyBtn = document.querySelector('.ApplyBtn');
		/* 지역 필터 체크 결과 담는 변수 (리스트) */
      const AreaCheckBoxs = document.querySelectorAll('div.LocationFilter .form-check-input');
		/* 유형 필터 체크 결과 담는 변수 (리스트) */
		const TypeCheckBoxs = document.querySelectorAll('div.TypeFilter .form-check-input');
		/*  각  */
		const result = [];
      const LodgeResultList = document.querySelector(".Lodge-Result-List");

      AreaCheckBoxs.forEach(e=> e.checked=false)
      TypeCheckBoxs.forEach(e=> e.checked = false);
	
 
		/*초기화 버튼*/
      ResetBtnHanlder = function(event) {
          AreaCheckBoxs.forEach(e=> e.checked=false)
          TypeCheckBoxs.forEach(e=> e.checked = false);
      };
      let areaArr = [];  
      let typeArr = [];  
      

		/* 시간 변화 체크*/
      const getStartDate = document.querySelector('#startDate');
			let startDate = null;
		const timeHandler = function(event){
			startDate = event.target.value;
		};

		getStartDate.addEventListener('change',timeHandler);

		const getEndDate = document.querySelector('#endDate');
		let endDate = null;

		const timeHandler2 = function(event){
			endDate = event.target.value;

		};

		getEndDate.addEventListener('change',timeHandler2);
     /* 각 체크버튼을 누를경우 배열에 지역값이 담김 */
      ApplyBtnBtnHanlder= function(event) {
          AreaCheckBoxs.forEach(e=> {
              if(e.checked===true){
                  areaArr.push(e.nextElementSibling.innerText)
              }
          })

		/* 각 체크버튼 누를경우 배열에 숙소 유형값이 담김*/
          TypeCheckBoxs.forEach(e =>{
              if(e.checked === true){
                  typeArr.push(e.nextElementSibling.innerText)
              }
          })


          LodgeResultList.innerHTML=``;

  	function isEndDateBeforeStartDate(startDate, endDate) {
	   const startDateObj = new Date(startDate);
	   const endDateObj = new Date(endDate);
	   return endDateObj < startDateObj;
	};

    if(startDate && endDate && areaArr && areaArr.length>0 & !isEndDateBeforeStartDate(startDate, endDate)){
      $.ajax({
          type:'POST',
        url : '${cpath}/lodge/getSelectedList',
          data : JSON.stringify({ areaArr: areaArr, typeArr: typeArr ,startDate:startDate , endDate:endDate}),
          contentType : 'application/json',
          success:function(resp) {
        	  if(resp.length==0){
        		swal('검색결과 없음','죄송합니다 일치하는 데이터가 없습니다.','error')

        	  }
        	resp.forEach(e=>{

        		const urlText = e.lodge_realimgname;


        		const InfoBox = document.createElement('div');
        		InfoBox.className = "Lodge-List-InfoBox";
        		InfoBox.style.position = "relative";

        		const a = document.createElement('a');
      		a.href= "${cpath}/lodge/LodgeRoom/"+e.lodge_idx;
        		a.style.width = "560px";
        		a.style.height = "300px";
        		a.style.display = "inline-block"

        		const img = document.createElement('img');
        		img.src = urlText;
        		img.style.width = "560px";
        		img.style.height = "300px";

        		const TextWrapper = document.createElement('div');
        		TextWrapper.style.background = "linear-gradient(to bottom, rgba(255,255,255,0) 56%,rgba(0,0,0,0.75) 90%)";
        		TextWrapper.style.position = "absolute";
        		TextWrapper.style.width = "100.3%";
        		TextWrapper.style.top = "0";
        		TextWrapper.style.bottom = "-4px";
        		TextWrapper.style.left = "0";
        		TextWrapper.style.right = "-4px";
        		TextWrapper.style.color = "white";

        		const Name = document.createElement('div');
        		Name.className = "Lodge-Info-Name";
        		Name.innerText = e.lodge_name;

        		const Rate = document.createElement('div');
        		Rate.className = "Lodge-Info-Rate";
        		Rate.innerText = e.lodge_rate+'.0 점';

        		const Address = document.createElement('div');
        		Address.className = "Lodge-Info-Address";
        		Address.innerText = e.lodge_address;


        		TextWrapper.appendChild(Name);
        		TextWrapper.appendChild(Rate);
        		TextWrapper.appendChild(Address);

        		a.appendChild(img)
        		a.appendChild(TextWrapper)

        		InfoBox.appendChild(a);



        		LodgeResultList.appendChild(InfoBox);




        	})

          }


      })
    }else{

    	if( areaArr.length==0  && (startDate==null || endDate==null) || (startDate==''|| endDate=='') ){
    		swal('날짜와 지역 미 선택','필터에서 날짜와 지역을 선택해주세요.','warning')
    	}else if( areaArr.length==0){
    		swal('지역 미 선택','지역을 지정해주세요.','warning')
    	}else if((startDate==null || endDate==null) || (startDate==''|| endDate=='')){
    		swal('날짜 미선택','날자를 지정해주세요.','warning')
    	}else{
    	swal('필터 미선택','날짜와 지역을 지정해주세요. 종료일이 시작일보다 빠르면 검색할 수 없습니다.','warning')
    	}



    	showList();
    };
      	  areaArr=[];
          typeArr=[];


      };
	

     ResetBtn.addEventListener('click',ResetBtnHanlder)
     ApplyBtn.addEventListener('click',ApplyBtnBtnHanlder)

    });  



	const startDate = document.getElementById('startDate');
	const endDate = document.getElementById('startDate');
	


	
	let searchText  = document.querySelector('.searchText')
	const searchBtn = document.querySelector('.searchBtn')
	
	function searchEnter(event) {
		let keyword = searchText.value
		console.log(event)
		if(keyword != ''){
	          $.ajax({  
	              type:'POST',  
	            url : '${cpath}/lodge/getSelectKeywordList' + '?keyword=' + keyword,
	              data : JSON.stringify(),  
	              contentType : 'application/json',  
	              success:function(resp) {  
	            		let LodgeResultList = document.querySelector('.Lodge-Result-List');
	            		LodgeResultList.innerHTML = '';
	            		if(resp.length==0){
	                		swal('검색결과 없음','죄송합니다 일치하는 데이터가 없습니다.','error')
	                		event.preventDefault();
	                	  }
	            		resp.forEach(e=>{  
	            		
	            		const urlText = e.lodge_realimgname;  
	        			
					
	            		const InfoBox = document.createElement('div');  
	            		InfoBox.className = "Lodge-List-InfoBox";  
	            		InfoBox.style.position = "relative";  

	            		const a = document.createElement('a');  
	          		a.href= "${cpath}/lodge/LodgeRoom/"+e.lodge_idx;
	            		a.style.width = "560px";  
	            		a.style.height = "300px";  
	            		a.style.display = "inline-block"  
	        		
	            		const img = document.createElement('img');  
	            		img.src = urlText;  
	            		img.style.width = "560px";  
	            		img.style.height = "300px";  

	            		const TextWrapper = document.createElement('div');  
	            		TextWrapper.style.background = "linear-gradient(to bottom, rgba(255,255,255,0) 56%,rgba(0,0,0,0.75) 90%)";  
	            		TextWrapper.style.position = "absolute";  
	            		TextWrapper.style.width = "100.3%";  
	            		TextWrapper.style.top = "0";  
	            		TextWrapper.style.bottom = "-4px";  
	            		TextWrapper.style.left = "0";  
	            		TextWrapper.style.right = "-4px";  
	            		TextWrapper.style.color = "white";  

	            		const Name = document.createElement('div');  
	            		Name.className = "Lodge-Info-Name";  
	            		Name.innerText = e.lodge_name;  

	            		const Rate = document.createElement('div');  
	            		Rate.className = "Lodge-Info-Rate";  
	            		Rate.innerText = e.lodge_rate+'.0 점';  

	            		const Address = document.createElement('div');  
	            		Address.className = "Lodge-Info-Address";  
	            		Address.innerText = e.lodge_address;  


	            		TextWrapper.appendChild(Name);  
		        		TextWrapper.appendChild(Rate);  
		        		TextWrapper.appendChild(Address);  
					
		        		a.appendChild(img)  
		        		a.appendChild(TextWrapper)  
	        		
		        		InfoBox.appendChild(a);  
		        		LodgeResultList.appendChild(InfoBox);
	            	
	        		
						
	            	})  
	        	  
	              }
	        	
	          
	          })
	        } else {
	        	swal('검색어 없음','검색어를 입력해 주세요','error')
	        }
	}
	
	searchBtn.onclick = function() {
		let keyword = searchText.value
		if(keyword != ''){
	          $.ajax({  
	              type:'POST',  
	            url : '${cpath}/lodge/getSelectKeywordList' + '?keyword=' + keyword,
	              data : JSON.stringify(),  
	              contentType : 'application/json',  
	              success:function(resp) {  
	            		let LodgeResultList = document.querySelector('.Lodge-Result-List');
	            		LodgeResultList.innerHTML = '';
	            		if(resp.length==0){
	                		swal('검색결과 없음','죄송합니다 일치하는 데이터가 없습니다.','error')
	                	  }
	            	resp.forEach(e=>{  
						
	            		
	            		const urlText = e.lodge_realimgname;  
	        			
					
	            		const InfoBox = document.createElement('div');  
	            		InfoBox.className = "Lodge-List-InfoBox";  
	            		InfoBox.style.position = "relative";  

	            		const a = document.createElement('a');  
	          		a.href= "${cpath}/lodge/LodgeRoom/"+e.lodge_idx;
	            		a.style.width = "560px";  
	            		a.style.height = "300px";  
	            		a.style.display = "inline-block"  
	        		
	            		const img = document.createElement('img');  
	            		img.src = urlText;  
	            		img.style.width = "560px";  
	            		img.style.height = "300px";  

	            		const TextWrapper = document.createElement('div');  
	            		TextWrapper.style.background = "linear-gradient(to bottom, rgba(255,255,255,0) 56%,rgba(0,0,0,0.75) 90%)";  
	            		TextWrapper.style.position = "absolute";  
	            		TextWrapper.style.width = "100.3%";  
	            		TextWrapper.style.top = "0";  
	            		TextWrapper.style.bottom = "-4px";  
	            		TextWrapper.style.left = "0";  
	            		TextWrapper.style.right = "-4px";  
	            		TextWrapper.style.color = "white";  

	            		const Name = document.createElement('div');  
	            		Name.className = "Lodge-Info-Name";  
	            		Name.innerText = e.lodge_name;  

	            		const Rate = document.createElement('div');  
	            		Rate.className = "Lodge-Info-Rate";  
	            		Rate.innerText = e.lodge_rate+'.0 점';  

	            		const Address = document.createElement('div');  
	            		Address.className = "Lodge-Info-Address";  
	            		Address.innerText = e.lodge_address;  


	            		TextWrapper.appendChild(Name);  
		        		TextWrapper.appendChild(Rate);  
		        		TextWrapper.appendChild(Address);  
					
		        		a.appendChild(img)  
		        		a.appendChild(TextWrapper)  
	        		
		        		InfoBox.appendChild(a);  
		        		LodgeResultList.appendChild(InfoBox);
	            	
	        		
						
	            	})  
	        	  
	              }
	        	
	          
	          })
	        } else {
	        	swal('검색어 없음','검색어를 입력해주세요','error')
	        }
		
	}
	
	/* 일정 크기 이하로 윈도우 창이 줄어들면 필터를 숨김*/
	// aside 요소와 일정 크기 이하의 임계값 정의
	const asideElement = document.querySelector("aside");
	const minWidthThreshold = 1600; 

	function handleResize() {
	  const windowWidth = window.innerWidth;

	  if (windowWidth <= minWidthThreshold) {
	    // 윈도우 너비가 임계값 이하일 때
	    asideElement.style.display = "none";
	  } else {
	    // 윈도우 너비가 임계값보다 큰 경우
	    asideElement.style.display = "block"; // 또는 다른 원하는 스타일을 적용
	  }
	}

	// 초기 리사이즈 처리
	handleResize();

	// 윈도우 크기가 변경될 때마다 resize 이벤트 핸들러 호출
	window.addEventListener("resize", handleResize);
	
	
	
</script>
</body>
</html>