package com.hackersanon.banqi.database.model;


import com.hackersanon.banqi.piece.PieceAttributes;

import javax.persistence.*;

import static com.hackersanon.banqi.piece.PieceAttributes.EMPTY;
import static com.hackersanon.banqi.piece.TeamColor.NEUTRAL;

@Embeddable
public class Square
{
    @Embedded
    private Piece piece;

    @Embedded
    @AttributeOverrides({
    @AttributeOverride(name = "row", column = @Column(name = "squareRow")),
    @AttributeOverride(name = "column", column = @Column(name = "squareCol"))})
    private Coordinate coordinate;

    public Square() {
    }

    Square(Piece piece, Coordinate coordinate){
        this.piece = piece;
        this.coordinate = coordinate;
    }

    private void setPiece(Piece piece){
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    public boolean checkOccupied(){
        return (piece.getType()!= PieceAttributes.EMPTY && piece != null);
    }

    Piece occupySquare(Piece piece){
        Piece captured = piece;
        if(this.checkOccupied()) {
            captured = this.getPiece();
        }
        this.setPiece(piece);
        return captured;
    }

    Piece vacateSquare(){
        return occupySquare(new Piece(EMPTY, NEUTRAL));
    }
}
