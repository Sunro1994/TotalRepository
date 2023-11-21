<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div class="container">
	<label for="userid" class="form-label ">ID :</label>
	<div class="input-group">
		<input type="text" id="checkuserid" class="form-control"
			placeholder="Enter Userid" required autocomplete="off" autofocus>
		<input type="button" id="Btncheckid" class="btn btn-success" onclick="checkUserId()" value="중복체크">
	</div>
	<div id="decide"><span style='color:red;'>아이디 중복여부를 확인해주세요.</span></div>

	<form action="${cpath }/member/join-action.jsp" method="POST">
		<div class="mb-3 hidden">
			<input
				type="text" class="form-control" id="decideduserid"
				placeholder="Enter Userid" name="userid" required readonly autocomplete="off">
		</div>
		<div class="mb-3 mt-3">
			<label for="userpw" class="form-label">Password:</label> <input
				type="password" class="form-control" id="userpw"
				placeholder="Enter password" name="userpw" required
				autocomplete="off">
		</div>

		<div class="mb-3">
			<label for="username" class="form-label">이름 :</label> <input
				type="text" class="form-control" id="username"
				placeholder="Enter username" name="username" required
				autocomplete="off">
		</div>

		<div class="mb-3">
			<label for="email" class="form-label">Email :</label> <input
				type="email" class="form-control" id="email"
				placeholder="Enter Email" name="email" required autocomplete="off">
		</div>

		<div class="mb-3">
			<label for="birth" class="form-label">생년월일 :</label> <input
				type="date" class="form-control" id="birth"
				placeholder="생년월일을 입력하세요" name="birth" required autocomplete="off">
		</div>

		<button type="submit" class="btn btn-primary" id="join" disabled>회원가입</button>
		<button class="btn btn-primary" type="button"
			onclick="javascript:history.go(-1)">돌아가기</button>
	</form>
</div>
<script>
function checkUserId() {
	let checkuserid = document.querySelector('#checkuserid').value;
	if(checkuserid) // userid으로 받음
	{
		url = '${cpath}/member/checkId.jsp?userid='+checkuserid;
		window.open(url,"chkusername","width=400,height=400");
	}else {
		alert('중복체크할 아이디를 입력하세요');
	}
}

function decide(){
	document.getElementById("decide").innerHTML = "<span style='color:blue;'>사용가능한 아이디입니다.</span>"
	document.getElementById("decideduserid").value = document.getElementById("checkuserid").value;
	document.getElementById("checkuserid").disabled = true;
	document.getElementById("Btncheckid").value = "다른 ID로 변경";
	document.getElementById("Btncheckid").setAttribute("onclick", "change()");
	document.getElementById("join").disabled=false;
}

function change(){
		document.getElementById("decide").innerHTML = "<span style='color:red;'>아이디 중복여부를 확인해주세요.</span>"
		document.getElementById("decideduserid").value = "";
		document.getElementById("checkuserid").disabled = false;
		document.getElementById("checkuserid").value="";
		document.getElementById("Btncheckid").value = "중복체크";
		document.getElementById("Btncheckid").setAttribute("onclick", "checkUserId()");
		document.getElementById("join").disabled=true;
}
</script>
</body>
</html>