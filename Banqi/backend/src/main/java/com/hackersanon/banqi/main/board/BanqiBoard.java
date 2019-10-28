package com.hackersanon.banqi.main.board;

import java.util.Arrays;

public class BanqiBoard {
    private Square[][] board;
    private int colDimension = 8;
    private int rowDimension = 4;

    public BanqiBoard(){
        this.board = new Square[rowDimension][colDimension];
    }

    public void initialize(){
        initSquares();
        initPieces();
        //TODO Initialize and Randomize all piece locations on the board.
    }

    private void initSquares(){//TODO Don't like this. Should initialize all squares with pieces to reduce code duplication and unnecessary for loops.
        for (int i = 0; i<board.length;++i){
            for(int j = 0; j<board[i].length;++j){
                board[i][j] = new Square(new Coordinate(i,j));
            }
        }
    }

    private void initPieces(){

    }


}
