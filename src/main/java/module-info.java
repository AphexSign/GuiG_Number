module com.example.guig_number {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.guig_number to javafx.fxml;
    exports com.example.guig_number;
}