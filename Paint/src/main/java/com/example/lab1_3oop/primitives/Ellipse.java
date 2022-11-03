package com.example.lab1_3oop.primitives;

import javafx.scene.canvas.GraphicsContext;

public class Ellipse extends Primitive {
    public Ellipse(int layoutX, int layoutY) {
        super(layoutX, layoutY);
    }

    @Override
    public void drawShape(GraphicsContext draw) {
        draw.strokeOval(layoutX, layoutY, endX - layoutX, endY - layoutY);
        draw.fillOval(layoutX, layoutY, endX - layoutX, endY - layoutY);
    }
}
