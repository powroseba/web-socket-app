//package me.john.amiscaray.springwebsocketdemo.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.SimpMessageType;
//import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
//import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
//
//@Configuration
//public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {
//
//    @Override
//    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
//        messages
//                .simpTypeMatchers(
//                        SimpMessageType.CONNECT,
//                        SimpMessageType.HEARTBEAT,
//                        SimpMessageType.UNSUBSCRIBE,
//                        SimpMessageType.DISCONNECT
//                )
//                .permitAll()
//                .anyMessage().authenticated()
//                .simpDestMatchers("/**").authenticated();
//    }
//
//    @Override
//    protected boolean sameOriginDisabled() {
//        return true;
//    }
//
//
//}
