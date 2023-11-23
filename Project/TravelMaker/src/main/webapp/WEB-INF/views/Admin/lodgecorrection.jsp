<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp" %>

<style>
/* 부모 컨테이너 스타일 */
  #lodgecorrection {
  	margin-top: 100px;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
  }

  /* 내부 컨테이너 스타일 */
  #lodgectn {
    background-color: #f0f0f0;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  }

  /* 폼 스타일 */
  form {
    display: flex;
    flex-direction: column;
  }

  /* 입력 필드 스타일 */
  input[type="text"],
  input[type="file"] {
    margin: 10px 0;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 16px;
  }

  /* 제출 버튼 스타일 */
  input[type="submit"] {
    background-color: #003458;
    color: #fff;
    padding: 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 18px;
  }

  input[type="submit"]:hover {
    background-color: #003458;
  }
  textarea {
  	height: 200px;
  	width: 300px;
  	resize: vertical;
  }
</style>

<div id="lodgecorrection">
	<div id="lodgectn">
		<form method="POST" enctype="multipart/form-data">
			<input type="hidden" name="lodge_idx" value="${lodgeDTO.lodge_idx }">
			<p><input type="text" name="lodge_name" value="${lodgeDTO.lodge_name }" required autofocus></p>
			<p><input type="text" name="lodge_rate" value="${lodgeDTO.lodge_rate }" required></p>
			<p><input type="text" name="lodge_address" value="${lodgeDTO.lodge_address }" required></p>
			<p><input type="text" name="lodge_type" value="${lodgeDTO.lodge_type }" required></p>
			<p><input type="text" name="lodge_tel" value="${lodgeDTO.lodge_tel }" required></p>
			<p><textarea name="lodge_content" required>${lodgeDTO.lodge_content }</textarea></p>
			<p><input type="number" name="lodge_Sellerinfo_businessnum" value="${lodgeDTO.lodge_Sellerinfo_businessnum }" required></p>
			<p><input type="file" name="imgFile" ></p>
			<p><input type="submit" value="수정완료"></p>
		</form>	
	</div>
</div>

<script>
	const tmp = '${tmp}'
// 	console.log(tmp)
	if(tmp) {
	 	if(tmp == 1){
	 		alert('숙소 수정이 되었습니다')
	 		location.href= '${cpath}/lodge/lodge_main'
	 	}
	 	else {
	 		alert('숙소 수정이 실패 하였습니다')
	 	}
	}
</script>

</body>
</html>
