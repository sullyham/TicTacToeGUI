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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    Label wincond;

    static void main(String[] args) {
        launch(args);
    }
    //DAMN
    @Override
    public void start(Stage stage) throws Exception {
        //The top that shows who wins!
        //Calling my game class

//        TicTacToeConsole gamer = new TicTacToeConsole();
//        BorderPane pane = new BorderPane();
//        GridPane pane2 = gamer.returnPane();
//        Scene game = MakeTools.makeScene(pane, "stylesheet.css");
//        pane.setCenter(pane2); //TicTacToe Board
//        pane.setTop(gamer.returnLabel()); //Win Condition

        PlayScreen screen = new PlayScreen();
        BorderPane playboard = new BorderPane();
        VBox buttons = screen.returnPlayScreen();
        Scene playscreen = MakeTools.makeScene(playboard, "stylesheet.css");
        playboard.setCenter(buttons);
        buttons.setAlignment(Pos.CENTER);
        stage.getIcons().add(new Image("instagram.png"));
        stage.setScene(playscreen);
        stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
