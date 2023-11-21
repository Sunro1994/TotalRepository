<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
		<%-- 1) request에 데이터가 담겨 있으니, 굳이 배열을 불러오지 않아도 된다. --%>

	
	
	<marquee direction="down">
		<marquee direction="up">
			<p style="font-size:100px; margin: 0 auto"><%=request.getAttribute("data") %> </p>
		</marquee>
	</marquee>
	
	<p><a href="ex06-list.jsp"><button>목록으로</button></a>
</body>
</html>