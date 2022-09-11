package com.example.lab1_3oop;

import com.example.lab1_3oop.colorcombobox.ColorComboBox;
import com.example.lab1_3oop.primitives.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class GraphController {
    @FXML
    private ToggleButton ToggleButtonLine;
    @FXML
    private ToggleButton ToggleButtonCircle;
    @FXML
    private ToggleButton ToggleButtonEllipse;
    @FXML
    private ToggleButton ToggleButtonRectangle;

    // Верхнее меню
    @FXML
    private MenuItem SavaItem;

    // Настройка размера сохроняемого изображения
    @FXML
    private TextField ImageWidth;
    @FXML
    private TextField ImageHeight;

    // Рисование
    @FXML
    private ComboBox<String> StrokeType;
    @FXML
    private ColorComboBox colorStroke;
    @FXML
    private ColorComboBox colorBackground;
    @FXML
    private TextField StrokeWidth;
    @FXML
    private SmartCanvas canvas;

    private Primitive lastPrimitive;

    public Primitive getLastPrimitive() {
        return lastPrimitive;
    }

    @FXML
    public void initialize() {
        settingsStrokeType();
        canvas.setOnMousePressed(e -> {
            lastPrimitive = getPrimitive((int) e.getX(), (int) e.getY());
            if (lastPrimitive != null) {
                lastPrimitive.setStrokeWidth(Double.parseDouble(StrokeWidth.getText()));
                lastPrimitive.setFillColor(colorBackground.getSelectionModel().getSelectedItem().getColor());
                lastPrimitive.setStrokeColor(colorStroke.getSelectionModel().getSelectedItem().getColor());
                lastPrimitive.setStrokeType(StrokeType.getSelectionModel().getSelectedItem());
                canvas.add(lastPrimitive);
                canvas.paint();
            }
        });
        canvas.setOnMouseDragged(e -> {
            if (lastPrimitive != null) {
                lastPrimitive.setEndCordinat((int) e.getX(), (int) e.getY());
                canvas.paint();
            }
        });
    }

    public void paint() {
        canvas.paint();
    }

    private void settingsStrokeType() {
        StrokeType.getItems().add("Dotted");
        StrokeType.getItems().add("Solid");
        StrokeType.setValue("Dotted");
    }

    public void saveImage() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.png", "*.jpg", "*.gif"));
        File file = fc.showSaveDialog(null);
        try {
            if (file != null) {
                WritableImage wi = canvas.snapshot(null, new WritableImage(Integer.parseInt(ImageWidth.getText()), Integer.parseInt(ImageHeight.getText())));
                ImageIO.write(SwingFXUtils.fromFXImage(wi, null), "png", file);
            }
        } catch (IOException ioe) {
            System.out.println("eeeeeee");
        }
    }

    private Primitive getPrimitive(int x, int y) {
        if (ToggleButtonLine.isSelected())
            return new Line(x, y);
        if (ToggleButtonCircle.isSelected())
            return new Circle(x, y);
        if (ToggleButtonEllipse.isSelected())
            return new Ellipse(x, y);
        if (ToggleButtonRectangle.isSelected())
            return new Rectangle(x, y);
        return null;
    }
}
