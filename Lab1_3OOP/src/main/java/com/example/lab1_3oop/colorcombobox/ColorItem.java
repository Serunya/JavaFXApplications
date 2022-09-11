package com.example.lab1_3oop.colorcombobox;

import javafx.scene.paint.Color;

public class ColorItem {
    Color color = Color.BLACK;
    String colorName = "Черный";

    public ColorItem(Color color, String colorName) {
        this.color = color;
        this.colorName = colorName;
    }

    public Color getColor() {
        return color;
    }

    public String getColorName() {
        return colorName;
    }

    @Override
    public String toString() {
        return colorName;
    }
}
