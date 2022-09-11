package com.example.lab1_2oop;

import com.example.lab1_2oop.primitives.PaneCircle;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeLineCap;

public class MainController {
    private PaneCircle paneCircle;
    @FXML
    private Pane CanvasPanel;

    public void editPrimitivePanePosition(int x, int y) {
        paneCircle.setLayoutX(paneCircle.getLayoutX() + x);
        paneCircle.setLayoutY(paneCircle.getLayoutY() + y);
    }

    public void editPrimitivePaneScale(double x, double y) {
        paneCircle.setScaleX(paneCircle.getScaleX() + x);
        paneCircle.setScaleY(paneCircle.getScaleY() + y);
    }

    @FXML
    public void initialize() {
        paneCircle = new PaneCircle(3);
        CanvasPanel.getChildren().add(paneCircle);
    }
}
