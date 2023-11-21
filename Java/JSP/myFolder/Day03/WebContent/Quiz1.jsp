<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.cal{
	width: 620px;
	height: 400px;
	
	padding : 10px;
	margin: 200px auto;
	border-radius: 20px;
	align-items: center;
	background-color : #91C8E4;
	
	}
	
	.number{
		width:400px;		
	}
	.result{
	
		width: 580px;
		background-color: #4682A9;
		height : 100px;
		font-size: 4em;
		text-align: center;
		border-radius: 20px;
		margin: 30px auto;
		color:white;
	}
	.flex{
		display:flex;
		flex-flow:wrap;
	}
	form{
	justify-content: center;
	margin-top : 20px;
	width: 400px;
	
	}
	input{
	all:unset;
	font-size: 1.3em;
	background-color: #4682A9;
	color:white;
	border-radius: 20px;
	text-align:center;
	width: 110px;
	height : 40px;
	margin: 5px;
	}
	input:hover{
		opacity: 0.8;
		transition-duration : 0.5s;
	}
	.func{
	width: 150px;	
	
	padding-left: 10px;
	
	}
	#box{
		width:600px;
		display: flex;
		box-sizing: border-box;
		justify-content : space-between;
		border : 1px solid grey;
		border-radius : 20px;
		margin: auto;
		
		
	}
</style>
</head>
<body>
	<div class="cal">
	<div class="result"><%=exp %></div>
	<div id="box" >
	<div class="number" class="flex">
	<form method="POST" class="flex">
		<input type="submit" name="num" value="1">
		<input type="submit" name="num" value="2">
		<input type="submit" name="num" value="3">
		<input type="submit" name="num" value="4">
		<input type="submit" name="num" value="5">
		<input type="submit" name="num" value="6">
		<input type="submit" name="num" value="7">
		<input type="submit" name="num" value="8">
		<input type="submit" name="num" value="9">
		<input type="submit" name="num" value="*">
		<input type="submit" name="num" value="0">
		<input type="submit" name="num" value="/">
		
	</form>
	</div>
	<div class="func flex">
	<form method="POST">
	<input type="submit" name="num" value="+">
		<input type="submit" name="num" value="-">
		<input type="submit" name="num" value="=">
		<input type="submit" name="num" value="CE">
	</form>
		</div>
	</div>
	</div>
	<%! String exp = ""; 
		int result =0;	
	%>
	<%
		
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
			String num = request.getParameter("num");
			if("CE".equals(num)){
				exp="";
				result=0;
				return;
			}
			if("=".equals(num)){
				if(exp.charAt(0)=='+'||exp.charAt(0)=='-') {
					response.sendRedirect("Quiz1.jsp");
				}
				else if(exp.contains("+")) {
					result = Integer.parseInt(exp.split("\\+")[0])+Integer.parseInt(exp.split("\\+")[1]);	
				}
				else if(exp.contains("-")) {
					result = Integer.parseInt(exp.split("\\-")[0])-Integer.parseInt(exp.split("\\-")[1]);	
				}
				
			}
			exp += ""+num+"";
	%>
	
	<h3>정답은 <%=result %>입니다.</h3>
	
	<%
	}
	%>
	
	<script>
  const result = document.querySelector('.result');
  const btn = document.querySelector('input[value="="]');

  function sendResult() {
	  result.innerText = ''
    result.innerText = <%=result %>
  }
  btn.addEventListener('click', sendResult);
	</script>

</body>
</html>