<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<String> list = (ArrayList<String>)application.getAttribute("list");
	
	if(list==null) {
		list = new ArrayList();
		application.setAttribute("list", list);
	}
	
	for(int i=0; i<list.size(); i++){
		String s = list.get(i);%>
		<div><a href="view.jsp?i=<%=i%>"><%=i %>) <%=s %></a></div>
	<%
	}
%>
<form method="POST" action="list-add.jsp" >
	<p><input type="text" name="param" placeholder="추가할 이름 입력"></p>
	<input type="submit" value="추가"> 
</form>


</body>
</html>