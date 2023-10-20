package com.project;

import java.net.URI;
import java.util.function.Consumer;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

public class AppSocketsClient extends WebSocketClient {

    private Consumer<ServerHandshake> callBackOnOpen;
    private Consumer<String> callBackOnMessage;
    private Consumer<OnCloseObject> callBackOnClose;
    private Consumer<Exception> callBackOnError;

    public class OnCloseObject {
        public int code;
        public String reason;
        public boolean remote;
    }

    public AppSocketsClient(URI uri, Consumer<ServerHandshake> onOpen, Consumer<String> onMessage, Consumer<OnCloseObject> onClose, Consumer<Exception> onError) {
        super(uri, (Draft) new Draft_6455());
        this.callBackOnOpen = onOpen;
        this.callBackOnMessage = onMessage;
        this.callBackOnClose = onClose;
        this.callBackOnError = onError;
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        callBackOnOpen.accept(handshake);
    }

    @Override
    public void onMessage(String message) {
        callBackOnMessage.accept(message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        OnCloseObject obj = new OnCloseObject();
        obj.code = code;
        obj.reason = reason;
        obj.remote = remote;
        callBackOnClose.accept(obj);
    }
    
    @Override
    public void onError(Exception ex) {
        callBackOnError.accept(ex);
    }
}
