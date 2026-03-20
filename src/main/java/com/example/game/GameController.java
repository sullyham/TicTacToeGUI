package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    Stage stage;
    AudioClip place;
    TicTacToeCore core;
    @FXML
    Button one,two,three,four,five,six,seven,eight,nine;
    String px = "X's turn!";
    String po = "O's turn!";
    @FXML
    Label announce;
    @FXML
    BorderPane bpane;
    List<Button> buttons;

    //Initializes the actual game, and adds all buttons to a list.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (location.toString().endsWith("game.fxml")) {
            System.out.println(location.toString());
            place = new AudioClip((Objects.requireNonNull(getClass().getResource("/Sound Effect/place-player.mp3")).toExternalForm()));
            core = new TicTacToeCore();
            announce.setText(px);
            buttons = Arrays.asList(one,two,three,four,five,six,seven,eight,nine);
        }
    }
    //This method places the player's current piece, at the desired place on the board.
    public void PlaceElement(ActionEvent e) throws IOException {
        //Getting the actual button, so we can modify it.
        Button button = (Button) e.getSource();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        //Places the piece on the button.
        placePiece(button);
        place.play();
        //Checks whether a win or tie has occurred.
        checkGameState();
    }
    //Sets the tie condition for the game, by disabling all buttons, and changing the top label.
    private void setTie(){
        disableButtons();
        setLText("It's a tie!");
    }
    private void dosomething() throws IOException {
        announce.setText("");
        MainMenuController.music.stop();
        MainMenuController.setMusic(new Media(Objects.requireNonNull(getClass().getResource("/Sound Effect/winner-sound.mp3")).toExternalForm()));
        Label win = new Label(core.getPlayer() + " has won!!!");
        win.setStyle("-fx-font-size: 60;");
        bpane.setCenter(win);
    }

    //Sets the win condition for the game, by disabling all buttons, and changing the top label.
    private void setWin() throws IOException {
        disableButtons();
        System.out.println("wewe");
        dosomething();
    }
    //Disables all the buttons in the GUI.
    private void disableButtons(){
        for(Button b: buttons) b.setDisable(true);
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
        return (GridPane.getRowIndex(button) != null) ? (GridPane.getRowIndex(button)) : 0;
    }
    //Gets the column index for a button.
    private int getY(Button button){
        //If considered null, then we assign zero, cuz for some reason it is zero
        //Otherwise we just subtract the index by 1
        return (GridPane.getColumnIndex(button) != null) ? (GridPane.getColumnIndex(button)) : 0;
    }
    //This method checks the current game state, and updates the GUI based on that.
    private void checkGameState() throws IOException {
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
