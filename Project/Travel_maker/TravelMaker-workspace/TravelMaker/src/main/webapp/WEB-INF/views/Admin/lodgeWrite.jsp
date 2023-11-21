<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp" %>

<style>
	.adminPage{
		margin-top : 100px;
	}
</style>
<div class="adminPage">
	<div class="lodgeWrite" >
		<form method="POST" enctype="multipart/form-data" action="${cpath }/Admin/actionLodgeWirte"> 
			<p><input type="text" name="lodge_name" placeholder="숙소 이름" required></p>
			<p><input type="text" name="lodge_type" placeholder="숙소 종류(모텔,호텔 ...)" required></p>
			<p><input type="file" name="imgFile"></p>
			<p><input type="text" name="lodge_address" placeholder="숙소 주소" required></p>
			<p><input type="text" name="lodge_tel" placeholder="숙소 전화번호" required></p>
			<p><textarea name="lodge_content" placeholder="숙소 설명" required></textarea></p>
			<p><input type="number" name="lodge_Sellerinfo_businessnum" placeholder="사업자번호" required></p>
			<p><input type="submit" value="작성"></p>
		</form>
	</div>
</div>
</body>
</html>
