package com.example.lab1_2oop;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class MainPanel extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPanel.class.getResource("mainpanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("HHew");
        stage.setScene(scene);
        stage.show();
        MainController c = fxmlLoader.getController();
        stage.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.LEFT)
                    c.editPrimitivePanePosition(-4, 0);
                if (keyEvent.getCode() == KeyCode.RIGHT)
                    c.editPrimitivePanePosition(4, 0);
                if (keyEvent.getCode() == KeyCode.UP)
                    c.editPrimitivePanePosition(0, -4);
                if (keyEvent.getCode() == KeyCode.DOWN)
                    c.editPrimitivePanePosition(0, 4);
                if (keyEvent.getCode() == KeyCode.W)
                    c.editPrimitivePaneScale(0.01, 0);
                if (keyEvent.getCode() == KeyCode.S)
                    c.editPrimitivePaneScale(-0.01, 0);
                if (keyEvent.getCode() == KeyCode.D)
                    c.editPrimitivePaneScale(0, 0.01);
                if (keyEvent.getCode() == KeyCode.A)
                    c.editPrimitivePaneScale(0, -0.01);

            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
