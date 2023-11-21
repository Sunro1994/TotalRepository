<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*, board.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="memberDAO" value="${MemberDAO.getInstance() }" />
<c:set var="boardDAO" value="${BoardDAO.getInstance() }"/>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
	
<meta charset="UTF-8">
<title>아이디 중복체크</title>
</head>
<body>
	<div class="container">
		<c:set var="userid" value="${param.userid }"/>
		<c:set var="isOK" value="${memberDAO.checkId(userid) }"/>
		<c:if test="${isOK }">
			<p class="text-primary">${userid }는 <span style="color:blue;">사용가능한 아이디</span>입니다.</p>
			<p><button class="use btn btn-primary"class="btn btn-primary" onclick="opener.parent.decide(); window.close();">사용하기</button>
        	
		</c:if>
		<c:if test="${!isOK }">
			<p class="text-danger">${userid }는 <span style="color:red">이미 있는 아이디</span>입니다.</p>
			<p><button class="close btn btn-danger"   type="button" onclick="opener.parent.change(); window.close()">다른 ID사용</button>
		</c:if>
		<button class="close btn btn-warning" type="button" onclick="window.close()">돌아가기</button></p>
	</div>
</body>
</html>