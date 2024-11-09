package edu.theobird;
import javax.websocket.*;
import java.io.IOException;
import java.net.URI;


@ClientEndpoint
public class WebsocketClient {

    public static void connect() {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();

        try {
            URI address = new URI("ws://localhost:8080");
            container.connectToServer(WebsocketClient.class, address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("onOpen");

        Interface.send.addActionListener(e -> {
            try {
                session.getBasicRemote().sendText(Interface.messageField.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("onMessage: " + message);
        MessageManager.createMessage(message);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("onClose");
    }
}
