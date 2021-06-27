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
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.ResourceBundle;

public class EditNoteContentMenuController implements Initializable {
    @FXML
    private TextArea content;
    @FXML
    private Button saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.content.setText(Info.getNote().getText());
        this.content.end();
    }

    public void save(ActionEvent actionEvent) throws IOException, InterruptedException {
        String content = this.content.getText();
        HashMap<String, Object> values = new HashMap<>() {{
            put("title", Info.getNewNoteName());
            put("text", content);
            put("user", new HashMap<>(){{put("id", Info.getUser().getId());}});
        }};
        HttpResponse<String> response = HttpUtility.putHttp(Info.getDatabaseUrl() + "/note/" + Info.getNote().getId(), values);
        SceneSwitcher.switchScene(this.saveButton, "/unique/NotesMenu.fxml");
    }
}
