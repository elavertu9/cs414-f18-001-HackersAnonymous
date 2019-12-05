package com.hackersanon.banqi.piece;

import com.hackersanon.banqi.board.CoordinateFunctions;

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
    },
    EMPTY(){
    };

    PieceAttributes(){}
    public String toString(){
        return this.name();
    }

    public boolean isValidMove(CoordinateFunctions origin, CoordinateFunctions destination){
        return legalMoves(origin).contains(destination);
    }

    public ArrayList<CoordinateFunctions> legalMoves(CoordinateFunctions origin){
        ArrayList<CoordinateFunctions> legalMoves = new ArrayList<>();
        addLegalMove(new CoordinateFunctions(origin.getRow()+1,origin.getColumn()), legalMoves);
        addLegalMove(new CoordinateFunctions(origin.getRow()-1,origin.getColumn()), legalMoves);
        addLegalMove(new CoordinateFunctions(origin.getRow(),origin.getColumn()+1), legalMoves);
        addLegalMove(new CoordinateFunctions(origin.getRow(),origin.getColumn()-1), legalMoves);
        return legalMoves;
    }

    private static void addLegalMove(CoordinateFunctions destination, ArrayList<CoordinateFunctions> legalMoves){
        if(destination.isValid()){
            legalMoves.add(destination);
        }
    }

}
