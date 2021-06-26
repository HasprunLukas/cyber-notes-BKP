package sk.cybersoft.cybernotes.cybernotesapplication.controllers.unique;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import sk.cybersoft.cybernotes.cybernotesapplication.entity.Note;
import sk.cybersoft.cybernotes.cybernotesapplication.entity.User;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.HttpUtility;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.Info;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.SceneSwitcher;

import java.io.IOException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

public class NotesMenuController implements Initializable {

    @FXML
    private ListView<HBox> notesList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            HttpResponse<String> response = HttpUtility.getHttp(Info.getDatabaseUrl() + "/user/" + Info.getUser().getId());
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(response.body(), User.class);
            for(Note note : user.getNotes()) {
                HBox hBox = new HBox(10);
                Label label = new Label(note.getTitle());
                Pane pane = new Pane();
                Label edit = new Label("Edit");
                Label delete = new Label("Delete");
                edit.getStyleClass().add("labelClickable");
                delete.getStyleClass().add("labelClickable");
                hBox.getChildren().addAll(label, pane, edit, delete);
                HBox.setHgrow(pane, Priority.ALWAYS);
                edit.setOnMouseClicked(event -> System.out.println(note.getText()));
                delete.setOnMouseClicked(event -> {
                    try {
                        Info.setNote(note);
                        SceneSwitcher.switchScene(notesList, "/unique/DeleteNoteMenu.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                notesList.getItems().add(hBox);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
