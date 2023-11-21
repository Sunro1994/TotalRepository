<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	
<script>
	//아래에서 사용할 함수 정의하기
	
	//이름 변경 함수
	function renameHandler(){
		//문서에서 input[type="file"]인 모든 요소를 불러와서 그 각각을 e고 순번을 i라고 할 때
		// e => 요소 i => 인덱스
		document.querySelectorAll('input[type="file"]').forEach(function (e,i) {
		// e의 name속성에 문자열을 대입한다.
			e.name= 'upload['+i+']';
		});
	}
	//x를 클릭하면 대상을 삭제한다
	function deleteHalndler(event){
		//문서에서 div id="files" 요소를 불러온다
		const files = document.getElementById('files');
		// 클릭의 대상(event.target)의 상위요소(p)를 불러온다
		const p = event.target.parentNode;
		//div id ="files"에서 지정한 p를 제거한다
		files.removeChild(p);
		
		//제거되고 나면 이름이 안맞기 때문에 처음부터 이름을 다시 설정하는 renameHnadler를 호출하여 실행한다
		renameHandler();
	}
	function addHandler(event) {
		// files요소를 불러온다 (files안에 새로운 p를 추가하기 위해서)
		const files= document.getElementById('files')
		const p = document.createElement('p');	//p태그를 하나 생성한다(문서에는 반영 안됨)
		
		//input 요소를 하나 생성하고, type="file", name, required 속성을 지정한다
		const input_file = document.createElement('input');
		input_file.type='file'
		input_file.required = 'required';
		
		
		//input 요소를 하나 생성하고, type="button", Classname, value속성을 지정한다
		const input_button = document.createElement('input');
		input_button.type='button'
		input_button.className='deleteBtn'
		input_button.value='X'
		input_button.onclick = deleteHalndler
		//appendChild는 내부가 초기화 되지 않는다.
		// 문서의 files요소에 방금 생성한 요소p(내부에는 input이 추가되어 있음)를 추가하여 문서에 반영한다
		p.appendChild(input_file)
		p.appendChild(input_button)
		files.appendChild(p)
		
		renameHandler()// 이름 지정함수가 이미 만들어져 있으니 호출
		
		
		
		
		
// 		files.innerHTML += tag;
		
	}
	
</script>



	<form method="POST" enctype="multipart/form-data">
		<div id ="files">
			<p>
			<input type="file" name="upload[0]" required>
			</p>
		</div>
		<input type="button" value="파일추가" id="addBtn">
		<p><input type="text" name ="title" placeholder="title">
		<p><input type="submit" >
	</form>
</body>

<script>
	//문서가 불러와지면 곧바로 추가버튼에 대한 이벤트를 등록
	const addBtn = document.getElementById('addBtn');
	
	//addHandler는 위쪽에서 이미 정의되어 있다. addBtn을 클릭하면 실행되는 함수로 addHandler를 지정한다
	addBtn.onclick = addHandler
	
	
	
</script>
</html>