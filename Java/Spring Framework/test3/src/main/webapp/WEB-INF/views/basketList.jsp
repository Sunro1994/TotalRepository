<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<style>
html{
	overflow: hidden;
}
	table{
		border-collapse: collapse;
		width: 1000px;
		background-color: rgba(0,0,0,0.8);
		margin:auto;
	}
	th{
		font-size: 2em;
		padding: 20px 0;
	}
	td{
		text-align: center;
		font-size: 1.3em; 
		padding : 30px 100px;
	}
	.payment{
		position: absolute;
		bottom: 70px;
		right: 70px;
		border-radius: 20px;
		font-size: 2.5em;
		background-color: rgba(255,255,255,0.8);
		color: black;
		padding: 20px 50px;
		font-weight: bold;
	}
	.payment:hover{
		background-color: white;
	}
</style>
<div id="main">
<table>
	<thead>
		<tr>
			<th>음식명</th>
			<th>음식가격</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.menu_name }</td>
				<td>${dto.menu_price }</td>
			</tr>
		</c:forEach>
			<tr>
				 <th colspan="2" >총합 : <fmt:formatNumber pattern="#,###">${sum }</fmt:formatNumber></th>
				</tr>
	</tbody>
</table>
</div>

<button class="payment">결제하기</button>
</body>
<script>
	const payment = document.querySelector('.payment');
	console.log(payment);
	
	paymentHandler = function() {
		const flag = confirm('${sum}원을 정말로 결제하시겠습니까?');
		if(flag) {
			alert('주문이 완료되었습니다.');
			location.href='${cpath}/CompletePay';
		}
	}
	
	
	payment.addEventListener('click',paymentHandler);
</script>
</html>