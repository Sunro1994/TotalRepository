<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../allUsedHeader.jsp"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${cpath}/css/main_css/recommend_travel_view.css" type="text/css">
<link rel="stylesheet" href="${cpath }/css/main_css/lodge.css"
	type="text/css">
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"/>
<script type="text/javascript"	src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript"	src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />



<script>
    	window.onload = function(){  
    		$.ajax({  
    	          type:'POST',  
  	          	  url : '${cpath}/lodge/getRandomList',
    	          contentType : 'application/json',  
    	          success:function(resp) { 
    	        	  console.log('resp : ' , resp);
    				const LodgeResultList = document.querySelector(".Lodge-Result-List");   
    	        	resp.forEach(e=>{  

    	        		const urlText = e.lodge_realimgname;
    	        		const InfoBox = document.createElement('div');  
    	        		InfoBox.className = "Lodge-List-InfoBox";  
					
    	        		const a = document.createElement('a');  
    	        		a.style.position = "relative";  
  	        			a.href= "${cpath}/Lodge/LodgeRoom/"+e.lodge_idx;
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
    	        		TextWrapper.style.width = "110%";  
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
		
    	};  
	
	
	
	
      $(function() {  
          $('input[name="daterange"]').daterangepicker({  
            opens: 'left'  
          }, function(start, end, label) {  
            console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));  
          });  
        });  

        document.addEventListener("DOMContentLoaded", function() {  
          const ResetBtn = document.querySelector('.ResetBtn');  
          const ApplyBtn = document.querySelector('.ApplyBtn');  
          const AreaCheckBoxs = document.querySelectorAll('div.LocationFilter .form-check-input');  
          const TypeCheckBoxs = document.querySelectorAll('div.TypeFilter .form-check-input');  
          const result = [];  
          const LodgeResultList = document.querySelector(".Lodge-Result-List");  
     
 
          ResetBtnHanlder = function(event) {  
              AreaCheckBoxs.forEach(e=> e.checked=false)  
          };  
          let areaArr = [];  
          let typeArr = [];  
          ApplyBtnBtnHanlder= function(event) {  
              AreaCheckBoxs.forEach(e=> {  
                  if(e.checked==true){  
                      console.log(e.nextElementSibling.innerText)  
                      areaArr.push(e.nextElementSibling.innerText)  
                  }  
              })  
          
              TypeCheckBoxs.forEach(e =>{  
                  if(e.checked == true){  
                      console.log(e.nextElementSibling.innerText)  
                      typeArr.push(e.nextElementSibling.innerText)  
                  }  
              })  
         
              console.log(typeArr)  
              console.log(areaArr)  
              LodgeResultList.innerHTML=``;  
          $.ajax({  
              type:'POST',  
            url : '${cpath}/lodge/getSelectedList',
              data : JSON.stringify({ areaArr: areaArr, typeArr: typeArr }),  
              contentType : 'application/json',  
              success:function(resp) {  
            	resp.forEach(e=>{  

            		const urlText = e.lodge_realimgname;  
        		
				
            		const InfoBox = document.createElement('div');  
            		InfoBox.className = "Lodge-List-InfoBox";  
            		InfoBox.style.position = "relative";  

            		const a = document.createElement('a');  
          		a.href= "${cpath}/Lodge/LodgeRoom/"+e.lodge_idx;
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
            		TextWrapper.style.width = "110%";  
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
        		
            		InfoBox.appendChild(a);  
            		InfoBox.appendChild(TextWrapper);  

            		LodgeResultList.appendChild(InfoBox);  


        		
					
            	})  
        	  
              }  
        	
          
          })  
          	  areaArr=[];  
              typeArr=[];  
          
     
          };  
		

         ResetBtn.addEventListener('click',ResetBtnHanlder)  
         ApplyBtn.addEventListener('click',ApplyBtnBtnHanlder)  

        });  
    </script>


<aside class="Lodge-Filter">
	<div>
		<div class="DateFilterName">날짜</div>
		<input type="date" id="startDate" /> <input type="date" id="endDate" />
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
		<p>
		<div class="form-check TypeForm">

			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 11"> <label class="form-check-label"
					for="flexCheck 11"> 모텔 </label>
			</p>
			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 12"> <label class="form-check-label"
					for="flexCheck 12"> 호텔 </label>
			</p>
			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 13"> <label class="form-check-label"
					for="flexCheck 13"> 펜션 </label>
			</p>
			<p>
				<input class="form-check-input" type="checkbox" value=" "
					id="flexCheck 14"> <label class="form-check-label"
					for="flexCheck 14"> 캠핑 </label>
			</p>
		</div>
	</div>
</aside>
<!--필터-->
<main>
<article class="Lodge-Filter-Result">
	<div class="Result-Info-Box">총 100개의 결과가 검색되었습니다.</div>
</article>
<!-- 필터 결과  -->
<article class="Lodge-Result-List"></article>
<!-- 숙소 내용 --> </main>

</body>
</html>