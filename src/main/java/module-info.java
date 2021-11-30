module com.example.cartoonsearch {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens com.example.cartoonsearch to javafx.fxml, com.google.gson;
    exports com.example.cartoonsearch;
}