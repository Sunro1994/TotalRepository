<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
		
		
		out.print("<h4>job : ");
		for(int i=0;arr!=null&&i<arr.length;i++){
			out.print(arr[i]);
			out.print(i==arr.length-1? "</h4>" : ",");
		}
	%>

</body>

<h4>job : <%=job %></h4>
</html>