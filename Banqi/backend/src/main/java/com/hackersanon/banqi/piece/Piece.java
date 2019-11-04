package com.hackersanon.banqi.piece;

import com.hackersanon.banqi.board.Coordinate;

import java.util.ArrayList;

public class Piece {
    private final PieceAttributes pieceType;
    private final TeamColor team;
    private boolean faceUp = false;


    public Piece(PieceAttributes pieceType, TeamColor color){
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

    public boolean isValidMove(Coordinate origin, Coordinate destination){
        return pieceType.isValidMove(origin, destination);
    }

    public ArrayList<Coordinate> getValidMoveList(Coordinate origin){
        return pieceType.legalMoves(origin);
    }

    public boolean canCapture(Piece enemy){
        return this.pieceType.ordinal() <= enemy.getPieceType().ordinal();//TODO implement exception for general and soldier
    }

    public String toString(){
        return team.toString()+pieceType.toString();
    }
}
