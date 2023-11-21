<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Enumeration enumData = application.getInitParameterNames();
	
		while(enumData.hasMoreElements()){
			String initParamName = (String)enumData.nextElement();
			String initParamValue = application.getInitParameter(initParamName);
			System.out.println("initParamName : " + initParamName + "\ninitParamValue = " + initParamValue);
		}
	
	%>
</body>
</html>