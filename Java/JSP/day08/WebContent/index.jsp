<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<main>
	<h3>대문페이지</h3>
	
	<details>
		<summary>데이터 모델링</summary>
		<h4>주제 : youtube 영상을 DB에 등록하여 목록 및 재생, 삭제가 가능한 사이트 만들기</h4>
		<fieldset>
			<legend>단일 데이터의 구성</legend>
			<ul>
				<li>idx : 내 DB에 등록된 각 레코드의 고유 번호</li>
				<li>title : 영상 제목</li>
				<li>channel : 채널 이름</li>
				<li>viewCount : 조회수</li>
				<li>thumbnail : 영상 썸네일 경로</li>
				<li>movieTag : 영상 소스 코드 (iframe)</li>
			</ul>
		</fieldset>
	</details>
</main>

</body>
</html>