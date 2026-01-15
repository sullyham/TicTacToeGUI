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
    public boolean tie;
    XO currPiece;
    Scanner scnr;
    private void checkForWin(){
        // 00 01 02    // 6 straight lines and && 2 diagonals  //1 2 3
        // 10 11 12                                            //4 5 6
        // 20 21 22                                            //7 8 9
        XO one = board[0][0];
        XO two = board[0][1];
        XO three = board[0][2];
        XO four = board[1][0];
        XO five = board[1][1];
        XO six = board[1][2];
        XO seven = board[2][0];
        XO eight = board[2][1];
        XO nine = board[2][2];

        if(one != null && two  != null && three != null){
            if(one.equals(two) && two.equals(three)){
                win = true;
            }
        }else if(four != null && five  != null && six != null){
            if(four.equals(five) && five.equals(six)){
                win = true;
            }
        }else if(seven != null && eight  != null && nine != null){
            if(seven.equals(eight) && eight.equals(nine)){
                win = true;
            }
        }else if(one != null && four  != null && seven != null){
            if(one.equals(four) && four.equals(seven)){
                win = true;
            }
        }else if(two != null && five  != null && eight != null){
            if(two.equals(five) && five.equals(eight)){
                win = true;
            }
        }else if(three != null && six  != null && nine != null){
            if(three.equals(six) && six.equals(nine)){
                win = true;
            }
        }else if(one != null && five  != null && nine != null){
            if(one.equals(five) && five.equals(nine)){
                win = true;
            }
        }else if(three != null && five  != null && seven != null){
            if(three.equals(five) && five.equals(seven)){
                win = true;
            }
        }
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
        tie = false;
        scnr = new Scanner(System.in);
        while(!win || !tie){
            Turn();
        }
    }

    static void main(){
        TicTacToe game = new TicTacToe();
        System.out.println(game.board);
    }
}
