package com.example.game;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

// I NEED TO CLEAN THIS FUCKING CODE LOL
public class PlayScreen {
    private VBox Play;
    String url = "https://www.clipartmax.com/png/middle/394-3947205_transparent-meteor-pixel-transparent-meteor-pixel.png";
    static class Multi{
        private VBox screen;
        private VBox hostscreen;
        private VBox joinscreen;
        public Multi() throws UnknownHostException {
            screen = new VBox();
            screen.setSpacing(30);
            Button Host = new Button("Host");
            Host.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Node source = (Node) actionEvent.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    BorderPane pane = new BorderPane();
                    pane.setCenter(hostscreen);
                    hostscreen.setAlignment(Pos.CENTER);
                    Scene scene = MakeTools.makeScene(pane, "play_stylesheet.css");
                    stage.setScene(scene);
                }
            });
            Host.setMinWidth(150);
            Button join = new Button("Join");
            join.setMinWidth(150);
            screen.getChildren().addAll(Host,join);
            hostscreen = new VBox();
            Label host = new Label("Hosting on " + InetAddress.getLocalHost().getHostAddress() + ":9999");
            Label description = new Label("Waiting for players..");
            hostscreen.getChildren().addAll(host, description);
        }
        public VBox getScreen(){
            return screen;
        }
    }
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
                Main.stopmusic(stage);
            }
        });
        playmulti.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Node source = (Node) actionEvent.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                BorderPane pane = new BorderPane();
                VBox buttons = null;
                try {
                    buttons = new Multi().screen;
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                }
                buttons.setAlignment(Pos.CENTER);
                pane.setCenter(buttons);
                Scene scene = MakeTools.makeScene(pane, "play_stylesheet.css");
                stage.setScene(scene);
            }
        });
        playmulti.setMinWidth(150);
        Play.getChildren().addAll(title,playlocal,playmulti,imageView);
    }
    public VBox returnPlayScreen(){
        return Play;
    }
}
