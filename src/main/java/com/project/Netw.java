package com.project;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.util.Collections;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.server.WebSocketServer;

public class Netw extends WebSocketClient {
  
  public Netw(URI port) {
    super(port);
    //TODO Auto-generated constructor stub
  }

private String lmessage;

  @Override
  public void onOpen(ServerHandshake handshake) {
    // TODO Auto-generated method stub
    System.out.println("conectad@ :D");
  }

  @Override
  public void onClose(int code, String reason, boolean remote) {
    // TODO Auto-generated method stub
    System.out.println("desconectad@ :C");
  }

  @Override
  public void onMessage(String message) {
    // TODO Auto-generated method stub
    lmessage = message;
    System.out.println(message);
  }

  public String getLastMessage() {
    return lmessage;
  }

  @Override
  public void onError(Exception ex) {
    // TODO Auto-generated method stub
    System.out.println("Error: "+ex+" :C");
  }
}