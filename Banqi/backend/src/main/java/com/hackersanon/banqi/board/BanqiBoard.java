package com.hackersanon.banqi.board;

import com.hackersanon.banqi.piece.Piece;
import com.hackersanon.banqi.piece.TeamColor;
import com.hackersanon.banqi.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.hackersanon.banqi.piece.PieceAttributes.*;

public class BanqiBoard {
    private Square[][] board;
    private int colDimension = 8;
    private int rowDimension = 4;


    public BanqiBoard(ArrayList<Player> playerList){
        this.board = new Square[rowDimension][colDimension];
    }

    public void initialize(){
        initSquares(initAllPieces());
        //TODO Initialize and Randomize all piece locations on the board.
    }

    private void initSquares(ArrayList<Piece> allPieces){//TODO Don't like this. Should initialize all squares with pieces to reduce code duplication and unnecessary for loops.
        for (int i = 0; i<board.length;++i){
            for(int j = 0; j<board[i].length;++j){
                board[i][j] = new Square(new Coordinate(i,j));
            }
        }
    }

    private ArrayList<Piece> initAllPieces(){
        ArrayList<Piece> allPieces = new ArrayList<>(initTeamPieces(TeamColor.RED));
        allPieces.addAll(initTeamPieces(TeamColor.BLACK));
        Collections.shuffle(allPieces);
        for(Piece piece: allPieces){
            System.out.println(piece.toString());
        }
       return allPieces;
    }

    private ArrayList<Piece> initTeamPieces(TeamColor color){
        return new ArrayList<>(Arrays.asList( new Piece(GENERAL, color),
                new Piece(CHARIOT, color), new Piece(CHARIOT, color),
                new Piece(HORSE, color), new Piece(HORSE, color),
                new Piece(CANNON, color), new Piece(CANNON, color),
                new Piece(ADVISOR, color), new Piece(ADVISOR, color),
                new Piece(MINSTER, color), new Piece(MINSTER, color),
                new Piece(SOLDIER, color), new Piece(SOLDIER, color),
                new Piece(SOLDIER, color), new Piece(SOLDIER, color),new Piece(SOLDIER, color)));
    }




}
