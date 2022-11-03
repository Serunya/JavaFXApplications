package com.example.lab1_3oop.primitives;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Primitive {
    protected int endX = 0;
    protected int endY = 0;
    protected int layoutX = 0;
    protected int layoutY = 0;
    protected double strokeWidth = 1;
    protected Color strokeColor = Color.BLACK;
    protected Color fillColor = Color.BLACK;
    private String strokeType;
    public boolean Choosen = false;

    public Primitive(int layoutX, int layoutY, int height, int weight) {
        this.endX = height;
        this.endY = weight;
        this.layoutX = layoutX;
        this.layoutY = layoutY;
    }

    public Primitive(int layoutX, int layoutY) {
        this.layoutX = layoutX;
        this.layoutY = layoutY;
        this.endX = layoutX;
        this.endY = layoutY;
    }

    // Настройка координат фигуры
    public void setEndCordinat(int x, int y) {
        endX = x;
        endY = y;
    }


    public void setStartY(int y) {
        this.layoutY = y;
    }

    public void setStartX(int x) {
        this.layoutX = x;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public void setStrokeColor(Color color) {
        this.strokeColor = color;
    }

    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    public void setStrokeType(String strokeType) {
        this.strokeType = strokeType;
    }

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(fillColor);
        graphicsContext.setLineWidth(strokeWidth);
        graphicsContext.setStroke(strokeColor);
        if (strokeType.equals("Dotted"))
            graphicsContext.setLineDashes(strokeWidth + 5, strokeWidth + 5);
        else
            graphicsContext.setLineDashes(0, 0);
        drawShape(graphicsContext);
        if (Choosen) {
            drawBorder(graphicsContext);
        }
    }


    public abstract void drawShape(GraphicsContext graphicsContext);

    public void drawBorder(GraphicsContext draw) {
        draw.setStroke(Color.BLACK);
        draw.setLineWidth(1);
        draw.strokeRect(layoutX, layoutY, endX - layoutX, endY - layoutY);
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getLayoutX() {
        return layoutX;
    }

    public int getLayoutY() {
        return layoutY;
    }
}
