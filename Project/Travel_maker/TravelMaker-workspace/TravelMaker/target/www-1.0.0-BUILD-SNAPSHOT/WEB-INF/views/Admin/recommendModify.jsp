<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp"%>

<link rel="stylesheet" type="text/css" href="${cpath}/css/main_css/recommendWrite.css">

<div class="recommendWritePage">
    <div class="recommendModify">
        <form method="POST" enctype="multipart/form-data">
            <input type="hidden" name="recommend_travel_idx" value="${idx}">
            <p><input type="text" name="recommend_travel_title" value="${dto.recommend_travel_title}" placeholder="수정할 제목을 입력해주세요"></p>
            <p><input type="text" name="recommend_travel_address" value="${dto.recommend_travel_address}" placeholder="수정할 주소를 입력해주세요"></p>
            <p><input type="file" name="encoding_img"></p>
            <p><textarea name="recommend_travel_content"  placeholder="내용을 입력해주세요">${dto.recommend_travel_content}</textarea></p>
            <p><input type="date" name="recommend_travel_eventstartdate" value="${dto.recommend_travel_eventstartdate}" required></p>
            <p><input type="date" name="recommend_travel_eventenddate"  value="${dto.recommend_travel_eventenddate}" required></p>
            <p><input type="text" name="recommend_travel_mapx" value="${dto.recommend_travel_mapx}" placeholder="x좌표"></p>
            <p><input type="text" name="recommend_travel_mapy" value="${dto.recommend_travel_mapy}" placeholder="y좌표"></p>
            <p><input type="number" name="recommend_travel_maplevel" value="${dto.recommend_travel_maplevel}" placeholder="확대 레벨"></p>
            <p><input type="text" name="recommend_travel_tel" value="${dto.recommend_travel_tel}" placeholder="전화번호"></p>
            <p><input type="number" name="recommend_travel_contentid" value="${dto.recommend_travel_contentid}" placeholder="행사id"></p>
            <p><input type="submit" value="수정하기"></p>
        </form>
    </div>
</div>

</body>
</html>