package com.example.lab1_3oop.eventhandler;

import com.example.lab1_3oop.GraphController;
import com.example.lab1_3oop.primitives.Primitive;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyEventController implements EventHandler<KeyEvent> {
    private GraphController controller;

    public KeyEventController(GraphController controller) {
        this.controller = controller;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        Primitive primitive = controller.getLastPrimitive();
        if (primitive != null) {
            if (keyEvent.getCode() == KeyCode.LEFT) {
                primitive.setStartX(primitive.getLayoutX() - 4);
                primitive.setEndCordinat(primitive.getEndX() - 4, primitive.getEndY());
            }
            if (keyEvent.getCode() == KeyCode.RIGHT) {
                primitive.setStartX(primitive.getLayoutX() + 4);
                primitive.setEndCordinat(primitive.getEndX() + 4, primitive.getEndY());
            }
            if (keyEvent.getCode() == KeyCode.UP) {
                primitive.setStartY(primitive.getLayoutY() - 4);
                primitive.setEndCordinat(primitive.getEndX(), primitive.getEndY() - 4);
            }
            if (keyEvent.getCode() == KeyCode.DOWN) {
                primitive.setStartY(primitive.getLayoutY() + 4);
                primitive.setEndCordinat(primitive.getEndX(), primitive.getEndY() + 4);
            }
            if (keyEvent.getCode() == KeyCode.D) {
                primitive.setEndCordinat(primitive.getEndX() + 4, primitive.getEndY());
            }
            if (keyEvent.getCode() == KeyCode.A)
                primitive.setStartX(primitive.getLayoutX() - 4);
            if (keyEvent.getCode() == KeyCode.W)
                primitive.setStartY(primitive.getLayoutY() - 4);
            if (keyEvent.getCode() == KeyCode.S)
                primitive.setEndCordinat(primitive.getEndX(), primitive.getEndY() + 4);
        }
        controller.paint();
    }
}
