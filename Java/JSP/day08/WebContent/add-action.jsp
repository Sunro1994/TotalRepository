<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<%--파라미터를 받기 위한 dto 생성 --%>
<jsp:useBean id="dto" class="youtube.YoutubeDTO" />

<%--모든 파라미터를 name이 일치하는 필드에 대입 --%>
<jsp:setProperty name="dto" property="*" />

<%--DB에 dto를 추가하기 위한 dao 생성 --%>
<jsp:useBean id="dao" class="youtube.YoutubeDAO" />

<%--dao의 insert 함수를 호출하면서 dto를 전달 (결과는 정수로 반환) --%>
${dao.insert(dto) }

<%--작업이 끝났으면 list.jsp 로 리다이렉트 --%>
<c:redirect url="/list.jsp" />
</body>
</html>