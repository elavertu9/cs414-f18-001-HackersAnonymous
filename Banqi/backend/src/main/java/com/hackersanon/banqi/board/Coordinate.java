package com.hackersanon.banqi.board;

import java.util.HashMap;
import java.util.Map;

public class Coordinate {

    private Map<String, Integer> coordinate;

    public Coordinate(int row, int column){
        coordinate = new HashMap<>();
        coordinate.put("row", row);
        coordinate.put("column", column);
    }

    public boolean isValid(){
        return isRowValid(this.getRow())&&isColumnValid(this.getColumn());
    }

    public static boolean isValid(int row, int column){
        return isRowValid(row) && isColumnValid(column);
    }

    public static boolean isValid(Coordinate coordinate){
        return isRowValid(coordinate.getRow())&&isColumnValid(coordinate.getColumn());
    }

    public int getRow(){
        return coordinate.get("row");
    }

    public int getColumn(){
        return coordinate.get("column");
    }

    public boolean setColumn(int column){
        boolean validity = isColumnValid(column);
        if(validity){
            this.coordinate.replace("column", column);
        }
        return validity;
    }

    public boolean setRow(int row){
        boolean validity = isRowValid(row);
        if(validity){
            coordinate.replace("row",row);
        }
        return validity;
    }

    public String getStringPosition(){
        return columnLetters.values()[coordinate.get("column")].name()+coordinate.get("row");
    }
    public enum columnLetters{
        a,b,c,d,e,f,g,h

    }

    private static boolean isRowValid(int row){
        return (row<4)&&(row>=0);
    }

    private static boolean isColumnValid(int column){
        return (column<8)&&(column>=0);
    }


}
