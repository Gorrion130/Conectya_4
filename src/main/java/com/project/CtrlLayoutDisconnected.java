package com.project;

import java.net.SocketException;
import java.net.UnknownHostException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class CtrlLayoutDisconnected {

    @FXML
    private AnchorPane refAnchorPane;

    @FXML
    private TextField ipTextField;

    @FXML
    private TextField portTextField;

    private AppData appData;

    Rectangle rect = new Rectangle();
    Circle circle = new Circle();

    public void initialize() {
        appData = AppData.getInstance();

        try {
            appData.setIp(appData.getLocalIPAddress());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        ipTextField.setText(appData.getIp());
        portTextField.setText(appData.getPort());

        Platform.runLater(() -> {
            draw();
        });
    }

    @FXML
    private void connectToServer() {
        appData.setIp(ipTextField.getText());
        appData.setPort(portTextField.getText());
        appData.connectToServer();

    }

    private void draw() {
        double height = refAnchorPane.getHeight();
        double bottom = height - 100;

        // Crear el rectangle
        rect.setX(-25.0);
        rect.setY(-25.0);
        rect.setWidth(50.0);
        rect.setHeight(50.0);
        rect.setStroke(Color.rgb(100, 100, 100, 1.0));
        rect.setStrokeWidth(2.0);  // Establir el gruix del contorn a 2 px
        rect.setFill(null); // No emplenar l'interior del rectangle

        AnchorPane.setLeftAnchor(rect, 50.0);
        AnchorPane.setTopAnchor(rect, bottom);
        refAnchorPane.getChildren().add(rect);

        // Crear el cercle
        circle.setCenterX(0.0f);
        circle.setRadius(25.0); 
        circle.setFill(Color.BLUE);

        AnchorPane.setLeftAnchor(circle, 50.0);
        AnchorPane.setTopAnchor(circle, bottom);
        refAnchorPane.getChildren().add(circle);
    }
}
