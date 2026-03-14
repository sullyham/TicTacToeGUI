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
    private void setTie(){
        disableallButtons();
        setLText("It's a tie!");
    }

    private void setWin(){
        disableallButtons();
        setLText(core.getPlayer() + " has won!");
    }
    private void disableallButtons(){
        for(Button b: buttons){
            b.setDisable(true);
        }
    }
    private void setLText(String text){
        announce.setText(text);
    }
    private void setText(Button button, String text){
        button.setText(text);
    }
    private int getX(Button button){
        //If considered null, then we assign zero, cuz for some reason it is zero
        //Otherwise we just subtract the index by 1
        return (GridPane.getRowIndex(button) != null) ? (GridPane.getRowIndex(button) - 1) : 0;
    }
    private int getY(Button button){
        //If considered null, then we assign zero, cuz for some reason it is zero
        //Otherwise we just subtract the index by 1
        return (GridPane.getColumnIndex(button) != null) ? (GridPane.getColumnIndex(button)) : 0;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        core = new TicTacToeCore();
        announce.setText(px);
        buttons = Arrays.asList(one,two,three,four,five,six,seven,eight,nine);
    }

    public void PlaceElement(ActionEvent e){
        Button button = (Button) e.getSource();
       int x = getX(button);
       int y = getY(button);
       String currplayer = String.valueOf(core.getPlayer());
       setText(button,currplayer);
       core.setElement(x,y);
       if(core.getWin()){
           setWin();
       }
       else if(core.isTie()){
           setTie();
       }
       else {
          setLText((currplayer.equals("X")) ? px : po);
       }
    }
}
