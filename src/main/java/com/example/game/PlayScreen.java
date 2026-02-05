package com.example.game;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayScreen {
    private VBox Play;
    public PlayScreen(){
        Play = new VBox();
        Play.setSpacing(30);
        Button playlocal = new Button("Local Game");
        Button playmulti = new Button("LAN Game");
        Play.getChildren().addAll(playlocal,playmulti);
    }





    public VBox returnPlayScreen(){
        return Play;
    }
}
