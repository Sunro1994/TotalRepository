<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ex03-header.jsp" %>

<div>
	<c:set var="list" value="${dao.select() }" />
	<div class="list">
		<c:forEach var="dto" items="${list }">
			<details>
				<summary><b>${dto.idx } | ${dto.title }</b></summary>
				<img src="${dto.filePath }">
			</details>
		</c:forEach>
	</div>
</div>

</body>
</html>