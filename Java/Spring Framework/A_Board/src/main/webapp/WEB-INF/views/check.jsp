<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set value="${pageContext.request.contextPath }" var="cpath" />


<c:if test="${login==null }">
	<c:redirect url="/member/login" />
</c:if>