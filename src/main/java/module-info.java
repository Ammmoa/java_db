module com.example.java_p {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.java_p to javafx.fxml;
    exports com.example.java_p;
}