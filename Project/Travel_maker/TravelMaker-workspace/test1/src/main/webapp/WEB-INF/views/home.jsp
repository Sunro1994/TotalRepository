<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<ul>
		<li><a href="${cpath }/ajax/location" class="btn" value="서울">서울</a></li>
		<li><a href="${cpath }/ajax/location" class="btn" value="인천">인천</a></li>
		<li><a href="${cpath }/ajax/location" class="btn" value="경기">경기</a></li>
		<li><a href="${cpath }/ajax/location" class="btn" value="강원">강원</a></li>
		<li><a href="${cpath }/ajax/location" class="btn" value="전라북도">전북</a></li>
		<li><a href="${cpath }/ajax/location" class="btn" value="전라남도">전남</a></li>
		<li><a href="${cpath }/ajax/location" class="btn" value="경상남도">경상남도</a></li>
		<li><a href="${cpath }/ajax/location" class="btn" value="경상북도">경상북도</a></li>
	</ul>
</div>


<script>
	const btns = document.querySelectorAll('.btn');
	
	const Handler = function(event) {
	  event.preventDefault(); 
	
	  const liElement = event.target.parentElement;
	  const value = liElement.querySelector('a').getAttribute('value');
	  console.log(value);
	
	  const link = event.target.getAttribute('href');
	  fetch(link + '?value=' + value)
	    .then(resp => 
	    	console.log(resp)
	    	resp.json()
	    	)
	    .then(data => {
	      console.log(data); 
	    });
	};
	
	btns.forEach(btn => {
	  btn.addEventListener('click', Handler);
	});	
</script>
