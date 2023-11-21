<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<form method="POST">
	<p><input type="text" name="userid" placeholder="ID" required></p>
	<p><input type="email" name="email" placeholder="email" required></p>
	<p><input type="submit"></p>
</form>

</body>
<c:if test="${msg!=null}">
${msg }
</c:if>


<script>
	const msg = '${msg}'
	if(msg!=''){		
	alert(msg)
	location.href= '${cpath}/ex02';
	}
</script>
</html>