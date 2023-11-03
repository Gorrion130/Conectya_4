package com.project;

import java.net.URI;
import java.net.URISyntaxException;

public class Brain {

    private Netw client;

    public Brain(String ip, int port) throws InterruptedException {
        
        try {
            client = new Netw(new URI("ws://"+ip+":"+Integer.toString(port)));
            try {
                client.connectBlocking();
            } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
