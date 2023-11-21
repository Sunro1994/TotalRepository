<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex04-theme.jsp</title>
<style>
	marquee {
		font-size: 20px;
		font-weight: bold;
		padding: 10px;
	}
	.white {
		background-color: white;
		color: black;
	}
	.dark {
		background-color: #aaa;
		color: #eee;
	}
	.black {
		background-color: black;
		color: white;
	}
	.warning {
		background-color: orangered;
		color: yellow;
	}
</style>
</head>
<body>

<h1>ex04-theme.jsp</h1>
<hr>

<h3>컬러 테마를 쿠키에 저장하고 적용하기</h3>

<c:set var="theme" value="${cookie.theme.value }" />

<form method="POST">
	<p>
		<select name="theme" required>
			<option value="">=== 색상 테마를 선택하세요 ===</option>
			<option ${theme == 'white' ? 'selected' : '' } value="white">화이트</option>
			<option ${theme == 'dark' ? 'selected' : '' } value="dark">다크</option>
			<option ${theme == 'black' ? 'selected' : '' } value="black">블랙</option>
			<option ${theme == 'warning' ? 'selected' : '' } value="warning">경고</option>
		</select>
		<input type="submit">
	</p>
</form>	

<%
	String theme = request.getParameter("theme");
	if(theme != null) {
		Cookie c = new Cookie("theme", theme);
		c.setMaxAge(-1);
		response.addCookie(c);
		response.sendRedirect(request.getRequestURL().toString());
		// 현재 주소를 리다이렉트 하도록 요청한다 (새로고침)
	}
%>

<fieldset>
	<legend>테스트 내용</legend>
	<marquee direction="up" scrollamount="2" class="${cookie.theme.value }">
	<pre>
아마 꿈만 같겠지만 분명 꿈이 아니야
달리 설명할 수 없는 이건 사랑일거야
방금 내가 말한 감정 감히 의심하지 마
그냥 좋다는 게 아냐 (what's after 'Like'?)
You and I
It's more than 'Like'
L 다음 또 O 다음 난 yeah, yeah, yeah
You and I
It's more than 'Like' (like)
What's after 'Like'?
What's after 'Like'?	
	</pre>
	</marquee>
</fieldset>

</body>
</html>






