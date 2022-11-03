package com.example.lab1_3oop.primitives;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Primitive {
    public Line(int layoutX, int layoutY, int endX, int endY) {
        super(layoutX, layoutY, endX, endY);
    }

    public Line(int layoutX, int layoutY) {
        super(layoutX, layoutY);
    }

    @Override
    public void drawShape(GraphicsContext draw) {
        draw.strokeLine(layoutX, layoutY, endX, endY);
    }

    @Override
    public void setEndCordinat(int x, int y) {
        this.endX = x;
        this.endY = y;
    }

}
