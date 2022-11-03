module com.example.lab1_5oop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab1_5oop to javafx.fxml;
    exports com.example.lab1_5oop;
}