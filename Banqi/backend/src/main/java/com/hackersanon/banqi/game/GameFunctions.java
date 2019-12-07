package com.hackersanon.banqi.game;

import com.hackersanon.banqi.board.InvalidCoordinateException;
import com.hackersanon.banqi.database.model.Board;
import com.hackersanon.banqi.database.model.Coordinate;

import java.util.ArrayList;


public class GameFunctions
{

    public static boolean isGameOver(){
        return false; //TODO need to implement isGameOver()
    }

    public ArrayList<Coordinate> getValidMoves(Board board, Coordinate origin) throws InvalidCoordinateException {
        return board.getSquare(origin).getPiece().getValidTripCoordinates(origin);
    }

}
