package com.example.game;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.util.Objects;

//REFACTOR BRANCH
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.getIcons().add(new Image("instagram.png"));
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/javafx.fxml")));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("play.stylesheet.css");
        stage.setScene(scene);
        stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
