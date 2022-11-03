module com.example.lab1_7oop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.lab1_7oop to javafx.fxml;
    exports com.example.lab1_7oop;
}