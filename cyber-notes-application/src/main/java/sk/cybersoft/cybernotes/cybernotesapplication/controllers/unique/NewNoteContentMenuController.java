package sk.cybersoft.cybernotes.cybernotesapplication.controllers.unique;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.HttpUtility;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.Info;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.SceneSwitcher;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class NewNoteContentMenuController implements Initializable {
    @FXML
    private TextArea content;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void save(ActionEvent actionEvent) {
        try {
            String content = this.content.getText();
            HashMap<String, Object> values = new HashMap<>() {{
                put("title", Info.getNewNoteName());
                put("text", content);
                put("user", new HashMap<>(){{put("id", Info.getUser().getId());}});
            }};
            HttpUtility.postHttp(Info.getDatabaseUrl() + "/note", values);
            Info.setNewNoteName(null);
            SceneSwitcher.switchScene(this.saveButton, "/unique/NotesMenu.fxml");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
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
