package sk.cybersoft.cybernotes.cybernotesapplication.controllers.unique;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sk.cybersoft.cybernotes.cybernotesapplication.entity.User;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.HttpUtility;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.Info;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.SceneSwitcher;

import java.io.IOException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

public class LoginMenuController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Label usernameError;
    @FXML
    private Label passwordError;

    private HttpResponse<String> response;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            usernameError.managedProperty().bind(usernameError.visibleProperty());
            passwordError.managedProperty().bind(passwordError.visibleProperty());
            this.response = HttpUtility.getHttp(Info.getDatabaseUrl() + "/user");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loginAttempt(ActionEvent actionEvent) throws IOException {
        usernameError.setVisible(false);
        passwordError.setVisible(false);
        username.getStyleClass().remove("hasError");
        password.getStyleClass().remove("hasError");

        if(username.getText() == null || username.getText().trim().isEmpty()) {
            usernameError.setText("Username must be set!");
            usernameError.setVisible(true);
            username.getStyleClass().add("hasError");
        }

        if(password.getText() == null || password.getText().trim().isEmpty()) {
            passwordError.setText("Password must be set!");
            passwordError.setVisible(true);
            password.getStyleClass().add("hasError");
        }

        if(passwordError.isVisible() || usernameError.isVisible()) {
            return;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        User[] users = objectMapper.readValue(this.response.body(), User[].class);
        boolean err = true;

        for(User user : users) {
            if(user.getUsername().equals(this.username.getText())) {
                if(user.getPassword().equals(this.password.getText())) err = false;
                break;
            }
        }

        if(err) {
            passwordError.setText("Username or password is incorrect!");
            usernameError.setText("Username or password is incorrect!");
            passwordError.setVisible(true);
            usernameError.setVisible(true);
            password.getStyleClass().add("hasError");
            username.getStyleClass().add("hasError");
        }
        else {
            try {
                SceneSwitcher.switchScene(loginButton, "/unique/MainMenu.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
