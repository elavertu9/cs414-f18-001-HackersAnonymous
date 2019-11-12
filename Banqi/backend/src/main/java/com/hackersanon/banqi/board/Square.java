package com.hackersanon.banqi.board;

import com.hackersanon.banqi.piece.Piece;

import static com.hackersanon.banqi.piece.PieceAttributes.EMPTY;
import static com.hackersanon.banqi.piece.TeamColor.NEUTRAL;

public class Square {
    private Piece storedPiece;
    private Coordinate coordinate;
    String piece;
    String position;
    String color;

    Square(Coordinate coordinate, Piece piece){
        this.coordinate = coordinate;
        this.storedPiece = piece;
        updateValues();
    }

    protected Square(Coordinate coordinate){
        this(coordinate,null);
    }

    void updateValues(){
        this.color = storedPiece.getTeam().toString();
        this.piece = storedPiece.getPieceType().toString();
        this.position = coordinate.getStringPosition();
    }

    public String getPiece(){
        return piece;
    }

    public String getPosition(){
        return position;
    }

    public String getColor(){
        return color;
    }

    public Piece getStoredPiece(){
        return storedPiece;
    }



    public Coordinate getCoordinate(){
        return coordinate;
    }

    public Piece occupySquare(Piece newPiece){
        Piece captured = null;
        if(isOccupied()) {
            captured = this.storedPiece;
        }
        this.storedPiece = newPiece;
        updateValues();
        return captured;
    }

    public void vacateSquare(){
        this.storedPiece = new Piece(EMPTY, NEUTRAL);
        updateValues();
    }

   public boolean isOccupied(){
        return (storedPiece.getPieceType() != EMPTY);
   }

    public String toString(){
        return storedPiece.toString();
    }
}
