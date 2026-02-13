package com.example.game;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label mylabel;
    private MediaPlayer music;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Media media = new Media("https://sullyham.github.io/game-audio/Audio/Alive.mp3");
        music = new MediaPlayer(media);
        music.setCycleCount(MediaPlayer.INDEFINITE);
        RotateTransition rotate = new RotateTransition(Duration.millis(1500),mylabel);
        rotate.setFromAngle(-10);
        rotate.setToAngle(10);
        rotate.setAutoReverse(true);
        rotate.setCycleCount((int) Double.MAX_VALUE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        music.setOnReady(() -> music.play());

    }
}
