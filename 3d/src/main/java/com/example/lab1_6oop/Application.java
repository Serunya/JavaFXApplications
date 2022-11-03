package com.example.lab1_6oop;

import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.embed.swing.SwingFXUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Application extends javafx.application.Application {
    Rotate r;
    Transform t = new Rotate();
    Group molecule = null;
    @Override
    public void start(Stage stage) throws IOException {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 600, 600, true);
        stage.setScene(scene);
        stage.setTitle("3D Viewer");
        PerspectiveCamera perspectiveCamera = new PerspectiveCamera();
        scene.setCamera(perspectiveCamera);
        stage.show();
        //Создание самой группы из сфер
        //Настройка камеры
        try {
            scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
                switch (keyEvent.getCode()) {
                    case O -> {
                        FileChooser fc = new FileChooser();
                        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("moleculs files", "*.xyz"));
                        File file = fc.showOpenDialog(null);
                        if (file != null) {
                            Path path = Paths.get(file.getPath());
                            molecule = get3DGroupMolecul(Paths.get(file.getPath()));
                            pane.getChildren().add(molecule);
                        }
                    }

                    case I -> {
                        FileChooser fc = new FileChooser();
                        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.png", "*.jpg", "*.gif"));
                        File file = fc.showSaveDialog(null);
                        try {
                            if (file != null) {
                                WritableImage wi = pane.snapshot(null, new WritableImage(600, 600));
                                ImageIO.write(SwingFXUtils.fromFXImage(wi, null), "png", file);
                            }
                        } catch (IOException ioe) {
                            System.out.println("eeeeeee");
                        }
                    }

                    case UP -> {
                        r = new Rotate(20, Rotate.X_AXIS);
                        t = t.createConcatenation(r);
                        molecule.getTransforms().clear();
                        molecule.getTransforms().add(t);
                    }
                    case DOWN -> {
                        r = new Rotate(-20, Rotate.X_AXIS);
                        t = t.createConcatenation(r);
                        molecule.getTransforms().clear();
                        molecule.getTransforms().add(t);
                    }
                    case LEFT -> {
                        r = new Rotate(20, Rotate.Y_AXIS);
                        t = t.createConcatenation(r);
                        molecule.getTransforms().clear();
                        molecule.getTransforms().add(t);
                    }

                    case RIGHT -> {
                        r = new Rotate(-20, Rotate.Y_AXIS);
                        t = t.createConcatenation(r);
                        molecule.getTransforms().clear();
                        molecule.getTransforms().add(t);
                    }
                }
            });
            scene.setOnScroll(e -> {
                molecule.setTranslateZ(molecule.getTranslateZ() - e.getDeltaX());
                molecule.setTranslateZ(molecule.getTranslateZ() - e.getDeltaY());
            });
            stage.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
                molecule.setLayoutX(e.getX() - 100);
                molecule.setLayoutY(e.getY() - 100);
            });
        }catch (NullPointerException e){
            System.out.println("Нужно открыть фигуру");
        }
        scene.addEventHandler(MouseEvent.MOUSE_DRAGGED, e ->
        {

        });

        //Запуск сцены.
    }

    public static void main(String[] args) {
        launch();
    }


    private Group get3DGroupMolecul(Path path) {
        Group group = new Group();
        //Path path = Paths.get("src/main/java/com/example/lab1_6oop/molecules.xyz");
        ArrayList<Sphere> spheres = new ArrayList<>();
        ArrayList<Cylinder> cylinders = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(path);
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] atom = scanner.nextLine().split(" ");
                Sphere sphere = new Sphere();
                sphere.setRadius(30);
                Point3D A = new Point3D(Double.parseDouble(atom[1]) * 100, Double.parseDouble(atom[2]) * 100, Double.parseDouble(atom[3]) * 100);
                sphere.setTranslateX(A.getX());
                sphere.setTranslateY(A.getY());
                sphere.setTranslateZ(A.getZ());
                sphere.setMaterial(new PhongMaterial(Color.BROWN));
                for (Sphere sphere1 : spheres) {
                    Point3D B = new Point3D(sphere1.getTranslateX(), sphere1.getTranslateY(), sphere1.getTranslateZ());
                    group.getChildren().add(paintCylinder(A, B));
                }
                spheres.add(sphere);
            }
            group.getChildren().addAll(spheres);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return group;
    }

    public Cylinder paintCylinder(Point3D A, Point3D B) {
        Point3D temp = A.subtract(B);
        double Y = temp.getX() != 0 || temp.getZ() != 0 ? B.getY() : Math.max(B.getY(), A.getY());
        Point3D dir = A.subtract(B).crossProduct(new Point3D(0, -1, 0));
        double angle = Math.acos(A.subtract(B).normalize().dotProduct(new Point3D(0, -1, 0)));
        double h1 = A.distance(B);
        Cylinder c = new Cylinder(10d, h1);
        c.setMaterial(new PhongMaterial(Color.BLUE));
        c.getTransforms().addAll(new Translate(B.getX(), Y - h1 / 2d, B.getZ()),
                new Rotate(-Math.toDegrees(angle), 0d, h1 / 2d, 0d, new Point3D(dir.getX(), -dir.getY(), dir.getZ())));
        return c;
    }


}