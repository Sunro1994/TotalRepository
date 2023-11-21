<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz2.jsp</title>
</head>
<body>

<h1>quiz2.jsp</h1>
<hr>

<%
	if(request.getMethod().equals("GET")) {
		%>
		<%-- 아래 form의 양식을 화면에 한줄씩 출력하도록 코드를 작성하세요 --%>
		<form method="POST">
			<p><input type="text" name="id" placeholder="ID" required autofocus></p>
			<p><input type="password" name="pw" placeholder="Password" required></p>
			<p><input type="text" name="name" placeholder="Name" required></p>
			<p><input type="date" name="birth" required></p>
			<p>
				<label><input type="radio" name="gender" value="남성" required>남성</label>
				<label><input type="radio" name="gender" value="여성" required>여성</label>
			</p>
			<p>
				<select name="age" required>
					<option value="">=== 연령대를 선택하세요 ===</option>
					<option value="10대">10대</option>
					<option value="20대">20대</option>
					<option value="30대">30대</option>
					<option value="40대">40대</option>
				</select>
			</p>
			<p><input type="submit" value="가입신청"></p>
		</form>
		<%
	}
	else {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		
		%>
		<h4>id : <%=id %></h4>
		<h4>pw : <%=pw %></h4>
		<h4>name : <%=name %></h4>
		<h4>birth : <%=birth %></h4>
		<h4>gender : <%=gender %></h4>
		<h4>age : <%=age %></h4>
		<a href="quiz2.jsp"><button>뒤로가기</button></a>
		<%
	}
%>



</body>
</html>









