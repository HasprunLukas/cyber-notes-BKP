package sk.cybersoft.cybernotes.cybernotesapplication.controllers.common;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class DateTimeController implements Initializable {
    @FXML
    public Label date;
    @FXML
    public Label time;
    @FXML
    public Label day;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));

            String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            String day = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("en"));
            day = day.substring(0, 1).toUpperCase() + day.substring(1).toLowerCase();

            this.date.setText(date);
            this.time.setText(time);
            this.day.setText(day);
        }), new KeyFrame(Duration.seconds(1)));

        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}
