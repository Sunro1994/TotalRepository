<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! int answer =(int)(Math.random()*100)+1; 
    	int cnt=0;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.hidden{
		display: none;
	}
</style>
</head>
<body>
<h1>웹 페이지에서 구동된는 updown game</h1>
<hr>
	<%--form 안에 input하나만 있으면 submit을 안만들어도 제출이가능하다. --%>
	<form method="GET">
		<p><input type="number" name="tryNum" placeholder="정답을 입력하세요." autofocus></p>
		<p><input type="submit" class="btn"></p>
	</form>
	
	<%	//요청이 들어올 때마다 변하는 변수들을 위에 모아서 만들어 둔다.
		String tryStr = request.getParameter("tryNum");
		int res=0;
		if(tryStr!=null){
		int tryNum = Integer.parseInt(tryStr);
		out.print(answer);

		
		if(tryNum == answer) {
	%>
	<script>
		const form = document.querySelector('form')
		console.log(form)
		form.classList.add('hidden');
	</script>
		<h3>정답입니다! <%=cnt%>회만에 맞추셨습니다. <p>정답:<%=tryNum %></p></h3>
		<%} else if(tryNum > answer){%>
		<h3>Down!</h3>
		<%cnt++;} else if(tryNum < answer){%>
		<h3>UP!</h3>
		<%
		cnt++;}}%>
		
		<a href="quiz3.jsp"><button>되돌아가기</button></a>
		
		
	
		
	

	


</body>
</html>