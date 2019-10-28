package com.hackersanon.banqi.main.piece;

import com.hackersanon.banqi.main.board.Coordinate;

import java.util.ArrayList;

public enum Piece {
    GENERAL(){
        
    },
    CHARIOT(){

    },
    HORSE(){

    },
    CANNON(){

    },
    ADVISOR(){

    },
    MINSTER(){

    },
    SOLDIER(){

    };
    boolean faceUp;
    private PieceRank rank;
    private TeamColor teamColor;

    Piece(){
    }

    public boolean flipPiece(){
        return false;
    }

    public TeamColor getTeam(){
        return teamColor;
    }

    public boolean isValidMove(Coordinate origin, Coordinate destination){
        return legalMoves(origin).contains(destination);
    }

    private ArrayList<Coordinate> legalMoves(Coordinate origin){
        return new ArrayList<>();
    }





}
