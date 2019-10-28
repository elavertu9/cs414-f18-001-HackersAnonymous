package com.hackersanon.banqi.main.board;

public class Coordinate {
    private int row;
    private int column;

    public Coordinate(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public boolean setColumn(int column){
        if(isColumnValid(column)){
            this.column = column;
            return true;
        }else{
            return false;
        }
    }

    public boolean setRow(int row){
        if(isRowValid(row)){
            this.row = row;
            return true;
        }else{
            return false;
        }
    }

    public boolean isCoordinateValid(int row, int column){
        return isRowValid(row) && isColumnValid(column);
    }

    public boolean isRowValid(int row){
        return (row<4)&&(row>=0);
    }

    public boolean isColumnValid(int column){
        return (column<8)&&(column>=0);
    }
}