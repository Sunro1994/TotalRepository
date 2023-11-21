<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex06-result.jsp</title>
</head>
<body>

<h1>ex06-result.jsp</h1>
<hr>

<%-- 1) request에 데이터가 담겨 있으니, 굳이 배열을 불러오지 않아도 된다 --%>
<marquee direction="down" behavior="slide">
	<marquee direction="up" behavior="slide">
		<p style="font-size: 100px; margin: 0 auto">
			<%=request.getAttribute("data") %>
		</p>
	</marquee>
</marquee>

<p><a href="ex06-list.jsp"><button>다시 목록으로</button></a></p>





</body>
</html>