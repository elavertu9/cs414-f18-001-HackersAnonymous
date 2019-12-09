package com.hackersanon.banqi.model.piece;

import com.hackersanon.banqi.model.board.Coordinate;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Embeddable
public class Piece{


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
        return this.type.canCapture(enemyPiece) && this.teamColor != enemyPiece.getTeamColor();
    }

    public ArrayList<Coordinate> getValidTripCoordinates(Coordinate origin){
        if(this.getFaceUp()) {
            return this.getType().legalMoves(origin);
        }
        else{
            return new ArrayList<>();
        }
    }

}
