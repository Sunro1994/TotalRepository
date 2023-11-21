<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board2.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-action.jsp</title>
</head>
<body>
<%	request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="board2.BoardDTO" />
생성된 dto : ${dto }

<jsp:setProperty property="*" name="dto" />

<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	// 문자열 <-> 날짜 변환기
	Date d1 = sdf.parse(request.getParameter("_wdate"));		// 문자열을 util.Date로 변환
	long time = d1.getTime();									// util.Date에서 long 추출
	dto.setWdate(new java.sql.Date(time));						// long으로 sql.Date 생성
%>

<ul>
	<li>전송받은 idx : ${dto.idx }</li>
	<li>전송받은 title : ${dto.title }</li>
	<li>전송받은 writer : ${dto.writer }</li>
	<li>전송받은 content : ${dto.content }</li>
	<li>전송받은 uploadFile : ${dto.uploadFile }</li>
	<li>전송받은 wdate : ${dto.wdate }</li>
</ul>












</body>
</html>