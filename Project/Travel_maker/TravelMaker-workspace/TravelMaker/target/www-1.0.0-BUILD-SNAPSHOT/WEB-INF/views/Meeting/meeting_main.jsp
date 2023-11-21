<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp" %>
  
<div id="meeting_main" class="frame">
	<div id="meeting_main_top" class="flex">
		<h1>게시판</h1>
		<p><a href="http://192.168.4.234:8080/www/Meeting/meeting_chat">💌단체채팅하기</a></p>
	</div>
	<div id="meeting_board">
		<c:forEach var="list" items="${meetinglist }">
		<c:if test="${list.meeting_Board_IsDeleted != 'Y'}">
			<div class="meeting_board_content flex">
				<div class="board_img">
					<img src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBw0NDRANDw0RDg4NDw0ODQ0NDQ8NDg4NFhEWFhYSFhMYHCggGBouGxUTITEhKCkrLy4xFyEzODYsNygtLisBCgoKDg0NFxAPGC0fICUrLS0rKy8tLS0tLS0wLTItLS01LS0tNy0rNS0tLS0rKystLS0rKystKy0tLS0rLSsrK//AABEIAOAA4QMBIgACEQEDEQH/xAAaAAEBAQADAQAAAAAAAAAAAAAAAQUCAwQG/8QAMRABAAIAAwUECQUBAAAAAAAAAAECAwQRBSExQVESMmFxEyJCUoGRobHBM3KS0eHx/8QAGQEBAQEBAQEAAAAAAAAAAAAAAAMBAgQF/8QAHhEBAQEBAAMAAwEAAAAAAAAAAAECEQMxQRIhURP/2gAMAwEAAhEDEQA/APrEFfRfNQVBoogxQAAAAAAAAAAAAAQUBBQEFAQUBFRQRQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQBoqAKIoAAwAAAAAAAAAAAAEBqiAKIAogAqAAAAACooAAwAAAAHKlLW3REz5Rq765DFn2dPOYZ2NkteYeqdn4vSJ8rQ6MTBvXvVmPHTd8zsOVwAawABABoAAAAAAAASAAACooAAwAAiNWjldn87/x/tz2dlezHbtHrT3fCHtS1v5Fs4+1K1iI0iNI6QoJqAAPHmchW2+vq26ezP8ATLvWazpMaTHJ9A82ey3pK6x3o4ePgpnf9T1j+McBVFABoAAAAAAAAAAAAqKAAMHdk8Lt4kRy4z5Q6Whsmvet5Q51eR1mdrRAQegAAAAABkbSwuziaxwtv+PN5WptWutInpb6TDLXzexDc5UAdOQAAAAAAAAAAABUUAAYNPZPdt5x9mY92yr6WtX3o1jzj/rnfp3j20wEFwAAAAAHl2n+lPnVkNLa191a9Z7TNWx6Q37QB25AAAAAAAAAJAAAVFAAGDlhYk0tFo4xOriDW/h3i0RaOEuTHyWa9HOk76zx8J6tetomNYnWJ4TCGs8XzrsUBy6AACZ03zwjiMvP5ztepXu856/42Ttc61yPPmsb0l5ty4R5OoF0KgDQAAAAAAAAAAAAVFAAGAADtwMxfDn1Z3c4nhLqGNauFtGk96JrPzh6K5jDnhevzhhI4vjjueSt+cakcb1/lDoxc/h14T2p8P7Y6n+cL5K78xnL4m7hX3Y/LoB3Jxxb0AaxABoAAAAAAAAAAAAqKAAMB3ZfLWxJ3bo52ng08DJ0py1nrLm6kd5zazMLKYl+FdI6zuh68PZnvX+FY/LQE7uqTEeWuz8KOUz5zLnGTwvcj6u8c9rr8Y6ZyeF7kfVwtkMKeUx5TL0h2n4xn32ZHs3+FoeXFyeJT2dY613todTdc3EfPDax8pS/GNJ96N0szM5W2Hx3196Pz0UmpU9YsecB05AAAAAAAAAAAAFRQHryWT7frW3V5Rzt/jjkct6S2s92vHxno2IhPeufqO8Z7+6laxEaRGkRwiFBJYAAAAAAAAJjXdyAGXnsj2db07vOvT/HhfRsjaGV7E9qserPGOkq418qWs/Y8YCiYAAAAAAAAAA5UpNpiscZnSHFobKwtZm88t0ebLeRsna9+DhxSsVjl9Z6uYPO9AAAAAAAAAAAACuN6RaJrPCd0uQMfP4+FNLTWeX1hwae1sLWIv03T5MxfN7ENTlAHTAAAAAAAABt5GnZwq+PrT8WJEPoqxpER0jRPyelPHP2AJKgAAAAAAAAAAAKAMdeYp2qWr1ifmwH0b5/MV0vaOlp+6njqfkcAFUwAAAAAAAHLC71f3V+76B8/hd6v7q/d9Al5Pivj+gCagAAAAAAAAAAACgDBh579W/n+G4w89+rfz/Cnj9uN+nQAqkAAAA//9k=">
				</div>
				<div class="board_content">
					<div class="meeting_writer flex">
						${list.meeting_Board_Nickname }
					</div>
					<div class="meeting_date">
						${list.meeting_Board_Date }
					</div>
					<div class="meeting_location">
						${list.meeting_Board_Location }
					</div>
					<div class="meeting_content">
						${list.meeting_Board_Content }
					</div>
				</div>
				
				
				<div id="meeting_btn" class="flex">
					<div class="modifyBtn flex">
						<div class="board_idx">${list.meeting_Board_Idx }</div>
						<div class="modify_btn">수정</div>
					</div>
					<div class="deleteBtn flex">
						<div class="board_idx">${list.meeting_Board_Idx }</div>
						X
					</div>
				</div>
				<div class="chat_room">
						<button class="chat_btn" onclick="connect()">채팅방 입장💌</button>
				</div>
			</div>
		</c:if>
		</c:forEach>
	</div>
	
	<div id="meeting_write_btn">
		<button id="write_btn">글쓰기</button>
	</div>
	
	<div id="meeting_write">
		<dialog id="write_modal">
		<h2>새 글 쓰기</h2>
			<div class="write_content">
				<form method="POST">
					<p><textarea name="meeting_Board_Content" placeholder="내용을 입력하세요" required autofocus></textarea></p>
					<p><input type="text" name="meeting_Board_Location" placeholder="현재 계신 숙소 위치" required></p>
					<p><input type="submit" value="작성"></p>
				</form>
				<p class="modal_btn">
					<button id="write_cancel">나가기</button>
				</p>
			</div>
		</dialog>
	</div>
	
	<div id="meeting_modify">
        <dialog id="modify_modal">
        <h2>수정하기</h2>
            <div class="modify_content">
                <form id="modify_form" method="POST" action="${cpath }/Meeting/modify_board/">
                    <p><textarea class="modifyContent" name="meeting_Board_Content" placeholder="내용을 입력하세요" required autofocus rows="30" cols="100"></textarea></p>
                    <p><input class="modifyLocation" type="text" name="meeting_Board_Location" placeholder="현재 계신 숙소 위치" required></p>
                    <p><input type="submit" value="작성"></p>
                </form>
                <p class="modal_btn">
                    <button id="modify_cancel">나가기</button>
                </p>
            </div>
        </dialog>
