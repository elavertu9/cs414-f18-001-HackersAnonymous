package com.hackersanon.banqi.piece;

import com.hackersanon.banqi.board.Coordinate;

import java.util.ArrayList;

public enum PieceAttributes {
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

    public String toString(){
        return this.name();
    }

    public boolean isValidMove(Coordinate origin, Coordinate destination){
        return legalMoves(origin).contains(destination);
    }

    private ArrayList<Coordinate> legalMoves(Coordinate origin){
        ArrayList<Coordinate> legalMoves = new ArrayList<>();
        addLegalMove(new Coordinate(origin.getRow()+1,origin.getColumn()), legalMoves);
        addLegalMove(new Coordinate(origin.getRow()-1,origin.getColumn()), legalMoves);
        addLegalMove(new Coordinate(origin.getRow(),origin.getColumn()+1), legalMoves);
        addLegalMove(new Coordinate(origin.getRow(),origin.getColumn()-1), legalMoves);
        return legalMoves;
    }

    private static void addLegalMove(Coordinate destination, ArrayList<Coordinate> legalMoves){
        if(Coordinate.isCoordinateValid(destination.getRow(), destination.getColumn())){
            legalMoves.add(destination);
        }
    }

}
