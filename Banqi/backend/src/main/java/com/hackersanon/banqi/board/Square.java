package com.hackersanon.banqi.board;

import com.hackersanon.banqi.piece.Piece;

public class Square {
    private Piece storedPiece;
    private Coordinate coordinate;
    private boolean occupied;

    Square(Coordinate coordinate, Piece piece){
        this.coordinate = coordinate;
        this.storedPiece = piece;
        this.occupied = (storedPiece != null);
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

    public boolean setStoredPiece(Piece newPiece){
        if(!occupied) {
            this.storedPiece = newPiece;
            toggleOccupied();
            return true;
        }
        else {
            return false;
        }
    }

    private void toggleOccupied(){
        occupied = !occupied;
    }

    public String toString(){
        return storedPiece.toString();
    }
}
