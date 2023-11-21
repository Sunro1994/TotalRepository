<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:if test="${empty login }">
	<c:redirect url="/member/login.jsp" />
</c:if>

<div class="container">
		<form action="${cpath }/member/modify-action.jsp" method="POST">
		<div class="mb-3 mt-3">
			<label for="userid" class="form-label">ID :</label> <input
				type="text" class="form-control" id="userid"
				placeholder="Enter Userid" name="userid" value="${login.userid }" required autocomplete="off" autofocus readonly="readonly">
		</div>
		
		<div class="mb-3">
			<label for="userpw" class="form-label">Password:</label> <input
				type="password" class="form-control" id="userpw"
				placeholder="Enter password" value="${login.userpw }"name="userpw" required autocomplete="off">
		</div>
		
		<div class="mb-3">
			<label for="username" class="form-label">이름 :</label> <input
				type="text" class="form-control" id="username"
				placeholder="Enter username" value="${login.username }" name="username" required autocomplete="off">
		</div>
		
		<div class="mb-3">
			<label for="email" class="form-label">Email :</label> <input
				type="email" class="form-control" id="email"
				placeholder="Enter Email" value="${login.email }" name="email" required autocomplete="off">
		</div>
		
		<div class="mb-3">
			<label for="birth" class="form-label">생년월일 :</label> <input
				type="date" class="form-control" id="birth"
				placeholder="생년월일을 입력하세요" value="${login.birth }" name="birth" required autocomplete="off">
		</div>
		
		<button type="submit" class="btn btn-primary">정보수정</button>
		<a href="delete-action.jsp?userid=${login.userid }"><button class="btn btn-danger" type="button">회원탈퇴</button></a>
	</form>
	
</div>

</body>
</html>