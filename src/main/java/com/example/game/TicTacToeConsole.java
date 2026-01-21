package com.example.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.Scanner;

public class TicTacToeConsole extends Main{
    TicTacToeCore game;
    GridPane pane;
    VBox labelhold;
    Label description;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    private Button makeButton(String tag, int s1, int s2){Button button = new Button(tag); button.setMinSize(s1,s2); return button;}
    class ButtonAction implements EventHandler<ActionEvent>{
        int pos1;
        int pos2;
        Button button;
        public ButtonAction(Button button,int pos1, int pos2){
            this.pos1 = pos1;
            this.pos2 = pos2;
            this.button = button;
        }
        @Override
        public void handle(ActionEvent actionEvent) {
            button.setText(String.valueOf(game.getPlayer()));
            game.setElement(pos1,pos2);
            button.setDisable(true);
            if(game.getWin() || game.isTie()){
                button1.setDisable(true);
                button2.setDisable(true);
                button3.setDisable(true);
                button4.setDisable(true);
                button5.setDisable(true);
                button6.setDisable(true);
                button7.setDisable(true);
                button8.setDisable(true);
                button9.setDisable(true);
            }
        }
    }
    public TicTacToeConsole() {
        game = new TicTacToeCore();
        this.pane = new GridPane();
        this.labelhold = new VBox();
        labelhold.set
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(90,90,90,90));
         button1 = makeButton("",90,90);
         button2 = makeButton("",90,90);
         button3 = makeButton("",90,90);
         button4 = makeButton("",90,90);
         button5 = makeButton("",90,90);
         button6 = makeButton("",90,90);
         button7 = makeButton("",90,90);
         button8 = makeButton("",90,90);
         button9 = makeButton("",90,90);
        pane.add(button1,0,0);
        pane.add(button2,0,1);
        pane.add(button3,0,2);
        pane.add(button4,1,0);
        pane.add(button5,1,1);
        pane.add(button6,1,2);
        pane.add(button7,2,0);
        pane.add(button8,2,1);
        pane.add(button9,2,2);
        button1.setOnAction(new ButtonAction(button1,0,0));
        button2.setOnAction(new ButtonAction(button2,0,1));
        button3.setOnAction(new ButtonAction(button3,0,2));
        button4.setOnAction(new ButtonAction(button4,1,0));
        button5.setOnAction(new ButtonAction(button5,1,1));
        button6.setOnAction(new ButtonAction(button6,1,2));
        button7.setOnAction(new ButtonAction(button7,2,0));
        button8.setOnAction(new ButtonAction(button8,2,1));
        button9.setOnAction(new ButtonAction(button9,2,2));
    }
    public GridPane returnPane(){
        return pane;
    }
    public VBox returnBox(){}

    static void main() {
        TicTacToeConsole game = new TicTacToeConsole();
    }
}
