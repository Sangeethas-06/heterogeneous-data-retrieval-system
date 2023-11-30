package dataretrieval.project.handler;

import dataretrieval.project.model.UserTable;
import dataretrieval.project.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
@AllArgsConstructor
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private final DeviceService deviceService;
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
// Update client status as online in the database
// You can access the client information from the WebSocketSession object
        URI uri = session.getUri();
        String query = uri.getQuery();

        if (query != null) {
            String[] queryParams = query.split("&");
            for (String param : queryParams) {
                String[] keyValue = param.split("=");
                String key = keyValue[0];
                String value = keyValue[1];
                if (key.equals("clientId")) {
                    System.out.println("Online -" +value);
                    deviceService.createDevice(UserTable.builder().deviceId(value).status("online").build());
                }
            }
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
// Handle incoming messages from clients
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
// Update client status as offline in the database
        URI uri = session.getUri();
        String query = uri.getQuery();

        if (query != null) {
            String[] queryParams = query.split("&");
            for (String param : queryParams) {
                String[] keyValue = param.split("=");
                String key = keyValue[0];
                String value = keyValue[1];
                if (key.equals("clientId")) {
                    System.out.println("Offline -" +value);
                    deviceService.updateDevice(UserTable.builder().deviceId(value).status("offline").build());

                }
            }
        }
    }
}
