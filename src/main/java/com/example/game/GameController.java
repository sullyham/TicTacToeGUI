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


    //Initializes the actual game, and adds all buttons to a list.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        core = new TicTacToeCore();
        announce.setText(px);
        buttons = Arrays.asList(one,two,three,four,five,six,seven,eight,nine);
    }
    //This method places the player's current piece, at the desired place on the board.
    public void PlaceElement(ActionEvent e){
        //Getting the actual button, so we can modify it.
        Button button = (Button) e.getSource();
        //Places the piece on the button.
        placePiece(button);
        //Checks whether a win or tie has occured.
        checkGameState();
    }
    //Sets the tie condition for the game, by disabling all buttons, and changing the top label.
    private void setTie(){
        disableallButtons();
        setLText("It's a tie!");
    }
    //Sets the win condition for the game, by disabling all buttons, and changing the top label.
    private void setWin(){
        disableallButtons();
        setLText(core.getPlayer() + " has won!");
    }
    //Disables all the buttons in the GUI.
    private void disableallButtons(){
        for(Button b: buttons){
            b.setDisable(true);
        }
    }
    //Changes the text of the top label.
    private void setLText(String text){
        announce.setText(text);
    }
    //Changes the text of a button.
    private void setText(Button button, String text){
        button.setText(text);
    }
    //Gets the row index of a button.
    private int getX(Button button){
        //If considered null, then we assign zero, cuz for some reason it is zero
        //Otherwise we just subtract the index by 1
        return (GridPane.getRowIndex(button) != null) ? (GridPane.getRowIndex(button) - 1) : 0;
    }
    //Gets the column index for a button.
    private int getY(Button button){
        //If considered null, then we assign zero, cuz for some reason it is zero
        //Otherwise we just subtract the index by 1
        return (GridPane.getColumnIndex(button) != null) ? (GridPane.getColumnIndex(button)) : 0;
    }
    //This method checks the current game state, and updates the GUI based on that.
    private void checkGameState(){
        String currplayer = String.valueOf(core.getPlayer());
        if(core.getWin()){
            setWin();
        }
        else if(core.isTie()){
            setTie();
        }
        else {
            //Sets the label to "X's turn!" OR "Y's turn!".
            setLText((currplayer.equals("X")) ? px : po);
        }
    }
    //This method gets the x and y coordinates of the button, and places an element at that location.
    private void placePiece(Button button){
        int x = getX(button);
        int y = getY(button);
        String currplayer = String.valueOf(core.getPlayer());
        setText(button,currplayer);
        core.setElement(x,y);
    }


}
