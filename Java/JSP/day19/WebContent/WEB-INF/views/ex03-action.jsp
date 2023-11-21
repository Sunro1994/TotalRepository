<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03-action</title>
</head>
<body>

<script>
	const flag = '${flag}'
	if(flag == 'true') {
		alert('정답')
		location.href = '${pageContext.request.contextPath}/ex03'
	}
	else {
		alert('오답')
		history.go(-1)
	}
</script>

</body>
</html>






