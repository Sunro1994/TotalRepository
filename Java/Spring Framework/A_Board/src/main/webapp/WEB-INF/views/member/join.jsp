<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<!-- MEMBER_IDX    NOT NULL NUMBER         
USERID        NOT NULL VARCHAR2(100)  
USERPW        NOT NULL VARCHAR2(1000) 
USERNAME      NOT NULL VARCHAR2(100)  
BIRTH         NOT NULL DATE           
EMAIL         NOT NULL VARCHAR2(100)  
PROFILEIMG             VARCHAR2(2000) 
FINDPASSWORD           VARCHAR2(1000) 
FINDANSWER             VARCHAR2(500)  
     -->

<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="userid" placeholder="ID" required></p>
	<p><input type="text" name="userpw" placeholder="PW" required></p>
	<p><input type="text" name="username" placeholder="이름" required></p>
	<p><input type="date" name="birth" required></p>
	<p><input type="email" name="email" placeholder="1234@naver.com" required></p>
	<p><input type="file" name="profileImg" ></p>
	<p><select name="findPassword" required>
		<option value="귀하의 출생지는 어디인가요?">귀하의 출생지는 어디인가요?</option>
		<option value="보물 0호는 무엇인가요">보물 0호는 무엇인가요?</option>
		<option value="출신 초등학교 이름은 무엇인가요?">출신 초등학교 이름은 무엇인가요?</option>
	</select></p>
	<p><input type="text" name="findAnswer" placeholder="위 설문에 대한 대답을 입력하세요" required></p>
	<p><input type="submit"></p>
	
</form>
</body>
</html>