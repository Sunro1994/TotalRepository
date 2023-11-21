<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String[] arr= {
			"이지은, 31, 여성",
			"홍진호,40,남성",
			"나단비,5,여성",
			"김희철,41,남성",
			"김지수,28,여성",
	};
%>

<form action="">
	<select name="index" required>		<!-- index라는 name의 값 하나만 전달받는 것, 5개가 아니다. -->
			<option value="">===번호를 입력하세요 ===</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
	</select>
	<input type="submit">
	
	<%
		String index = request.getParameter("index");
		String data = "";
	
		if(index != null) { //index값을 입력받았다면 
			int i = Integer.parseInt(index)-1;
			data = arr[i];
			%>
			<!-- 아래 h3태그들을 자바코드 밖에 두면 data=""이기 때문에 빈 배열을 split하려고 하고, 빈배열의 [0],[1],[2]를 찾으려하기 때문에 예외발생 -->
		<h3>이름: <%=data.split(",")[0] %></h3>
		<h3>나이: <%=data.split(",")[1] %>살</h3>
		<h3>성별: <%=data.split(",")[2] %></h3>
		<% 
	
			}
	%>
</form>
</body>
</html>