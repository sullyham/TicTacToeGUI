package com.example.game;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    @FXML
    private Label mylabel;
    @FXML
    private ToggleButton toggleButton;
    private MediaPlayer music;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toggleButton.setText("Mute Music");
        Media media = new Media(getClass().getResource("/Alive.mp3").toExternalForm());
        music = new MediaPlayer(media);
        music.setCycleCount(MediaPlayer.INDEFINITE);
        music.play();
        RotateTransition rotate = new RotateTransition(Duration.millis(1500),mylabel);
        rotate.setFromAngle(-10);
        rotate.setToAngle(10);
        rotate.setAutoReverse(true);
        rotate.setCycleCount((int) Double.MAX_VALUE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();

    }
    public void ToggleMusic(){
        if(!music.isMute()){
            music.setMute(true);
            toggleButton.setText("Unmute Music");
        }
        else{
            music.setMute(false);
            toggleButton.setText("Mute Music");
        }
    }
}
