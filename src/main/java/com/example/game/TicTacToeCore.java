package com.example.game;

public class TicTacToeCore {
    private char[][] board; //The board for the game
    private boolean isWin; //Checks the game state for a win
    private boolean isTie; //Checks the game state for a tie
    private int size; //The amount of elements on the board
    private char X = 'X';
    private char O = 'O';
    private char currPlayer;
    private void checkWin(){
        //We got to check from left to right, and from up to down
        // so like [0][0] [0][1] [0][2] |||||| [1][0] [1][1] [1][2] |||||| [2][0] [2][1] [2][2]
        // so like [0][0] [1][0] [2][0] |||||| [0][1] [1][1] [2][1] |||||| [0][2] [1][2] [2][2]
        // Both diagonals
        //so like [0][0] [1][1] [2][2] ||||||| [0][2] [1][1] [2][0]

        //Checks both diagonals
        if(getElement(0,0) == getElement(1,1) && getElement(1,1) == getElement(2,2)){
            isWin = true;
            return;
        }
        if(getElement(0,2) == getElement(1,1) && getElement(1,1) == getElement(2,0)){
            isWin = true;
            return;
        }
        //Checking to the right and down
        for (int i = 0; i < board.length; i++) {
            char first = getElement(i, 0);
            char second = getElement(i, 1);
            char third = getElement(i, 2);
            char seconddown = getElement(1, i);
            char thirddown = getElement(2, i);
            if(first == second && second == third){
                isWin = true;
                break;
            }
            else if(first == seconddown && seconddown == thirddown){
                isWin = true;
                break;
            }
        }

    }
    public TicTacToeCore(){
        board = new char[3][3];
        isWin = false;
        isTie = false;
        size = 0;
        currPlayer = getPlayer();
    }
    //Gets current player based on turn number, even is X, odd is O.
    private char getPlayer(){
        if(size % 2 == 0){
            return X;
        }
        return O;
    }
    //Returns the current element at the board
    public char getElement(int row, int column){
        return board[row][column];
    }
    //Gets win state of the board
    public boolean getWin(){
        return isWin;
    }
    public char getWinPlayer(){
        if(getWin()){
            return currPlayer;
        }
        throw new IllegalArgumentException("No winning player!");
    }
    //Gets TieState of the board
    public boolean isTie(){
        return isTie;
    }
    //Sets the element to the current player
    public void setElement(int row, int column){
        if(getWin()){
            System.out.println(getWinPlayer() + " has already won!");
        }
       else if(board[row][column] == '\u0000'){
            board[row][column] = currPlayer;
            size++;
            checkWin();
        }
        else{
            throw new IllegalArgumentException("Space is currently full!!");
        }
    }

}
