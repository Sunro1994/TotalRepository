<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


<c:if test="${not empty sessionScope.login }">
	<c:redirect url="/board/list.jsp"/>
</c:if>

<div class="container">
	<form action="${cpath }/member/login-action.jsp" method="POST">
		<div class="mb-3 mt-3">
			<label for="userid" class="form-label">ID :</label> <input
				type="text" class="form-control" id="userid"
				placeholder="Enter Userid" name="userid" value="${cookie.userid.value }">
		</div>
		<div class="mb-3">
			<label for="userpw" class="form-label">Password:</label> <input
				type="password" class="form-control" id="userpw"
				placeholder="Enter password" name="userpw">
		</div>
		<div class="form-check mb-3">
			<label class="form-check-label"> <input
				class="form-check-input" type="checkbox" name="storeId" ${empty cookie.userid.value ? '' : 'checked'}>
				아이디 기억하기
			</label>
		</div>
		<div class="form-check mb-3">
			<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="autologin">
					자동 로그인
			</label>
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
		<button class="btn btn-primary" type="button" onclick="javascript:history.go(-1)">돌아가기</button>
	</form>
</div>

</body>
</html>