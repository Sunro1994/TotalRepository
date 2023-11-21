<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp" %>

<style>
  /* 부모 컨테이너 스타일 */
  #roomcorrection {
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
  }

  /* 내부 컨테이너 스타일 */
  #roomctn {
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
  input[type="number"],
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
</style>

<div id="roomcorrection">
	<div id="roomctn">
		<form method="POST" enctype="multipart/form-data">
			<input type="hidden" name="lodge_Room_Type_Idx" value="${roomDTO.lodge_Room_Type_Idx }">
			<p><input type="text" name="lodge_Room_Type_Name" value="${roomDTO.lodge_Room_Type_Name} " required autofocus></p>
			<p><input type="number" name="lodge_Room_Type_MinCapacity" value="${roomDTO.lodge_Room_Type_MinCapacity}" required></p>
			<p><input type="number" name="lodge_Room_Type_MaxCapacity" value="${roomDTO.lodge_Room_Type_MaxCapacity }" required></p>
			<p><input type="number" name="lodge_Room_Type_Count" value="${roomDTO.lodge_Room_Type_Count}" required></p>
			<p><input type="number" name="lodge_Room_Type_price" value="${roomDTO.lodge_Room_Type_price}" required></p>
			<p><input type="file" name="imgFile" ></p>
			<p><input type="submit" value="수정완료"></p>
		</form>	 
	</div>
</div>

<script>
	const row = '${row}'
	if(row) {
		console.log(row)
		
		if(row == 1) {
			alert('수정이 정상적으로 완료 되었습니다')
			location.href= '${cpath}/lodge/lodge_main'
			
		}else {
			alert('수정에 실패 했습니다')
		}
		
	}
</script>



</body>
</html>