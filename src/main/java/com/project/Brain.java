package com.project;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;

public class Brain {

    private Netw client;

    public void brain(String ip, Integer port) {
        
        try {
            client = new Netw(new URI("ws://"+ip+":"+Integer.toString(port)));
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void send(String msg) {
        client.send(msg);
    }

    public String recv() {
        return client.getLastMessage();
    }
}
