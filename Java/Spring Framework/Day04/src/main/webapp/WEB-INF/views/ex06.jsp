<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<h3>MultipartFile을 포함하는 DTO형식의 업로드</h3>

<form method="POST" enctype="multipart/form-data">
	<p><input type="file" name="upload" accept="image/*">
	<p><input type="text" name="title" placeholder=""></p>
	<p><input type="submit"></p>
</form>

	<div>
<c:forEach var="dto" items="${list}">
	<div style="width: 170px;">
		<div style="background-image: url('${cpath}/upload/${dto.fileName}'); 
					background-position : center;
					background-size : auto 100%;
					background-repeat : no-repeat;
						width: 150px;
						height : 150px;
					"></div>
		<div>${dto.title }</div>
		<h4 style="text-align:center;">
			<a href="${cpath}/upload/${dto.fileName}" download="a.jpg" >${dto.title}
		</h4>
	</div>
</c:forEach>
	</div>
</body>
</html>