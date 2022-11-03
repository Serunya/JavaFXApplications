module com.example.lab1_4oop {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.codehaus.groovy;


    opens com.example.lab1_4oop to javafx.fxml;
    exports com.example.lab1_4oop;
}