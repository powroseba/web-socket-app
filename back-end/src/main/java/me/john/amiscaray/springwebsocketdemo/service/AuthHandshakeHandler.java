package me.john.amiscaray.springwebsocketdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeFailureException;
import org.springframework.web.socket.server.HandshakeHandler;

import java.util.Map;

@Component
public class AuthHandshakeHandler implements HandshakeHandler {

    private final WebSocketAuthenticatorService service;
    private static final String USERNAME_HEADER = "username";
    private static final String PASSWORD_HEADER = "password";

    @Autowired
    public AuthHandshakeHandler(WebSocketAuthenticatorService service){
        this.service = service;
    }

    @Override
    public boolean doHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                               Map<String, Object> attributes) throws HandshakeFailureException {
        return false;
    }
}
