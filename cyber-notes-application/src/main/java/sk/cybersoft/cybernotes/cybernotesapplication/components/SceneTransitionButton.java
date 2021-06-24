package sk.cybersoft.cybernotes.cybernotesapplication.components;

import javafx.beans.NamedArg;
import javafx.scene.control.Button;
import sk.cybersoft.cybernotes.cybernotesapplication.utility.SceneSwitcher;

import java.io.IOException;


public class SceneTransitionButton extends Button {
    public SceneTransitionButton(@NamedArg("scenePath") String scenePath){
        super();

        this.setOnAction(event -> {
            try {
                SceneSwitcher.switchScene(this, scenePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
