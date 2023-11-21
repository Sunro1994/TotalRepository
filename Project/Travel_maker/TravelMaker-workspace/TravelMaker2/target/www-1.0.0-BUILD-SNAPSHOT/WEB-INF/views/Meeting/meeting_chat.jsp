<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp" %>

<div id="meeting_groupChat" class="frame">
	<h2 id="status">연결 대기중...</h2>
	<br><br>
	
	<!-- 메시지 출력 영역 -->
	<div id="groupMessageArea"></div>
	
	<input type="text" id="message" placeholder="Press Enter for send message." onkeyup="if(window.event.keyCode==13){(send())}">
	
	
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script>

	let socket;
	let stompClient;

	let roomId;


	function connect() {
		socket = new SockJS('/www/chat');
		stompClient = Stomp.over(socket);
		roomId = 'groupchat'

		stompClient.connect({}, (frame) => {


			const status = document.getElementById('status');
			status.innerText = '채팅을 시작하세요';



			// '/broker/receive' 주소를 구독하여 메시지를 받음
			stompClient.subscribe('/broker/room/' + roomId, onReceive);
		})

		function onReceive(chat){
			const param = JSON.parse(chat.body);
			const content = param.content;
			const userid = param.from

			const groupMessageArea = document.getElementById('groupMessageArea');
			const sender = document.createElement('p');
			const div = document.createElement('div')
			sender.innerText = userid;
			const msg = document.createElement('p');
			msg.innerText = content;
			groupMessageArea.appendChild(div)
			div.appendChild(sender);
			div.appendChild(msg);
		}
	}

	function send() {
		const message = document.getElementById('message');

		stompClient.send('/app/enter', {}, JSON.stringify({
			from: '${user.travelMaker_Member_UserNickName}',
			content: message.value,
			roomId: roomId
		}));
		
		document.getElementById('message').value = '';
		
		document.body.scrollTop = document.body.scrollHeight;
	}
	
	window.onload=connect()
</script>
</body>
</html>