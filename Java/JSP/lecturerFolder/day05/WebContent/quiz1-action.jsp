<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz1-action.jsp</title>
</head>
<body>

<%	request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="ob" class="day05.Movie" />
<jsp:setProperty property="*" name="ob" />

${list.add(ob) }


<jsp:forward page="quiz1-movie.jsp" />

</body>
</html>