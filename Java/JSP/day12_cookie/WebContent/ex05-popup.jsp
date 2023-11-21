<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex05-popup.jsp</title>
<style>
	fieldset {
		width: 250px;
		margin: 10px auto;
	}
	.sb {
		display: flex;
		justify-content: space-between;
	}
</style>
</head>
<body>

<h1>공지사항</h1>
<fieldset>
	내용
</fieldset>

<form method="POST">
	<div class="sb">
		<div>
			<label>
				<input type="checkbox" name="doNotPopup">
				2분동안 이 창을 다시 열지 않습니다
			</label>
		</div>
		<div>
			<input type="submit" value="닫기">
		</div>
	</div>
</form>
<%
	if(request.getMethod().equals("POST")) {
		String doNotPopup = request.getParameter("doNotPopup");
		if(doNotPopup != null) {
			Cookie c = new Cookie("doNotPopup", doNotPopup);
			c.setMaxAge(60 * 2);
			response.addCookie(c);
		}
		%>
		<script>
			window.close()
		</script>
		<%
	}
%>


</body>
</html>








