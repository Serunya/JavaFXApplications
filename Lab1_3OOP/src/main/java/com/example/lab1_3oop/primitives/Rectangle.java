package com.example.lab1_3oop.primitives;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Primitive {
    public Rectangle(int layoutX, int layoutY) {
        super(layoutX, layoutY);
    }

    @Override
    public void drawShape(GraphicsContext draw) {
        draw.fillRect(layoutX, layoutY, endX - layoutX, endY - layoutY);
        draw.strokeRect(layoutX, layoutY, endX - layoutX, endY - layoutY);
    }
}
