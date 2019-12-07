package com.hackersanon.banqi.piece;

import com.hackersanon.banqi.database.model.Coordinate;
import com.hackersanon.banqi.database.model.Piece;

import java.util.ArrayList;

public enum PieceAttributes {
    GENERAL(){
       @Override
       public boolean canCapture(Piece enemy){
           return enemy.getType().ordinal() != 6;
       }
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
       @Override
       public boolean canCapture(Piece enemy){
           return enemy.getType().ordinal() == 6 || enemy.getType().ordinal() == 0;
       }
    },
    EMPTY(){
    };

    public String toString(){
        return this.name();
    }

    public boolean isValidMove(Coordinate origin, Coordinate destination){
        return legalMoves(origin).contains(destination);
    }

    public ArrayList<Coordinate> legalMoves(Coordinate origin){
        ArrayList<Coordinate> legalMoves = new ArrayList<>();
        addLegalMove(new Coordinate(origin.getRow()+1,origin.getColumn()), legalMoves);
        addLegalMove(new Coordinate(origin.getRow()-1,origin.getColumn()), legalMoves);
        addLegalMove(new Coordinate(origin.getRow(),origin.getColumn()+1), legalMoves);
        addLegalMove(new Coordinate(origin.getRow(),origin.getColumn()-1), legalMoves);
        return legalMoves;
    }

    private static void addLegalMove(Coordinate destination, ArrayList<Coordinate> legalMoves){
        if(destination.valid()){
            legalMoves.add(destination);
        }
    }

    public boolean canCapture(Piece enemy){
            return this.ordinal() <= enemy.getType().ordinal();
    }

}
