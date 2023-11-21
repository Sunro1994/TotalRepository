<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header.jsp" %>


	<p><a href="${cpath}/ex01"><button>ex01- 회원가입 구현(hash적용)</button></a>
	<p><a href="${cpath}/ex02"><button>ex02- 로그인 확인(비밀번호+salt)</button></a>
	<p><a href="${cpath}/ex03"><button>ex03- 비밀번호 재발급</button></a>
	<p><a href="${cpath}/ex04"><button>ex04- 비밀번호 변경(로그인 전용)</button></a>

	<fieldset>
		<legend>hash test</legend>
		<form method="POST" >
		<p><input type="text" name="source" placeholder="source" autofocus></p>
		<p><input type="text" name="salt" placeholder="salt" ></p>
		<p><input type="submit"></p>
		</form>
		<c:if test="${not empty hash }">
		<h3>source: ${param.source }</h3>
			<h3>hash: ${hash }</h3>
			<h3>salt :${salt }</h3>
		</c:if>
	</fieldset >


</body>
</html>