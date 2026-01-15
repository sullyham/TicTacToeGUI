package com.example.game;

import java.util.Objects;
import java.util.Scanner;

class XO{
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        XO xo = (XO) o;
        return isX == xo.isX && isO == xo.isO;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isX, isO);
    }

    public boolean isX;
    public boolean isO;

    public XO(int turn){
        //Initializes at X or O's turn!
        if(turn % 2 == 0){
            isX = true;
            isO = false;
        }
        else{
            isX = false;
            isO = true;
        }
    }
}

public class TicTacToe {
    XO[][] board; //2D array of board
    int turn; //Tracks the specific turn, if odd, X's turn, else O
    int size; //Tracks the total size of the board, if == 9, and none of the win cond is met, it's a tie
    public boolean win;
    XO currPiece;
    Scanner scnr;
    private void checkForWin(){
        //Win happens when either +10 or +2

    }
    private boolean IfEmpty(XO piece, int id1, int id2){
        if (piece == null) {
            board[id1][id2] = currPiece;
            turn++;
            return true;
        }
        return false;
    }
    private void placepiece(){
        boolean placed = false; //Forces user to place at valid spot!
        do{
            System.out.println("Please choose a place 1-9 to place your piece");
            int place = scnr.nextInt();
        switch(place) {
            case 1:
                if (IfEmpty(board[0][0],0,0)) {
                    placed = true;
                }
                else{
                    System.out.println("SPACE IS ALREADY FULL!");
                }
                break;
            case 2:
                if (IfEmpty(board[0][1],0,1)) {
                    placed = true;
                }
                else{
                    System.out.println("SPACE IS ALREADY FULL!");
                }
                break;
            case 3:
                if (IfEmpty(board[0][2],0,2)) {
                    placed = true;
                }
                else{
                    System.out.println("SPACE IS ALREADY FULL!");
                }
                break;
            case 4:
                if (IfEmpty(board[1][0],1,0)) {
                    placed = true;
                }
                else{
                    System.out.println("SPACE IS ALREADY FULL!");
                }
                break;
            case 5:
                if (IfEmpty(board[1][1],1,1)) {
                    placed = true;
                }
                else{
                    System.out.println("SPACE IS ALREADY FULL!");
                }
                break;
            case 6:
                if (IfEmpty(board[1][2],1,2)) {
                    placed = true;
                }
                else{
                    System.out.println("SPACE IS ALREADY FULL!");
                }
                break;
            case 7:
                if (IfEmpty(board[2][0],2,0)) {
                    placed = true;
                }
                else{
                    System.out.println("SPACE IS ALREADY FULL!");
                }
                break;
            case 8:
                if (IfEmpty(board[2][1],2,1)) {
                    placed = true;
                }
                else{
                    System.out.println("SPACE IS ALREADY FULL!");
                }
                break;
            case 9:
                if (IfEmpty(board[2][2],2,2)) {
                    placed = true;
                }
                else{
                    System.out.println("SPACE IS ALREADY FULL!");
                }
                break;
        }
        }while(!placed);
    }
    private void Turn(){
        if(turn % 2 != 0){
            System.out.println("It is X's turn!");
        }
        else{
            System.out.println("It is O's turn!");
        }
        currPiece = new XO(turn);

        placepiece();


    }
    public TicTacToe(){
        board = new XO[3][3];
        //I want to start with X... Turn system...?
        turn = 1;
        size = 0;
        win = false;
        scnr = new Scanner(System.in);
        while(!win){
            Turn();
        }
    }

    static void main(){
        TicTacToe game = new TicTacToe();
        System.out.println(game.board);
    }
}
