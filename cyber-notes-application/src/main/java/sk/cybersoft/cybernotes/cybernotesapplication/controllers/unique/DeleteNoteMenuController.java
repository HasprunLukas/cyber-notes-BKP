package sk.cybersoft.cybernotes.cybernotesapplication.controllers.unique;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.HttpUtility;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.Info;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.SceneSwitcher;

import java.io.IOException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

public class DeleteNoteMenuController implements Initializable {

    @FXML
    private Button deleteNoteButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void deleteNote(ActionEvent actionEvent) throws IOException, InterruptedException {
        HttpResponse<String> response = HttpUtility.deleteHttp(Info.getDatabaseUrl() + "/note/" + Info.getNote().getId());

        SceneSwitcher.switchScene(deleteNoteButton, "/unique/NotesMenu.fxml");
    }
}
