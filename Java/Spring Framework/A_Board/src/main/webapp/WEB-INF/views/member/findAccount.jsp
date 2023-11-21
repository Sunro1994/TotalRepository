<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<fieldset>
		<legend>아이디 찾기</legend>
		아이디가 기억나지 않는 경우 먼저 수행해주세요.
		<form method="POST" action="${cpath}/member/findID">
			<p><input type="text" name="username" placeholder="이름을 입력"></p>
			<p><input type="text" name="email" placeholder="이름을 입력"></p>
			<p><input type="submit">
			</form>
		<c:if test="${userid!=null}">
			찾으시는 아이디는 ${userid} 입니다.
		</c:if>
	</fieldset>
	<fieldset>
		<legend>질문으로 찾기</legend>
		아이디를 알고 있고 질문을 통해 찾으려고 하는 경우 입력해주세요.<br>
		<c:if test="${question==null }">
		<form method="POST" action="${cpath}/member/findPWByQuestion">
			<p><input type="text" name="userid" placeholder="ID를 입력"></p>
			<p><input type="submit">
		</form>
		</c:if>
		<c:if test="${question!=null }">
		${question}?
			<form method="POST" action="${cpath}/member/getNewPassword">
				<p><input type="hidden" name="userid" value="${userInfo }"></p>
				<p><input type="text" name="findAnswer" placeholder="정답을 입력하세요" >
				<p><input type="submit"></p>
			</form>
		</c:if>
	</fieldset>
	
</body>

<script>
	const newPW = '${newPW}';
	console.log(newPW)
	if(newPW!='')
		{
		alert('귀하의 새로운 비밀번호는 ${newPW} 입니다.')
		}
</script>

</html>