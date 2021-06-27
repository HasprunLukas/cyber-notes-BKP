package sk.cybersoft.cybernotes.cybernotesapplication.controllers.unique;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sk.cybersoft.cybernotes.cybernotesapplication.entity.Note;
import sk.cybersoft.cybernotes.cybernotesapplication.entity.User;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.HttpUtility;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.Info;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.SceneSwitcher;

import java.io.IOException;
import java.net.URL;
import java.net.http.HttpResponse;
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
        String fileName = this.name.getText().trim();

        boolean nameAlreadyExist = false;
        for(Note note : Info.getUser().getNotes()) {
            if (note.getTitle().equals(fileName)) {
                nameAlreadyExist = true;
                break;
            }
        }
        if(fileName.isEmpty()) {
            nameError.setText("Name must be set!");
            nameError.setVisible(true);
            name.getStyleClass().add("hasError");
        } else if(nameAlreadyExist) {
            nameError.setText("Note with the same title already exists!");
            nameError.setVisible(true);
            name.getStyleClass().add("hasError");
        } else {
            Info.setNewNoteName(fileName);
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
