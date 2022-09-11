module com.example.lab1_2oop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab1_2oop to javafx.fxml;
    exports com.example.lab1_2oop;
}