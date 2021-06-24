module cyber.notes.application {

    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    requires java.net.http;

    requires com.fasterxml.jackson.databind;


    opens sk.cybersoft.cybernotes.cybernotesapplication.controllers.unique;
    opens sk.cybersoft.cybernotes.cybernotesapplication.controllers.common;
    opens sk.cybersoft.cybernotes.cybernotesapplication;
    opens sk.cybersoft.cybernotes.cybernotesapplication.entity;
    opens sk.cybersoft.cybernotes.cybernotesapplication.components;
}