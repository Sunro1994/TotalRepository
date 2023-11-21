<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<form method="post">
		<input type="submit" name="num" value="1">
		<input type="submit" name="num" value="2">
		<input type="submit" name="num" value="3">
		<input type="submit" name="num" value="+">
		<input type="submit" name="num" value="-">
		<input type="submit" name="num" value="=">
		<input type="submit" name="num" value="CE">
	</form>
	<%! String exp = ""; %>
	<%
		int result =0;
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
			String num = request.getParameter("num");
			if("CE".equals(num)){
				exp="";
				return;
			}
			if("=".equals(num)&& exp.length()>=3 && exp.contains("+") || exp.contains("-")){
				out.print(exp.split("+")[0]);
			out.print(exp.split("+")[1]);
			}
			
			exp += "" + num + "";
	%>
	<h3><%=num %></h3>
	<h3><%=exp %></h3>
	<%
	}
	%>
</body>
</html>