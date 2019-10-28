package com.hackersanon.banqi.main.board;

import com.hackersanon.banqi.main.piece.Piece;

public class Square {
    private Piece storedPiece;
    private Coordinate coordinate;
    private boolean occupied = false;

    protected Square(Coordinate coordinate, Piece piece){
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

    public void setStoredPiece(Piece newPiece){
        if(!occupied) {
            this.storedPiece = newPiece;
            toggleOccupied();
        }
        //TODO should square check for occupying piece team and check validity of capture of friendly piece? need to come back. I don't think square should be responsible.
    }

    private void toggleOccupied(){
        occupied = !occupied;
    }
}
