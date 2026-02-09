package com.example.game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    static MediaPlayer mediaPlayer;
    static void main(String[] args) {
        launch(args);
    }
    //DAMN
    public static void swapLocal(Stage stage){
        TicTacToeConsole gamer = new TicTacToeConsole();
        BorderPane pane = new BorderPane();
        GridPane pane2 = gamer.returnPane();
        Scene game = MakeTools.makeScene(pane, "stylesheet.css");
        pane.setCenter(pane2); //TicTacToe Board
        pane.setTop(gamer.returnLabel()); //Win Condition
        stage.setScene(game);
    }
    public static void stopmusic(Stage stage){
        mediaPlayer.stop();
    }
    public static void swapMulti(Stage stage){

    }
    @Override
    public void start(Stage stage) throws Exception {
        //The top that shows who wins!
        //Calling my game class
        Media m = new Media("https://sullyham.github.io/game-audio/Audio/MenuMusic.mp3");
        mediaPlayer = new MediaPlayer(m);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        PlayScreen screen = new PlayScreen();
        BorderPane playboard = new BorderPane();
        VBox buttons = screen.returnPlayScreen();
        Scene playscreen = MakeTools.makeScene(playboard, "play_stylesheet.css");
        playboard.setCenter(buttons);
        buttons.setAlignment(Pos.CENTER);
        stage.getIcons().add(new Image("instagram.png"));
        stage.setScene(playscreen);
        stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
