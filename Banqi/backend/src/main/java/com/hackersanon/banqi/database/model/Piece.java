package com.hackersanon.banqi.database.model;

import com.hackersanon.banqi.piece.PieceAttributes;
import com.hackersanon.banqi.piece.TeamColor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Piece {


    @NotNull
    private PieceAttributes type;
    @NotNull
    private TeamColor teamColor;

    private boolean faceUp = false;

    public Piece(){
    }

    public Piece(PieceAttributes type, TeamColor teamColor){
        this.type = type;
        this.teamColor = teamColor;
    }

    public void setType(PieceAttributes type) {
        this.type = type;
    }

    public PieceAttributes getType(){
        return this.type;
    }

    public void setTeamColor(TeamColor teamColor){
        this.teamColor = teamColor;
    }

    public TeamColor getTeamColor(){
        return this.teamColor;
    }

    public void setFaceUp(boolean faceUp){
        this.faceUp = faceUp;
    }

    public boolean getFaceUp(){
        return this.faceUp;
    }

    public boolean canCapture(Piece enemyPiece){
        return false;
    }

}
