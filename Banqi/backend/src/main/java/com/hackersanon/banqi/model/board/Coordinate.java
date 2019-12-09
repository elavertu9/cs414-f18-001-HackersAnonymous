package com.hackersanon.banqi.model.board;

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

    public void setValid(boolean valid){
        valid = rowValid(this.getRow())&& columnValid(this.getColumn());
    }

    public boolean valid(){
        return rowValid(this.getRow())&& columnValid(this.getColumn());
    }

    private boolean rowValid(int row){
        return (row<4)&&(row>=0);
    }

    private static boolean columnValid(int column){
        return (column<8)&&(column>=0);
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
