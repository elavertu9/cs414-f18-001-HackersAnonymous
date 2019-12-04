package com.hackersanon.banqi.piece;

import com.hackersanon.banqi.board.CoordinateFunctions;

import java.io.Serializable;
import java.util.ArrayList;

public class PieceFunctions implements Serializable
{
    private final PieceAttributes pieceType;
    private final TeamColor team;
    private boolean faceUp = false;


    public PieceFunctions(PieceAttributes pieceType, TeamColor color){
        this.pieceType = pieceType;
        this.team = color;
    }

    public PieceAttributes getPieceType() {
        return pieceType;
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

    public boolean isFaceUp(){
        return faceUp;
    }

    public boolean isValidMove(CoordinateFunctions origin, CoordinateFunctions destination){
        return pieceType.isValidMove(origin, destination);
    }

    public ArrayList<CoordinateFunctions> getValidMoveList(CoordinateFunctions origin){
        return pieceType.legalMoves(origin);
    }

    public boolean canCapture(PieceFunctions enemy){
        return this.pieceType.ordinal() <= enemy.getPieceType().ordinal();//TODO implement exception for general and soldier
    }

    public String toString() {
        if (isFaceUp() && !pieceType.name().equals(PieceAttributes.EMPTY.name())) {
            return team.toString() + pieceType.toString();
        }else if(pieceType.name().equals(PieceAttributes.EMPTY.name())){
            return " ";
        }else {
            return "⯄";

        }
    }
}
