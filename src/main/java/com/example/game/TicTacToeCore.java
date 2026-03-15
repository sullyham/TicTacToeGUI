package com.example.game;

import java.util.Arrays;

public class TicTacToeCore {
    private final char[][] board; //The board for the game
    private boolean isWin; //Checks the game state for a win
    private int size; //The amount of elements on the board
    private char currPlayer;
    public TicTacToeCore(){
        board = new char[3][3];
        isWin = false;
        size = 0;
        currPlayer = getPlayer();
    }
    //Sets the element to the current player
    public void setElement(int row, int column){
        board[row][column] = currPlayer;
        checkState(row, column);
        if(!isTie() && !isWin) {
            size++;
            currPlayer = getPlayer();
        }
    }
    private void checkState(int row, int column){
        //Checks if the element was placed in an area where diags can exist.
        boolean isDiag = row == column || row == 0 && column == 2 || row == 2 && column == 0;
        char empty = '\u0000';
        //Checks the row
        if(board[row][column] != empty && board[row][0] == board[row][1] && board[row][0] == board[row][2]){
            isWin = true;
        }
        //Checks the column
        else if(board[row][column] != empty && board[0][column] == board[1][column] && board[0][column] == board[2][column]){
            isWin = true;
        }
        //Checks the left diag
        else if(isDiag && board[0][0] != empty && board[0][0] == board[1][1] && board[0][0] == board[2][2]){
            isWin = true;
        }
        //Checks the right diag
        else if(isDiag && board[0][2] != empty && board[0][2] == board[1][1] && board[0][2] == board[2][0]){
            isWin = true;
        }
    }
    //Gets current player based on turn number, even is X, odd is O.
    public char getPlayer(){
        if(size % 2 == 0){
            return 'X';
        }
        return 'O';
    }
    //Returns the current element at the board
    public char getElement(int row, int column){
        return board[row][column];
    }
    //Gets win state of the board
    public boolean getWin(){
        return isWin;
    }
    //Gets TieState of the board
    public boolean isTie(){
        return size == 9;
    }
}
