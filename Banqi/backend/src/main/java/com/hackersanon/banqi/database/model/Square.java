package com.hackersanon.banqi.database.model;


import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

@Embeddable
public class Square
{
    @NotNull
    @Embedded
    private Piece piece;

    @NotNull
    @Embedded
    private Coordinate coordinate;

    public Square() {
    }

    public Square(Piece piece, Coordinate coordinate){
        this.piece = piece;
        this.coordinate = coordinate;
    }

    public void setPiece(Piece piece){
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


}
