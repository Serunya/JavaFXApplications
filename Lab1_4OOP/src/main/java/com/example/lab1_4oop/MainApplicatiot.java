package com.example.lab1_4oop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplicatiot extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplicatiot.class.getResource("mainpanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 487, 560);
        stage.setTitle("Graphics");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}