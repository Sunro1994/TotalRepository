<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-action.jsp</title>
</head>
<body>
<%	request.setCharacterEncoding("UTF-8"); %>

<%--비어있는 Member 객체를 생성하고, ob에 저장한다 --%>
<jsp:useBean id="ob" class="day05.Member" scope="request" />

<%--넘어오는 모든 파라미터를 필드이름에 맞게 ob에 저장한다 --%>
<jsp:setProperty name="ob" property="*" />

<%--ex02-result.jsp로 포워드 한다 --%>
<jsp:forward page="ex02-result.jsp" />

</body>
</html>





