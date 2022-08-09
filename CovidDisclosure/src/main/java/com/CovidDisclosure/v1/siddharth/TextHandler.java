package com.CovidDisclosure.v1.siddharth;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class TextHandler extends TextWebSocketHandler {

WebSocketSession session;

@Override
public void handleTextMessage(WebSocketSession session, TextMessage message)
        throws InterruptedException, IOException {

        // send message
        if (session.isOpen()) {
            try {

                session.sendMessage(new TextMessage("Hello from the websocket"));
            } finally {
                session.close();
            }
        } else {
            System.out.println("no open session available");
        }
}
}
