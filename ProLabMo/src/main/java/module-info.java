module com.example.prolabmo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.prolabmo to javafx.fxml;
    exports com.example.prolabmo;
    exports Clases;
    opens Clases to javafx.fxml;
    exports CheakConnection;
    opens CheakConnection to javafx.fxml;
}