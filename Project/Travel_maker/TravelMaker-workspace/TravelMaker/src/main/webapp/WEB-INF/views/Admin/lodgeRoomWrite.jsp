<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp" %>

<style>
#RoomWrite {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f5f5f5;
}

#lodgeroombtn {
  width: 400px;
  background-color: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
}

input[type="number"],
input[type="text"],
input[type="file"] {
  width: 100%;
  margin: 12px 0;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 16px;
}

input[type="submit"] {
  background-color: #003458;
  color: #fff;
  padding: 9px;
  border: none;
  border-radius: 10px;
  cursor: pointer;
  font-size: 18px;
  transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
  background-color: #001f2f;
}
</style>


<div id="RoomWrite">
	<div id="lodgeroombtn">
		<form method="POST" enctype="multipart/form-data">
			<input type="hidden" name="lodge_Idx" value="${lodgeDTO.lodge_idx }">
			<p><input type="text" name="lodge_Room_Type_Name" placeholder="방 이름" required autofocus></p>
			<p><input type="number" name="lodge_Room_Type_Count" placeholder="남은 호실 개수" required></p>
			<p><input type="number" name="lodge_Room_Type_MinCapacity" placeholder="최소 인원" required></p>
			<p><input type="number" name="lodge_Room_Type_MaxCapacity" placeholder="최대 인원" required></p>
			<p><input type="number" name="lodge_Room_Type_price" placeholder="가격" required></p>
			<p><input type="file" name="imgFile" ></p>
<!-- 		<p><input type="number" name="" placeholder="예약시작 및 종료일" required></p> -->
			<p><input type="submit" value="등록"></p>
		</form>	 
	</div>
</div>


<script>
	const row = '${row}'
	console.log(row)
	if(row) {
		console.log(row)
		
		if(row == 1) {
			alert('상세 숙소가 정상적으로 추가 되었습니다')
			location.href= '${cpath}/lodge/lodge_main'
			
		}else {
			alert('상세 숙소 추가에 실패 했습니다')
		}
		
	}
</script>



</body>
</html>
