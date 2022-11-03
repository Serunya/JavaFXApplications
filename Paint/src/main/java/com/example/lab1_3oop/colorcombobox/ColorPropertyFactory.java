package com.example.lab1_3oop.colorcombobox;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.shape.Circle;
import javafx.util.Callback;

public class ColorPropertyFactory implements Callback<ListView<ColorItem>, ListCell<ColorItem>> {
    @Override
    public ListCell<ColorItem> call(ListView<ColorItem> colorListView) {
        ListCell<ColorItem> cell = new ListCell<ColorItem>() {
            @Override
            public void updateItem(ColorItem color, boolean empty) {
                super.updateItem(color, empty);
                if (color == null || empty) {
                    setGraphic(null);
                } else {
                    Circle circle = new Circle(0, 0, 7);
                    circle.setFill(color.color);
                    setGraphic(circle);
                    setText(color.colorName);
                }
            }
        };
        return cell;
    }
}
