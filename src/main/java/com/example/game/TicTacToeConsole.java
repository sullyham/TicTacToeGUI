package com.example.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeConsole extends Main{
    TicTacToeCore game;
    GridPane pane;
    Label labelhold;
    List<Button> buttonList;
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
                labelhold.setText(game.getPlayer() + " has won!");
                for(Button button: buttonList){
                    button.setDisable(true);
                }
            }
        }
    }
    public TicTacToeConsole() {
        buttonList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            buttonList.add(makeButton("",90,90));
        }
        game = new TicTacToeCore();
        this.pane = new GridPane();
        this.labelhold = new Label();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(90,90,90,90));
        labelhold = new Label("");
         for(int i = 0; i < 9; i+=3){
             int row = (i/3);
             buttonList.get(i).setOnAction(new ButtonAction(buttonList.get(i),row, 0));
             buttonList.get(i+1).setOnAction(new ButtonAction(buttonList.get(i+1),row, 1));
             buttonList.get(i+2).setOnAction(new ButtonAction(buttonList.get(i+2),row, 2));
             pane.add(buttonList.get(i),row,0);
             pane.add(buttonList.get(i+1),row,1);
             pane.add(buttonList.get(i+2),row,2);
         }
         pane.add(labelhold, 1,0);
    }
    public GridPane returnPane(){
        return pane;
    }

    static void main() {
        TicTacToeConsole game = new TicTacToeConsole();
    }
}
