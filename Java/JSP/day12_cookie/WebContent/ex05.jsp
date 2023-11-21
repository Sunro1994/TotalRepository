<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex05.jsp</title>
</head>
<body>

<h1>ex05.jsp</h1>
<hr>

<h3>쿠키를 활용한 팝업창 처리</h3>

<p>쿠키 : ${cookie.doNotPopup.value }</p>

<script>
	const doNotPopup = '${cookie.doNotPopup.value }'
	
	function openPopup() {
		let options = 'top=50, left=50, width=500, height=400,'
		options += 'status=no, menubar=no, toolbar=no, resizable=no'
		const url = 'ex05-popup.jsp'
		window.open(url, '공지사항', options)
	}
	
	if(doNotPopup != 'on') {
		openPopup()
	}
</script>

</body>
</html>







