package com.hackersanon.banqi.game;

import com.hackersanon.banqi.board.BoardFunctions;
import com.hackersanon.banqi.board.InvalidCoordinateException;
import com.hackersanon.banqi.database.model.Board;
import com.hackersanon.banqi.database.model.Coordinate;
import com.hackersanon.banqi.piece.PieceFunctions;

import java.util.ArrayList;


public class GameFunctions
{

    public static boolean isGameOver(){
        return false; //TODO need to implement isGameOver()
    }

    public ArrayList<Coordinate> getValidMoves(Board board, Coordinate origin) throws InvalidCoordinateException {
        return PieceFunctions.getValidMoveList(origin,BoardFunctions.getSquare(board,origin).getPiece());
    }

}
