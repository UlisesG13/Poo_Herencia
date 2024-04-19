module com.ulisesg.ranchofeliz {
    requires javafx.controls;
    requires javafx.fxml;


    requires org.kordamp.bootstrapfx.core;

    opens com.ulisesg.ranchofeliz to javafx.fxml;
    exports com.ulisesg.ranchofeliz;
    exports com.ulisesg.ranchofeliz.controllers;
    opens com.ulisesg.ranchofeliz.controllers to javafx.fxml;
}