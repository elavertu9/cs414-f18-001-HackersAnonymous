package com.hackersanon.banqi.piece;

import com.hackersanon.banqi.board.Coordinate;

public class Piece {
    private final PieceAttributes pieceType;
    private final TeamColor team;
    private boolean faceUp = false;

    public Piece(PieceAttributes pieceType, TeamColor color){
        this.pieceType = pieceType;
        this.team = color;
    }

    public String getPieceType() {
        return pieceType.toString();
    }

    public TeamColor getTeam() {
        return team;
    }

    public boolean flipPiece(){
        if(!faceUp){
            return (faceUp = true);
        }else{
            return false;
        }
    }

    public boolean isValidMove(Coordinate origin, Coordinate destination){
        return pieceType.isValidMove(origin, destination);
    }



    public String toString(){
        return team.toString()+pieceType.toString();
    }
}
