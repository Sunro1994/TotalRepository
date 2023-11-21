<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03.jsp</title>
</head>
<body>

<h1>ex03.jsp - 동시에 여러 값을 선택하여 제출하기</h1>
<hr>

<form method="POST">
	<h4>선호 직군을 선택하세요</h4>
	<p><label><input type="checkbox" name="job" value="back-end">back-end</label></p>
	<p><label><input type="checkbox" name="job" value="front-end">front-end</label></p>
	<p><label><input type="checkbox" name="job" value="DB">DB</label></p>
	<p><label><input type="checkbox" name="job" value="mobile">mobile</label></p>
	<p><label><input type="checkbox" name="job" value="system">system</label></p>
	<p><input type="submit" value="확인"></p>
</form>

<%
	String job = request.getParameter("job");
	String[] arr = request.getParameterValues("job");
	
	out.print("<h4>arr : ");
	for(int i = 0; arr != null && i < arr.length; i++) {
		out.print(arr[i]);
		out.print(i == arr.length - 1 ? "</h4>" : ", ");
	}
%>

<h4>job : <%=job %></h4>






</body>
</html>












