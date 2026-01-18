package com.example.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.Scanner;

public class TicTacToeConsole extends Main{
    TicTacToeCore game;
    static GridPane pane;
    private Button makeButton(String tag, int s1, int s2){Button button = new Button(tag); button.setMinSize(s1,s2); return button;}
    public TicTacToeConsole() {
        this.pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(40,40,40,40));

        pane.add();

    }
    public GridPane returnPane(){
        return pane;
    }

    static void main() {
        TicTacToeConsole game = new TicTacToeConsole();
    }
}
