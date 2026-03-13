package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    TicTacToeCore core;

    @FXML
    Button one,two,three,four,five,six,seven,eight,nine;
    String px = "X's turn!";
    String po = "O's turn!";
    @FXML
    Label announce;
    List<Button> buttons;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        core = new TicTacToeCore();
        announce.setText(px);
        buttons = Arrays.asList(one,two,three,four,five,six,seven,eight,nine);
    }

    public void PlaceElement(ActionEvent e){
        Button button = (Button) e.getSource();
       int x = (GridPane.getRowIndex(button) != null) ? (GridPane.getRowIndex(button) - 1) : 0;
       int y = (GridPane.getColumnIndex(button) != null) ? (GridPane.getColumnIndex(button)) : 0;
       button.setText(String.valueOf(core.getPlayer()));
       core.setElement(x,y);
       if(core.getWin()){
           for(Button b: buttons){
               b.setDisable(true);
           }
           announce.setText(core.getPlayer() + " has won!");
       }
       else {
           button.setDisable(true);
           if(core.getPlayer() == 'X'){
               announce.setText(px);
           }
           else{
               announce.setText(po);
           }
       }
    }
}
