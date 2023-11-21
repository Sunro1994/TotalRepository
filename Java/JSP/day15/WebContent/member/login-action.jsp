<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<jsp:useBean id="user" class="member.MemberDTO"/>
	<jsp:setProperty property="*" name="user"/>
</div>
<c:set var="login" value="${memberDAO.login(user) }" scope="session"/>

<%
	String autologin = request.getParameter("autologin");
	String storeId = request.getParameter("storeId");
	
	boolean flag1 = storeId != null;
	boolean flag2 = session.getAttribute("login") != null;
	boolean flag3 = autologin != null;
	
	if(flag1){
		Cookie c1 = new Cookie("userid", request.getParameter("userid"));
		c1.setMaxAge(flag1 && flag2 ? 60*60*24*7 : 0);
		response.addCookie(c1);
	}
	
	if(flag3){
		Cookie c2 = new Cookie("JSESSIONID", session.getId());
		c2.setMaxAge(flag2 ? 60*60*24*7 : 0);
		c2.setPath(request.getContextPath());
		response.addCookie(c2);
	}
%>
	
<% 
	response.sendRedirect("../index.jsp");
%>

</body>
</html>