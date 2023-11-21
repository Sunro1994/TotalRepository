<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.*, member.*"%>
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

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>BLOG</title>
</head>
<body>
<style>
	a {
		text-decoration: none;
	}
	
	a:hover{
		text-decoration: underline;
	}
	
	.hidden {
		display: none;
	}
</style>
<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link active" href="${cpath }">BLOG</a>
      </li>
      <c:if test="${empty login }">
	      <li class="nav-item">
	        <a class="nav-link" href="${cpath }/member/login.jsp">로그인</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${cpath }/member/join.jsp">회원가입</a>
	      </li>
      </c:if>
      <c:if test="${not empty login }">
      	<li class="nav-item">
	        <a class="nav-link" href="${cpath }/member/logout.jsp">로그아웃</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${cpath }/board/write.jsp">글쓰기</a>
	      </li>
	       <li class="nav-item">
	        <a class="nav-link" href="${cpath }/member/myPage.jsp">내 정보</a>
	      </li>
      </c:if>
      <li class="nav-item">
        <a class="nav-link" href="${cpath }/board/list.jsp">게시판</a>
      </li>
    </ul>
     <form class="d-flex" action="${cpath }/board/list.jsp" method="POST">
        <input class="form-control me-2" type="text" id="keyword" name="keyword" placeholder="Search">
        <button class="btn btn-primary" type="submit">search</button>
      </form>
  </div>
</nav>

