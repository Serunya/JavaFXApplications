package com.example.lab1_2oop.primitives;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class PaneCircle extends Pane {
    private Circle circle;
    private Line line;
    private Rectangle rectangle;


    public PaneCircle(int Primitive) {
        this.setStyle("-fx-border-color: black; -fx-border-style: dashed;");
        if (Primitive == 1) {
            circle = new Circle(35);
            circle.setLayoutX(37);
            circle.setLayoutY(37);
            circle.setFill(Color.LIGHTGREEN);
            this.getChildren().add(circle);
        }
        if (Primitive == 2) {
            line = new Line(0, 0, 70, 70);
            line.setFill(Color.RED);
            this.getChildren().add(line);
        }
        if (Primitive == 3) {
            rectangle = new Rectangle(2, 2, 70, 70);
            rectangle.setFill(Color.RED);
            this.getChildren().add(rectangle);
        }
    }

}
