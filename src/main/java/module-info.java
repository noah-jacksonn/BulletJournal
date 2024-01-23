module cs3500.pa05 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    requires org.controlsfx.controls;

    opens cs3500.pa05 to javafx.fxml;
    exports cs3500.pa05;
    exports cs3500.pa05.controller;
    exports cs3500.pa05.model;
    exports cs3500.pa05.model.json to com.fasterxml.jackson.databind;
    exports cs3500.pa05.view;
    opens cs3500.pa05.controller to javafx.fxml;
    exports cs3500.pa05.model.data;
    exports cs3500.pa05.view.dialogs;
}
