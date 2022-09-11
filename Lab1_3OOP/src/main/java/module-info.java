module com.example.lab1_3oop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens com.example.lab1_3oop to javafx.fxml;
    exports com.example.lab1_3oop;
    exports com.example.lab1_3oop.primitives;
    opens com.example.lab1_3oop.primitives to javafx.fxml;
    exports com.example.lab1_3oop.colorcombobox;
    opens com.example.lab1_3oop.colorcombobox to javafx.fxml;
    exports com.example.lab1_3oop.eventhandler;
    opens com.example.lab1_3oop.eventhandler to javafx.fxml;
}