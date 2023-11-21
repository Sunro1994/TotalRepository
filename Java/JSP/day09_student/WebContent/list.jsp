<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	<h3>목록</h3>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>합계</th>
				<th>평균</th>
			</tr>
		</thead>
		<tbody>
		<c:set var="list" value="${dao.selectList() }" />
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>
				<a href="${cpath }/view.jsp?name=${dto.name}">${dto.name }</a>
			</td>
			<td>${dto.kor }</td>
			<td>${dto.eng }</td>
			<td>${dto.math }</td>
			<td>${dto.total }</td>
			<td>${dto.avg }</td>
			<td>
				<a href="${cpath }/delete.jsp?name=${dto.name}"><button>삭제</button></a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>