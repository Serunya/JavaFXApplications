package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import javax.imageio.*;

import javafx.embed.swing.SwingFXUtils;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

import static java.lang.System.out;

public class MainController {
    private Image imgLama = new Image(getClass().getResourceAsStream("/com/example/demo/img/lama.png"));
    private Image imgJaba = new Image(getClass().getResourceAsStream("/com/example/demo/img/jaba.png"));
    private Image imgJmih = new Image(getClass().getResourceAsStream("/com/example/demo/img/jmih.png"));
    private Image imgKot = new Image(getClass().getResourceAsStream("/com/example/demo/img/kot.png"));
    private Image img;

    @FXML
    private ToggleGroup radiosImg;

    @FXML
    private RadioButton Lama;

    @FXML
    private RadioButton Frog;
    @FXML
    private RadioButton Kot;
    @FXML
    private RadioButton Jmih;

    @FXML
    private Pane WorkPane;

    @FXML
    private Button BSave;

    @FXML
    public void initialize() {
        WorkPane.setOnMouseDragged(this::click);
        Lama.setOnAction(event -> {
            img = imgLama;
        });
        Frog.setOnAction(event -> {
            img = imgJaba;
        });
        Kot.setOnAction(event -> {
            img = imgKot;
        });
        Jmih.setOnAction(event -> {
            img = imgJmih;
        });
    }


    @FXML
    private void click(MouseEvent e) {
        ImageView imgView = new ImageView();

        if (img != null) {
            if (e.getX() < 431 && e.getX() > 33 && e.getY() > 33 && e.getY() < 339) {
                imgView.setImage(img);
                imgView.setX(e.getX() - 32);
                imgView.setY(e.getY() - 32);
                WorkPane.getChildren().add(imgView);
            }
        }
    }

    @FXML
    private void saveImage() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.png", "*.jpg", "*.gif"));
        File file = fc.showSaveDialog(null);
        try {
            if (file != null) {
                WritableImage wi = WorkPane.snapshot(null, new WritableImage((int) WorkPane.getWidth(), (int) WorkPane.getHeight()));
                ImageIO.write(SwingFXUtils.fromFXImage(wi, null), "png", file);
            }
        } catch (IOException ioe) {
            out.println("eeeeeee");
        }

    }
}
