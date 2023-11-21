<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp" %>


    <link rel="stylesheet" href="${cpath }/css/main_css/review.css" type="text/css">
 

<div id="review_write">
    <form method="POST">
    
		<input type="hidden" name= "lodge_idx" value="${lodge_idx}">   
		<input type="hidden" name= "lodge_Review_RoomTypeIdx" value="${lodge_Room_Type_Idx}">    
        <div id="myform">
            <fieldset>
                <legend>평점</legend>
                <input type="radio" name="lodge_Review_Rate" value="5" id="rate1"><label for="rate1">⭐</label>
                <input type="radio" name="lodge_Review_Rate" value="4" id="rate2"><label for="rate2">⭐</label>
                <input type="radio" name="lodge_Review_Rate" value="3" id="rate3"><label for="rate3">⭐</label>
                <input type="radio" name="lodge_Review_Rate" value="2" id="rate4"><label for="rate4">⭐</label>
                <input type="radio" name="lodge_Review_Rate" value="1" id="rate5"><label for="rate5">⭐</label>
            </fieldset>
        </div>
        <div id="mydiv">
            <span id="ratingText">평점: 0점</span>
            <p><textarea name="lodge_Review_Content" placeholder="후기를 적어주세요"></textarea></p>
        </div>

        <div id="mysubmit">
            <input type="submit" value="평가 등록">
        </div>
    </form>
</div>

<script>
    const rateInputs = document.querySelectorAll('input[name="lodge_Review_Rate"]');
    const ratingText = document.querySelector('#ratingText'); // 별점을 표시할 요소

    // 별점 선택 시 이벤트 처리
    rateInputs.forEach(input => {
        input.addEventListener('change', (e) => {
            const selectedRating = e.target.value; // 선택된 별점을 가져옵니다.
            ratingText.innerText = ''
            ratingText.innerText += '평점:' + selectedRating +'점'
        });
    });


</script>
</body>
</html>