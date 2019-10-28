package com.hackersanon.banqi.main.piece;

public abstract class Piece {
    boolean faceUp;
    private PieceRank rank;
    private TeamColor team;

    public Piece(TeamColor color){
        this.team = color;
    }

    public boolean flipPiece(){
        return false;
    }

    public TeamColor getTeam(){
        return team;
    }





}
