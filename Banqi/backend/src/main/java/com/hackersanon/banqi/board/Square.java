package com.hackersanon.banqi.board;

import com.hackersanon.banqi.piece.Piece;

public class Square {
    private Piece storedPiece;
    private Coordinate coordinate;

    Square(Coordinate coordinate, Piece piece){
        this.coordinate = coordinate;
        this.storedPiece = piece;
    }

    protected Square(Coordinate coordinate){
        this(coordinate,null);
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
        return captured;
    }

    public void vacateSquare(){
        this.storedPiece = null;
    }

   public boolean isOccupied(){
        return (storedPiece != null);
   }

    public String toString(){
        return storedPiece.toString();
    }
}
