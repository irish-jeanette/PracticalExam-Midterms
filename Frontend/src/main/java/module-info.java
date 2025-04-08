module com.example.checkoutapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.rocs.self.checkout.application to javafx.fxml;
    exports com.rocs.self.checkout.application;
}