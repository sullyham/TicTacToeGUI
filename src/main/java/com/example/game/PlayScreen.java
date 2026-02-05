package com.example.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayScreen {
    private VBox Play;
    public PlayScreen(){
        Play = new VBox();
        Label title = new Label("TIC-TAC-TOE");
        Play.setSpacing(30);
        Button playlocal = new Button("Local Game");
        playlocal.setMinWidth(150);
        Button playmulti = new Button("LAN Game");
        playlocal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Node source = (Node) actionEvent.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                Main.swapLocal(stage);
            }
        });
        playmulti.setMinWidth(150);
        Play.getChildren().addAll(title,playlocal,playmulti);
    }
    public VBox returnPlayScreen(){
        return Play;
    }
}
