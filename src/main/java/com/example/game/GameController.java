package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    TicTacToeCore core;
    @FXML

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        core = new TicTacToeCore();
    }

    public void PlaceElement(ActionEvent e){
        Button button = (Button) e.getSource();
       int x = (GridPane.getRowIndex(button) != null) ? (GridPane.getRowIndex(button)) : 0;
       int y = (GridPane.getColumnIndex(button) != null) ? (GridPane.getColumnIndex(button)) : 0;
       button.setText(String.valueOf(core.getPlayer()));
       core.setElement(x,y);
       button.setDisable(true);
    }
    public void WinState(ActionEvent event){
        Button button = (Button) event.getSource();
        button.setDisable(true);
    }
}
