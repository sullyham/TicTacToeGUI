package com.example.game;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginScreen extends Main{

    static VBox finished;
    public LoginScreen(){
        BorderPane pane = new BorderPane();
        Scene scene = makeScene(pane, "stylesheet.css");
        TextField usertext = makeTextField("user-pass-field");
        PasswordField passtext =  makePassField("user-pass-field");
        Button loginbutton = makeButton("Login", "login-button");


        HBox user = makeHBox(makeLabel("Username:", "user-pass"),usertext);
        HBox pass = makeHBox(makeLabel("Password:", "user-pass"),passtext);
        VBox login = makeVBox(user,pass,10);

        VBox loginer = makeVBox(login, loginbutton,20);
        Label success = makeLabel("", "success-field");
        success.setMaxWidth(Double.MAX_VALUE);

        finished = makeVBox(loginer, success,20);

        loginbutton.setOnMouseClicked(mouseEvent -> new LoginEvent(usertext, passtext, success).handle(mouseEvent));
    }
    public VBox getLoginScreen(){
        return finished;
    }
}
