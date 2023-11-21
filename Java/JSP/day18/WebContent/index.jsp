<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div>
	<ol>
		<li>프로젝트 생성</li>
		<li>기본 설정파일 및 라이브러리 배치</li>
		<li>import 패키지 지정 및 header 설정</li>
		<li>테이블 데이터 모델링 및 DTO 작성</li>
		<li>파일 업로드에 필요한 DTO를 만드는 함수 작성 (FileUtil)</li>
		<li>구현할 기능에 필요한 기초적인 화면 구현(HTML, CSS)</li>
		<li>가장 필수적인 기능부터 하나씩 구현하기(java, jsp)</li>
		<li>링크를 이용하여 페이지끼리 연결된다</li>
		<li>링크 외에는 form, javascript등을 활용할 수 있다</li>
		<li>기능 구현 시, 사용자 입력값이 있다면 여러 상황을 테스트해봐야 한다</li>
	</ol>
	
	<details>
		<summary>일정시간 뒤 페이지를 이동시키는 HTML meta 태그</summary>
		<fieldset>
			<pre>
&lt;!DOCTYPE html>
&lt;html lang="ko">
&lt;head>
	&lt;meta charset="UTF-8">
	&lt;meta http-equiv="refresh" content="3; url=${cpath}">
&lt;/head>
&lt;body>
	&lt;h1>잘못된 접근입니다&lt;/h1>
&lt;/body>
&lt;/html></pre>
		</fieldset>
	</details>
	
</div>



</body>
</html>