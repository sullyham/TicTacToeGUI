package com.example.game;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MakeTools {
    public static Label makeLabel(String content, String ID){
        Label label = new Label(content);
        label.setMinWidth(120);
        label.setPrefWidth(120);
        label.setMaxWidth(120);
        label.setAlignment(Pos.CENTER);
        label.getStyleClass().add(ID);
        return label;
    }
    public static Scene makeScene(Parent root, String css){
        Scene scene = new Scene(root,600,600);
        scene.getStylesheets().add(css);
        return scene;
    }
    public static HBox makeHBox(Node one, Node two){
        HBox box = new HBox(one, two);
        box.setAlignment(Pos.CENTER);
        return box;
    }
    public static VBox makeVBox(Node one, Node two, int gap){
        VBox box = new VBox(one, two);
        box.setSpacing(gap);
        box.setAlignment(Pos.CENTER);
        return box;
    }
    public static TextField makeTextField(String ID){
        TextField field = new TextField();
        field.setMaxWidth(120);
        field.getStyleClass().add(ID);
        return field;
    }
    public static PasswordField makePassField(String ID){
        PasswordField field = new PasswordField();
        field.setMaxWidth(120);
        field.getStyleClass().add(ID);
        return field;
    }
    public static Button makeButton(String text, String ID){
        Button button = new Button(text);
        button.getStyleClass().add(ID);
        return button;
    }
}
