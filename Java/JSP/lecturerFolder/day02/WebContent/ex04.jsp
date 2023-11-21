<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex04.jsp</title>
</head>
<body>

<h1>ex04.jsp - 여러 파라미터를 모두 출력하기</h1>
<hr>

<form method="POST">
	<p><input type="text" name="title" placeholder="영화제목"></p>
	<p><input type="date" name="release"></p>
	<p><input type="number" name="runningTime" placeholder="상영시간"></p>
	<p>
		<input type="text" name="starring" placeholder="배우1">
		<input type="text" name="starring" placeholder="배우2">
		<input type="text" name="starring" placeholder="배우3">
	</p>	
	<p><input type="submit" value="제출"></p>
</form>
<%@ page import="java.util.Map, java.util.Set" %>
<%
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("UTF-8");
		
		Map<String, String[]> map = request.getParameterMap();
		
		Set<String> keySet = map.keySet();
		
		for(String key : keySet) {
			String[] values = map.get(key);
			out.print("<h4>" + key + " : ");
			for(int i = 0; i < values.length; i++) {
				String value = values[i];
				out.print(value);
				out.print(i == values.length - 1 ? "</h4>" : ", ");
			}
		}
	}
%>

</body>
</html>








