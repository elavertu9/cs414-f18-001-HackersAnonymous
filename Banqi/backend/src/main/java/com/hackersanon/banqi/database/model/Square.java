package com.hackersanon.banqi.database.model;


import javax.persistence.*;

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
