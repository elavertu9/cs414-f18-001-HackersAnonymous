package com.hackersanon.banqi.board;

import com.hackersanon.banqi.database.model.Piece;
import com.hackersanon.banqi.database.model.Square;

import static com.hackersanon.banqi.piece.PieceAttributes.EMPTY;
import static com.hackersanon.banqi.piece.TeamColor.NEUTRAL;

public class SquareFunctions
{
    public static Piece occupySquare(Square square, Piece piece){
        Piece captured = null;
        if(square.checkOccupied()) {
            captured = square.getPiece();
        }
        square.setPiece(piece);
        return captured;
    }

    public static void vacateSquare(Square square){
        square.setPiece(new Piece(EMPTY, NEUTRAL));
    }

   public static boolean checkOccupied(Square square){
        return (square.getPiece().getType() != EMPTY);
   }
}
