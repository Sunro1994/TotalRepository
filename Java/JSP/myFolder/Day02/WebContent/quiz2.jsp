<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.hidden{
		display:none;
	}
</style>
</head>
<body>

	<%-- 아래 form의 양식을 화면에 한 줄씩 출력하도록 코드를 작성하세요 --%>
	<form method="POST"  >
		<p><input type="text" name="id" placeholder="ID" required autofocus></p>
		<p><input type="password" name="pw" placeholder="PW" required ></p>
		<p><input type="text" name="name" placeholder="Name" required ></p>
		<p><input type="date" name="birth" placeholder="Name" required ></p>
		<p>
			<%--radio는 하나만 선택이 가능하다. select도 동일 --%>
			<label><input type="radio" name="gender" value="남성" required >남</label>
			<label><input type="radio" name="gender" value="여성" required >여</label>
		</p>
		<p>
			<select name="age" required>
				<option value="">===연령대를 선택하세요===</option>
				<option value="10대">10대</option>
				<option value="20대">20대</option>
				<option value="30대">30대</option>
				<option value="40대">40대</option>
			</select>
		</p>
		<p><input type="submit"  value="가입신청"></p>
	</form>
	
	<%if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("UTF-8");
		String ID = request.getParameter("id");
		String PW = request.getParameter("pw");
		String name = request.getParameter("name");
		String date = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");

	%>
	
	<h3>아이디 : <%=ID %></h3>
	<h3>비밀번호 : <%=PW %></h3>
	<h3>이름 : <%=name %></h3>
	<h3>생일 : <%=date %></h3>
	<h3>성별 : <%=gender %></h3>
	<h3>나이 : <%=age %></h3>

	<%} %>
	
	<script>
		const form = document.querySelector('form');
		const button = document.querySelector('input[type="submit"]')
		console.log(button);
		function hide(event) {
			event.preventDefault();
			form.classList.add('hidden');
			console.log('click');
		}
		button.addEventListener('click',hide);
		
	</script>
	
</body>
</html>