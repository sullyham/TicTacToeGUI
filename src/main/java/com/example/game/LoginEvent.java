package com.example.game;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginEvent implements EventHandler<MouseEvent> {
    private TextField user;
    private PasswordField pass;
    private Label success;

    public LoginEvent(TextField user, PasswordField pass, Label success){
        this.user = user;
        this.pass = pass;
        this.success = success;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        if(user.getText().equals("sully") && pass.getText().equals("1234")){
            success.setText("Login successful!");
            success.getStyleClass().remove("fail");
            success.getStyleClass().add("success");
        }
        else{
            success.setText("Incorrect Username or Password!");
            success.getStyleClass().add("fail");
        }
    }

}
