package com.project;

import com.project.Babel;

public class Main {

    public static void main(String[] args) {
        Babel babel = new Babel();
        babel.connect("127.0.0.1",1337);
    }
}

/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {

        final int windowWidth = 800;
        final int windowHeight = 600;
        
        UtilsViews.parentContainer.setStyle("-fx-font: 14 arial;");
        UtilsViews.addView(getClass(), "Disconnected", "/assets/layoutDisconnected.fxml");
        //UtilsViews.addView(getClass(), "Connecting", "/assets/layoutConnecting.fxml");
        //UtilsViews.addView(getClass(), "Disconnecting", "/assets/layoutDisconnecting.fxml");
        //UtilsViews.addView(getClass(), "Connected", "/assets/layoutConnected.fxml");

        Scene scene = new Scene(UtilsViews.parentContainer);
        
        stage.setScene(scene);
        stage.onCloseRequestProperty(); // Call close method when closing window
        stage.setTitle("JavaFX - NodeJS");
        stage.setMinWidth(windowWidth);
        stage.setMinHeight(windowHeight);
        stage.show();
    }
    /* 
    @Override
    public void stop() { 
        AppData.getInstance().disconnectFromServer();
        System.exit(1); // Kill all executor services
    }
    */

//}