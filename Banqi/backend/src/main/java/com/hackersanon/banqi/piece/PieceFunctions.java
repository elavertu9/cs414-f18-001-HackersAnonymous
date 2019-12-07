package com.hackersanon.banqi.piece;

import com.hackersanon.banqi.database.model.Coordinate;
import com.hackersanon.banqi.database.model.Piece;

import java.io.Serializable;
import java.util.ArrayList;

public class PieceFunctions implements Serializable
{

    public static ArrayList<Coordinate> getValidMoveList(Coordinate origin, Piece piece){
        return piece.getType().legalMoves(origin);
    }

    public static boolean canCapture(Piece attacker,Piece enemy){
        if(attacker.getType().ordinal() == 6 && enemy.getType().ordinal() == 0){
            return false;
        }
        else if (attacker.getType().ordinal() == 1 && enemy.getType().ordinal() == 6){
            return true;
        }else {
            return (attacker.getType().ordinal() <= enemy.getType().ordinal()) && enemy.getFaceUp() && attacker.getFaceUp();
        }
    }


}
