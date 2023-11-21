<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String preTitle = request.getParameter("titleName"); 
 	application.setAttribute("titleName", preTitle);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.list{
		border : 1px dashed green;
		width : 200px;
	}
	.list p{
		width :fir-content;
		border-bottom : 1px solid grey;
	}
	fieldset:hover{
		display:inline;
	}
	.func{
		padding : 20px;
		border : 1px solid black;
		width : fit-content;
		margin:  10px auto;
		border-radius : 20px;
		background-color : #37485D;
	}
	h2{
		text-align: center;
		margin : 0;
		padding : 0;
		width : 169px;
		border-radius : 20px;
		color:white;
	}
	input{
		all:unset;
		width: 169px;
		border : 0.3px solid #7F7F7F;
		border-radius : 10px;
		padding : 10px;
		color: white;
		text-align : center;
	}
	input:hover { 
		background-color : #EBEBEB;
		color : black;
	
	}
	h2{
		position : relative;
	}
	h2:hover span{
		opacity: 1;
		transition-duration : 1s;
	}
	span{
		opacity : 0;
		position: absolute;
		width : 70px;
		hieght: 30px;
		background-color: black;
		color: white;
		border-radius : 20px 20px 20px 0;
		top: -8px;
		border : 3px dashed white;
		font-size : 0.7rem;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="func">
	<h2>수정할 이름을 적어주세요.</h2>
	<form methd="POST" action="quiz-alert2.jsp">
		<p><input type="text" name="changedName" placeholder="수정할 제목" ></p>
		<p><input type="submit" value="수정하기">
	</form>
	</div>
</body>
</html>