</div>
	
	<div id="meeting_chat" onkeyup="if(window.event.keyCode==27){(closeChatModalOnEsc())}">
		<dialog id="chat_modal">
		<div class="chat_top flex">
			<h2>1대1 채팅</h2>
			<h2 class="chat_cancel">X</h2>
		</div>
				<!-- 메시지 출력 영역 -->
				
				<div id="messageArea">
					<h3 id="status">연결 안됨</h3>
				</div>
				
				
			<div class="chat_input">
				<textarea id="message" placeholder="Press Enter for send message." onkeyup="if(window.event.keyCode==13){(send())}"></textarea>
				<button onclick="send()">보내기</button>
			</div>
		</dialog>
	</div>
</div>

<script>

	$(".deleteBtn").click(function(event) {
		const idx = event.target.innerText.replace("X","")
		const loginNickname = '${user.travelMaker_Member_UserNickName}'
		const writer = event.target.parentNode.previousElementSibling.firstElementChild.innerText
		if(loginNickname == writer) {
			let flag = confirm('정말 삭제 하시겠습니까?')
			if(flag) {
				location.href = '${cpath}/Meeting/delete_board/' + idx
			}
		} else {
			swal('정보 불일치','본인만 삭제 가능합니다','error')
		}
		const chat_room = document.querySelector('.chat_room')
	})
	
	$("#write_btn").click(function(event) {
		if('${user}' == '') {
			swal('로그인 필요','로그인을 해주세요','error')
			location.href = '${cpath}/Member/Welcome-Login'
		}
		var write_modal = document.getElementById('write_modal')
		write_modal.showModal();
	})
	
	$('#write_cancel').click(function(event) {
		var write_modal = document.getElementById('write_modal')
		write_modal.close();
	})
	
	$(".modify_btn").click(function(event) {
        const idx = event.target.previousElementSibling.innerText

        const location = event.target.parentNode.parentNode.previousElementSibling
        .firstElementChild.nextElementSibling.nextElementSibling.innerText
        
        const content = event.target.parentNode.parentNode.previousElementSibling
        .firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.innerText
        
        const modifyContent = document.querySelector('.modifyContent')
        const modifyLocation = document.querySelector('.modifyLocation')
        
        const loginNickname = '${user.travelMaker_Member_UserNickName}'
        const writer = event.target.parentNode.parentNode.previousElementSibling.firstElementChild.innerText
        if(loginNickname == writer) {
            const modify_form = document.querySelector('#modify_form')
            let flag = confirm('정말 수정하시겠습니까?')
            if(flag) {
                var modify_modal = document.getElementById('modify_modal')
                modify_modal.showModal()
                modify_form.action = '${cpath}/Meeting/meeting_modify/' + idx
                modifyContent.value = content
                modifyLocation.value = location
            }
        }
        else {
            swal('정보 불일치','본인만 삭제 가능합니다','error')
        }
    })
	
	$('#modify_cancel').click(function(event) {
		var modify_modal = document.getElementById('modify_modal')
		modify_modal.close();
	})
	
	
	// 웹 소켓 채팅
	
	let socket;
	let stompClient;

	let roomId;
	
	let userid;
	
	const chat_btn = document.querySelectorAll('.chat_btn');

	chat_btn.forEach(function(button) {
	  button.onclick = function selectUserid(event) {
		  const userid = event.target.parentNode.previousElementSibling.previousElementSibling.firstElementChild.innerText;
		  
		  connect(userid)
	  }
	});
	
    
    function connect(userid) {
		socket = new SockJS('/www/chat');
		stompClient = Stomp.over(socket);
		roomId = userid;
		
		
		stompClient.connect({}, (frame) => {


		const status = document.getElementById('status');
		status.innerText = '연결되었습니다.';

// 		document.getElementById('room_id').value = '';
		

		console.log('Connected: ' + frame);

		// '/broker/receive' 주소를 구독하여 메시지를 받음
		stompClient.subscribe('/broker/room/' + roomId, onReceive);
		})
	
		function onReceive(chat){
			const param = JSON.parse(chat.body);
			const content = param.content;
			const userid = '${user.travelMaker_Member_UserNickName}'
			const from = param.from

			const messageArea = document.getElementById('messageArea');
			const div = document.createElement('div')
			const sender = document.createElement('p');
			sender.innerText = from;
			const msg = document.createElement('p');
			msg.innerText = content;
			messageArea.appendChild(div)
			div.appendChild(sender);
			div.appendChild(msg)
			console.log(div.firstElementChild.innerText)
			const textUserid = div.firstElementChild.innerText
			if(textUserid != userid) {
				sender.style.textAlign = 'left'
				msg.style.textAlign = 'left'
			}
			else {
				sender.style.textAlign = 'right'
				msg.style.textAlign = 'right'
			}
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

		let chat_modal = document.querySelector('#chat_modal')
		
		scrollHeight = chat_modal.scrollHeight
		
		chat_modal.scrollTop = scrollHeight
	}
	
	$(".chat_btn").click(function(event) {
		if('${user}' == '') {
			swal('로그인 필요','로그인을 해주세요','error')
			location.href = '${cpath}/Member/Welcome-Login'
		}
		var chat_modal = document.getElementById('chat_modal')
		chat_modal.showModal();
	})
	
	$(".chat_cancel").click(function(event) {
		var chat_modal = document.getElementById('chat_modal')
		chat_modal.close()
		location.reload();
	})
	
	function closeModal() {
		var chat_modal = document.getElementById('chat_modal')
		chat_modal.close()
		location.reload();
	}
	
	function closeChatModalOnEsc(event) {
	    if (event.key === "Escape") {
	        var chat_modal = document.getElementById('chat_modal');
	        chat_modal.close();
	        location.reload();
	    }
	}

	document.addEventListener("keydown", closeChatModalOnEsc);
</script>
</body>
</html>