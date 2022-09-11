package com.example.lab1_6oop;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Camera camera = new PerspectiveCamera();
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 600, 600,true);
        scene.setCamera(camera);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        Path path = Paths.get("src/main/java/com/example/lab1_6oop/molecules.xyz");
        Scanner scanner = new Scanner(path);
        scanner.nextLine();
        scanner.nextLine();
        ArrayList<String> atoms = new ArrayList<>();
        while(scanner.hasNextLine()){
            atoms.add(scanner.nextLine());
        }
        for(String atom: atoms){
            String[] atomProperty = atom.split(" ");
            Sphere sphere = new Sphere();
            sphere.setRadius(20);
            sphere.setTranslateX(Double.parseDouble(atomProperty[1]) * 100);
            sphere.setTranslateY(Double.parseDouble(atomProperty[2])* 100);
            sphere.setTranslateZ(Double.parseDouble(atomProperty[3]) * 100);
            group.getChildren().add(sphere);
        }
        root.getChildren().add(group);
        Transform transform = new Rotate(65,new Point3D(0,1,0));
        stage.addEventHandler(MouseEvent.MOUSE_DRAGGED,e -> {
            group.getTransforms().add(new Rotate(e.getX()/100,Rotate.X_AXIS));
            group.getTransforms().add(new Rotate(e.getY()/100,Rotate.Y_AXIS));

        });
        stage.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            switch (keyEvent.getCode()){
                case UP -> group.translateZProperty().set(group.getTranslateZ() + 100);
                case DOWN -> group.translateZProperty().set(group.getTranslateZ() - 100);
                case LEFT -> group.translateXProperty().set(group.getTranslateX() - 100);
                case RIGHT -> group.translateXProperty().set(group.getTranslateX() + 100);
                case A -> group.rotateProperty().set(group.getRotate() - 1);
                case D -> group.rotateProperty().set(group.getRotate() + 1);
                case W -> group.translateYProperty().set(group.getTranslateY() - 10);
                case S -> group.translateYProperty().set(group.getTranslateY() + 10);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }


    public void Molecul
}