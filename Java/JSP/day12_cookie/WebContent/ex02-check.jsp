<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-check.jsp</title>
</head>
<body>
<h1>ex02-check.jsp</h1>
<hr>
<p>
	<a href="ex02-form.jsp"><button>다시 입력하러 가기</button></a>
	<a href="ex02-delete.jsp"><button>쿠키 삭제하기</button></a>
</p>
<fieldset>
	<legend>자바 코드로 쿠키 확인하기</legend>
	<%
		// 요청에 같이 보내진 쿠키들을 배열형태로 정리한다
		Cookie[] cookies = request.getCookies();
	
		// 값을 저장한 후 출력하기 위한 문자열 변수
		String value = null;
		
		// 첫번째 방문시에는 쿠키가 없다. 따라서 배열이 null이면 반복문을 수행하지 않도록 처리해야 한다
		for(int i = 0; cookies != null && i < cookies.length; i++) {
			Cookie c = cookies[i];	// i번째 쿠키를 저장한다
			if(c.getName().equals("memo")) {	// 이름이 일치하는 쿠키를 찾았다면
				value = c.getValue();			// 미리 준비한 문자열 변수에 값을 저장한다
			}
		}
		out.print("<h3>cookie : " + value + "</h3>");
	%>
</fieldset>
<br>

<fieldset>
	<legend>자바스크립트로 쿠키 확인하기</legend>
	<button id="checkCookie">쿠키 확인</button>
	<script>
		const checkCookie = document.getElementById('checkCookie')
		checkCookie.onclick = function() {
			const cookie = document.cookie	// 쿠키 확인 코드
			alert(cookie)
		}
	</script>
</fieldset>
<br>

<fieldset>
	<legend>EL Tag로 쿠키 확인하기</legend>
	<h3>cookie : ${cookie.memo.value }</h3>
</fieldset>



</body>
</html>










