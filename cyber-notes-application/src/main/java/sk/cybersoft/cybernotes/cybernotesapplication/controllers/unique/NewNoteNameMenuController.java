package sk.cybersoft.cybernotes.cybernotesapplication.controllers.unique;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.Info;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.SceneSwitcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewNoteNameMenuController implements Initializable {
    @FXML
    public Button cancelButton;
    @FXML
    private TextField name;
    @FXML
    private Label nameError;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Info.getNewNoteName() != null && !Info.getNewNoteName().isEmpty()) {
            this.name.setText(Info.getNewNoteName());
        }
        nameError.managedProperty().bind(nameError.visibleProperty());
    }

    public void saveName(ActionEvent actionEvent) {
        nameError.setVisible(false);
        name.getStyleClass().remove("hasError");

        if(this.name.getText() == null || this.name.getText().trim().isEmpty()) {
            nameError.setText("Name must be set!");
            nameError.setVisible(true);
            name.getStyleClass().add("hasError");
        } else {
            Info.setNewNoteName(this.name.getText());
            try {
                SceneSwitcher.switchScene(this.name, "/unique/NewNoteContentMenu.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void cancel(ActionEvent actionEvent) {
        Info.setNewNoteName(null);
        try {
            SceneSwitcher.switchScene(this.cancelButton, "/unique/NotesMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
