package sk.cybersoft.cybernotes.cybernotesapplication.components;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CloseButton extends Button {


    public CloseButton() {
        super();

        this.setOnAction(event -> {
            Stage stage = (Stage) this.getScene().getWindow();
            stage.close();
        });
    }
}
