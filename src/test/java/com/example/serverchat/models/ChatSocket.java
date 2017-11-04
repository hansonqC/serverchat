package com.example.serverchat.models;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**  CTRL + O - dostepne metody
 * Created by lukasz on 2017-11-04.  Protokół Stomb  Oprócz web socket handler mamy BinaryWebSocketHandler
 */
@EnableWebSocket
@Configuration
public class ChatSocket extends TextWebSocketHandler implements WebSocketConfigurer {



    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(this,"/chat").setAllowedOrigins("*");//ustal pozwolenia dla adresów IP /WILDCARD/ Dwiazdka oznacza ze wszystkie adresy ma obsługiwać
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Przyszła wiadomość");
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Ktoś sie podłączył pod socket");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("Ktoś się rozłączył");
    }
}
