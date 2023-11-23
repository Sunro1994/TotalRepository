<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
            background-color: #f8f8f8;
            background-image: url("http://localhost:8080/img/jingu.jpeg");
        }
        .error-container {
            margin: 100px auto;
            padding: 20px;
            border: 1px solid #e0e0e0;
            border-radius: 5px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #ff0000;
        }
    </style>
</head>
<body>
<div class="error-container">
    <h1>오류 발생</h1>
    <p id="error-message">죄송합니다, 오류가 발생하였습니다.</p>
    <p>문제가 지속 될 경우 관리자 에게 문의 바랍니다.</p>
    <p id="status-code"></p>
</div>

<script>
    // JavaScript를 사용하여 오류 페이지를 동적으로 설정
    const statusCodeElement = document.getElementById("status-code");
    const errorMessageElement = document.getElementById("error-message");

    // 현재 페이지 URL에서 상태 코드와 오류 메시지를 추출
    const urlParams = new URLSearchParams(window.location.search);
    const statusCode = urlParams.get("status");
    const errorMessage = urlParams.get("message");

    if (statusCode) {
        statusCodeElement.textContent = `상태 코드: ${statusCode}`;
    } else {
        statusCodeElement.textContent = "상태 코드: 오류 코드를 가져올 수 없습니다.";
    }

    if (errorMessage) {
        errorMessageElement.textContent = `오류 메시지: ${errorMessage}`;
    } else {
        errorMessageElement.textContent = "오류 메시지: 오류가 발생하였습니다.";
    }
</script>
</body>
</html>
