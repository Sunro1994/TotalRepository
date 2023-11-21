<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>오류 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: white;
            background-image: url("http://localhost:8080/img/jingu.jpeg");
            background-color: #003458;
        }
        .error-container {
            margin: 100px auto;
            padding: 20px;
            border: 1px solid #e0e0e0;
            border-radius: 5px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            color : #003458;
            height: 200px;
            
        }
        h1 {
            color: #ff0000;
        }
        button{
        	background-color: white;
        	font-size: 1.1em;
        	cursor: pointer;
        	margin-top: 10px;
        	padding: 10px 20px;
        	
        }
        button:hover{
        	font-weight: bold;
        	cursor: pointer;
        }
    </style>
</head>
<body>
<div class="error-container">
    <h1>오류 발생</h1>
    <p id="error-message">죄송합니다, 계정은 탈퇴된 회원입니다..</p>
    <p>문제가 지속 될 경우 관리자 에게 문의 바랍니다.</p>
    <p id="status-code"></p>
<a href="${cpath }"><button>메인화면으로 이동하기</button></a>
</div>


</body>
</html>
