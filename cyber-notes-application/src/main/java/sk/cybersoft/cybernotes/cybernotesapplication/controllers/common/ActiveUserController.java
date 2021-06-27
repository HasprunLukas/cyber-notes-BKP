package sk.cybersoft.cybernotes.cybernotesapplication.controllers.common;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.Info;

import java.net.URL;
import java.util.ResourceBundle;

public class ActiveUserController implements Initializable {
    @FXML
    private Label username;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.username.setText(Info.getUser().getUsername());
        this.username.getStyleClass().add("activeUser");
    }
}
