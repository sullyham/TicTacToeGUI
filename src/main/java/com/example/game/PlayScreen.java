package com.example.game;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlayScreen {
    private VBox Play;
    String url = "https://www.clipartmax.com/png/middle/394-3947205_transparent-meteor-pixel-transparent-meteor-pixel.png";

    public PlayScreen(){
        Play = new VBox();
        Image image = new Image(url);
        ImageView imageView = new ImageView(image);
        RotateTransition animation = new RotateTransition(Duration.seconds(4),imageView);
        animation.setFromAngle(0);
        animation.setToAngle(360);
        animation.setInterpolator(Interpolator.LINEAR);
        animation.play();

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
        playmulti.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Node source = (Node) actionEvent.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                Main.swapLocal(stage);
            }
        });
        playmulti.setMinWidth(150);
        Play.getChildren().addAll(title,playlocal,playmulti,imageView);
    }
    public VBox returnPlayScreen(){
        return Play;
    }
}
