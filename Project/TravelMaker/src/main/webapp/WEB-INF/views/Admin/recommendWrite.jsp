<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp"%>

<link rel="stylesheet" href="${cpath }/css/main_css/recommendWrite.css"
	type="text/css">	
<style>
.recommendWritePage{
	margin-top: 150px;
}
</style>
<div class="recommendWritePage">
    <div class="recommendWrite">
        <form method="POST" enctype="multipart/form-data">
            <p><input type="text" name="recommend_travel_title" placeholder="행사 제목"></p>
            <p><textarea name="recommend_travel_content" placeholder="내용을 입력해주세요"></textarea></p>
            <p><input type="text" name="recommend_travel_address" placeholder="주소를 입력해주새요" required></p>
            <p><input type="date" name="recommend_travel_eventstartdate" required></p>
            <p><input type="date" name="recommend_travel_eventenddate" required></p>
            <p><input type="file" name="encoding_img"></p>
            <p><input type="text" name="recommend_travel_mapx" placeholder="x좌표"></p>
            <p><input type="text" name="recommend_travel_mapy" placeholder="y좌표"></p>
            <p><input type="number" name="recommend_travel_maplevel" placeholder="맵레벨"></p>
            <p><input type="text" name="recommend_travel_tel" placeholder="전화번호"></p>
            <p><input type="number" name="recommend_travel_contentid" placeholder="행사 id"></p>
            <p><input type="submit" value="작성하기"></p>
        </form>
    </div>
</div>

</body>
</html>