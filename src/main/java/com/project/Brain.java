package com.project;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;

public class Brain {
    void brain(String ip, Integer port) {
        WebSocketClient client;
        try {
            client = new Netw(new URI("ws://"+ip+":"+Integer.toString(port)));
            client.connect();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
