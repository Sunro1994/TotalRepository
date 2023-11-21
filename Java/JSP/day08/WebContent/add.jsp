<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<main>
	<h3>추가</h3>
	
	<form action="${cpath }/add-action.jsp" method="POST">
		<p><input type="number" name="idx" placeholder="idx"></p>
		<p><input type="text" name="title" placeholder="title"></p>
		<p><input type="text" name="channel" placeholder="channel"></p>
		<p><input type="number" name="viewCount" placeholder="viewCount"></p>
		<p><input type="text" name="thumbnail" placeholder="thumbnail"></p>
		<p><textarea name="movieTag" placeholder="movieTag"></textarea></p>
		<p><input type="submit"></p>
	</form>
</main>

</body>
</html>






