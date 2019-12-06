package com.hackersanon.banqi.database.model;

import javax.persistence.Embeddable;

@Embeddable
public class Coordinate {


    private int row;

    private int column;

    public Coordinate(){
    }

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


    @Override
    public boolean equals(Object object){
        if(object == this){
            return true;
        }

        if(!(object instanceof Coordinate)){
            return false;
        }

        Coordinate coordinate = (Coordinate) object;

        return (this.getRow() == coordinate.getRow() && this.getColumn() == coordinate.getColumn());
    }
}
