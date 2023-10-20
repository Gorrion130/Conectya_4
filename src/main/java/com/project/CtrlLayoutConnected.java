package com.project;

import java.util.List;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CtrlLayoutConnected {

    @FXML
    private Label serverAddressLabel;

    @FXML
    private Label clientIdLabel;

    @FXML
    private TextArea messagesArea;

    @FXML
    private ListView<String> clientsList;

    @FXML
    private TextField messageField;

    @FXML
    private Button sendButton;

    public void initialize() {

        clientsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        clientsList.setOnMouseClicked(event -> {

            // Set new selection (or deselect)
            AppData appData = AppData.getInstance();
            int clickedIndex = clientsList.getSelectionModel().getSelectedIndex();
            appData.selectClient(clickedIndex); 

            // Get real selection (can be unset)
            Integer selectedIndex = appData.getSelectedClientIndex();
            if (selectedIndex != null) {
                sendButton.setText("Send");
            } else {
                sendButton.setText("Broadcast");
            }
            sendButton.requestFocus();

            // De-select all
            for (int i = 0; i < clientsList.getItems().size(); i++) {
                clientsList.getSelectionModel().clearSelection(i);
            }

            appData.updateClientList();
        });
    
        clientsList.setCellFactory(lv -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(item);
                    AppData appData = AppData.getInstance();
                    Integer selectedIndex = appData.getSelectedClientIndex();
                    if (selectedIndex != null && selectedIndex.intValue() == getIndex()) {
                        setStyle("-fx-background-color: #14b5ff; -fx-text-fill: white;");
                    } else {
                        setStyle(null);
                    }
                }
            }
        });
    }
    
    @FXML
    private void handleDisconnect(ActionEvent event) {
        AppData appData = AppData.getInstance();
        appData.disconnectFromServer();
    }

    @FXML
    private void handleSend(ActionEvent event) {
        AppData appData = AppData.getInstance();
        String message = messageField.getText();
        appData.send(message);
        messageField.clear();
    }

    public void updateInfo() {
        AppData appData = AppData.getInstance();
        serverAddressLabel.setText("ws://" + appData.getIp() + ":" + appData.getPort());
        clientIdLabel.setText(appData.getMySocketId());
    }

    public void updateMessages(String messages) {
        messagesArea.setText(messages);
    }

    public void updateClientList(List<String> clients) {
        Platform.runLater(() -> {
            clientsList.setItems(FXCollections.observableArrayList(clients));
        });
    }
}
