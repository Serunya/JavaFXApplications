package com.example.lab1_3oop.primitives;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends Primitive {
    public Circle(int layoutX, int layoutY) {
        super(layoutX, layoutY);
    }

    @Override
    public void drawShape(GraphicsContext draw) {

        draw.strokeOval(layoutX, layoutY, endX - layoutX, endX - layoutX);
        draw.fillOval(layoutX, layoutY, endX - layoutX, endX - layoutX);
    }
}
