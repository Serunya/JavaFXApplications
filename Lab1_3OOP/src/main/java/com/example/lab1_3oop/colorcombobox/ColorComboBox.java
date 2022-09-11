package com.example.lab1_3oop.colorcombobox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

public class ColorComboBox extends ComboBox<ColorItem> {
    //////////////////////////////////////
    public static ObservableList<ColorItem> defaultColors = FXCollections.observableArrayList(
            new ColorItem(Color.BLACK, "Черный"),
            new ColorItem(Color.BLUE, "Синий"),
            new ColorItem(Color.YELLOW, "Желтый"),
            new ColorItem(Color.GREEN, "Зеленый"),
            new ColorItem(Color.BROWN, "Коричневый"));
    //////////////////////////////////////

    public ColorComboBox() {
        setItems(defaultColors);
        setCellFactory(new ColorPropertyFactory());
        setValue(defaultColors.get(0));
    }

    public void setLayoutXY(int x, int y) {
        setLayoutX(x);
        setLayoutY(y);
    }

    public void setSize(int widtht, int height) {
        setWidth(widtht);
        setHeight(height);
    }
}
