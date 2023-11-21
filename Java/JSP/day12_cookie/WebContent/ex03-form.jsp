<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03-form.jsp</title>
</head>
<body>

<h1>ex03-form.jsp</h1>
<hr>

<h3>쿠키를 활용할 때 띄어쓰기 및 특문 처리</h3>
<%
	String value = "";
	Cookie[] cookies = request.getCookies();
	for(int i = 0; cookies != null && i < cookies.length; i++) {
		if(cookies[i].getName().equals("memo")) {
			value = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
		}
	}
%>
<form method="POST">
	<p><input type="text" name="memo" 
			  placeholder="내용을 입력하세요" value="<%=value %>" required></p>
	<p><input type="submit"></p>
</form>
<h3>현재 쿠키 값 : <%=value %></h3>
<h3>실제 쿠키 값 : ${cookie.memo.value }</h3>
<%@ page import="java.net.URLEncoder, java.net.URLDecoder" %>
<%
	request.setCharacterEncoding("UTF-8");

	String memo = request.getParameter("memo");
	if(memo != null) {
		Cookie c = new Cookie("memo", URLEncoder.encode(memo, "UTF-8"));
		c.setMaxAge(600);
		response.addCookie(c);
		response.sendRedirect("ex03-form.jsp");
	}
%>

<%
	String a = "root:x:0:0:root:/root:/bin/bash";
	String[] arr = a.split(":");
	for(String s : arr) {
		System.out.println(s);
	}
%>

</body>
</html>



