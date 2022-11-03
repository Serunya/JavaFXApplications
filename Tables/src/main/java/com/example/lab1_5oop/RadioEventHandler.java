package com.example.lab1_5oop;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;

public class RadioEventHandler implements EventHandler {
    TableColumn tableColumn;
    RadioButton radioButton;

    RadioEventHandler(TableColumn tableColumn, RadioButton radioButton) {
        this.tableColumn = tableColumn;
        this.radioButton = radioButton;
    }

    @Override
    public void handle(Event event) {
        if (radioButton.isSelected())
            tableColumn.setVisible(true);
        else
            tableColumn.setVisible(false);
    }
}
