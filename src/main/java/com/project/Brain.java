package com.project;

import java.net.URI;

import org.java_websocket.client.WebSocketClient;

public class Brain {
    void brain(String ip, Integer port) {
        WebSocketClient client = new Netw(new URI("ws://"+ip+":"+Integer.toString(port)));
		client.connect();
    }
}
