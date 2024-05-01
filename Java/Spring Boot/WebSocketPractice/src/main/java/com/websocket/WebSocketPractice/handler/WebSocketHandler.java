package com.websocket.WebSocketPractice.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.websocket.WebSocketPractice.dto.ChatMessge;
import com.websocket.WebSocketPractice.dto.ChatRoom;
import com.websocket.WebSocketPractice.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    /*socket통신은 서버와클라이언트가 1:N 관계를 맺는다.
        한 서버에서 여러 클라이언트가 접속 가능
        서버는 여러 클라이언트가 발송한 메시지를 바당 처리해줄 Handler를 작성해준다.
        Client로 부터 받은 메시지를 Console lOG에서 출력하고 Clinet로 환영 메시지를 보내는 역할을 한다.
    * */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload {} ", payload);
        ChatMessge chatMessge = objectMapper.readValue(payload, ChatMessge.class);
        ChatRoom room = chatService.findRoomById(chatMessge.getRoomId());
        room.handleActions(session,chatMessge,chatService);
    }
}
