package sk.cybersoft.cybernotes.cybernotesapplication.utility;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class SceneSwitcher {
    public static void switchScene(Node node, String scenePath) throws IOException {
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(SceneSwitcher.class.getResource(scenePath));

        stage.setScene(new Scene(root));
    }
}
