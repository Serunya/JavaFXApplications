module com.example.lab1_6oop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab1_6oop to javafx.fxml;
    exports com.example.lab1_6oop;
}