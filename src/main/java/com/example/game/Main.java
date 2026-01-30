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
        TicTacToeConsole gamer = new TicTacToeConsole();
        //Borderpane to put grid in center, and win condition at the top?
        BorderPane pane = new BorderPane();
        //This is the gridpane which represents the tictactoe board!
        GridPane pane2 = gamer.returnPane();
        Scene game = MakeTools.makeScene(pane, "stylesheet.css");
        pane.setCenter(pane2);
        pane.setTop(wincond);
        stage.getIcons().add(new Image("instagram.png"));
        stage.setScene(game);
        stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
