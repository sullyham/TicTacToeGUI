package com.example.game;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    @FXML
    private Label mylabel;
    @FXML
    private ToggleButton toggleButton;
    private MediaPlayer music;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void play(ActionEvent e) throws IOException {
        music.stop();
        setMusic(new Media(Objects.requireNonNull(getClass().getResource("/Music/game-music.mp3")).toExternalForm()));
        music.setVolume(0.2);
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/FXML Files/game.fxml")));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("play_stylesheet.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void setRotate(){
        RotateTransition rotate = new RotateTransition(Duration.millis(1500),mylabel);
        rotate.setFromAngle(-10);
        rotate.setToAngle(10);
        rotate.setAutoReverse(true);
        rotate.setCycleCount((int) Double.MAX_VALUE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
    }
    public void setMusic(Media media){
        music = new MediaPlayer(media);
        music.setCycleCount(MediaPlayer.INDEFINITE);

        music.play();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toggleButton.setText("Mute Music");
        setMusic(new Media(Objects.requireNonNull(getClass().getResource("/Music/menu-music.mp3")).toExternalForm()));
        setRotate();
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
