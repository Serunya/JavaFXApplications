package com.example.lab1_3oop;

import com.example.lab1_3oop.primitives.Primitive;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

public class SmartCanvas extends Canvas {
    private ArrayList<Primitive> primitives = new ArrayList<>();

    public void add(Primitive primitive) {
        primitives.add(primitive);
    }

    public void paint() {
        this.getGraphicsContext2D().clearRect(0, 0, this.getWidth(), this.getHeight());
        for (Primitive primitive : primitives) {
            primitive.draw(getGraphicsContext2D());
        }
    }

    public void getPrimitive(int x, int y) {
        for (Primitive primitive : primitives) {
            primitive.Choosen = false;
        }
        for (Primitive primitive : primitives) {
            if (x >= primitive.getLayoutX() && y >= primitive.getLayoutY() && x <= primitive.getEndX() && y <= primitive.getEndY()) {
                primitive.Choosen = true;
                break;
            }
        }
        paint();
    }
}
