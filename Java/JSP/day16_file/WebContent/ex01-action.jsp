<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.io.File" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01-action.jsp</title>
</head>
<body>

<h1>ex01-action.jsp</h1>
<hr>

<%
	String saveDirectory = application.getRealPath("/upload");
	int maxPostSize = 1024 * 1024 * 10;	// 10MB
	String encoding = "UTF-8";
	FileRenamePolicy policy = new DefaultFileRenamePolicy();
	
	File dir = new File(saveDirectory);
	if(dir.exists() == false) {	// 만약, 지정한 디렉토리가 존재하지 않으면
		dir.mkdirs();			// 디렉토리(폴더)를 생성한다
	}

	MultipartRequest mpRequest = new MultipartRequest(
			request,		// 기본 내장 객체 request
			saveDirectory,	// 업로드 파일을 저장할 위치
			maxPostSize,	// 최대 허용 용량 크기 (byte)
			encoding,		// 파일 이름 인코딩 규칙
			policy			// 파일 이름 중복시 새로 지정할 이름 정책
		); 
	
	File f = mpRequest.getFile("profileImage");
	
%>
<h3>저장 위치 : <%=saveDirectory %></h3>
<h3>파일 이름 : <%=f.getName() %></h3>
<h3>파일 크기 : <%=f.length() %></h3>


</body>
</html>












