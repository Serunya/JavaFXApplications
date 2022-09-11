package com.example.lab1_3oop;

import com.example.lab1_3oop.eventhandler.KeyEventController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScene extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Управление фигурами
        FXMLLoader fxmlLoader = new FXMLLoader(MainScene.class.getResource("mainpanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 688, 450);
        stage.setTitle("Графический редактор!");
        stage.setScene(scene);
        stage.show();
        GraphController controller = fxmlLoader.getController();
        //Управление фигурами.
        stage.addEventFilter(KeyEvent.KEY_PRESSED, new KeyEventController(controller));
    }

    public static void main(String[] args) {
        launch();
    }
}