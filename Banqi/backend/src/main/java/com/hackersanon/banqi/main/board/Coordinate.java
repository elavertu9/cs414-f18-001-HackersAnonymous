package com.hackersanon.banqi.main.board;

import java.util.HashMap;
import java.util.Map;

public class Coordinate {

    private Map<String, Integer> coordinate;

    public Coordinate(int row, int column){
        coordinate = new HashMap<>();
        coordinate.put("row", row);
        coordinate.put("column", column);
    }

    public int getRow(){
        return coordinate.get("row");
    }

    public int getColumn(){
        return coordinate.get("column");
    }

    public boolean setColumn(int column){
        if(isColumnValid(column)){
            this.coordinate.replace("column", column);
            return true;
        }else{
            return false;
        }
    }

    public boolean setRow(int row){
        if(isRowValid(row)){
            coordinate.replace("row",row);
            return true;
        }else{
            return false;
        }
    }

    public static boolean isCoordinateValid(int row, int column){
        return isRowValid(row) && isColumnValid(column);
    }

    private static boolean isRowValid(int row){
        return (row<4)&&(row>=0);
    }

    private static boolean isColumnValid(int column){
        return (column<8)&&(column>=0);
    }

    public String getStringPosition(){
        return columnLetters.values()[coordinate.get("column")].name()+coordinate.get("row");
    }

    public enum columnLetters{
        a,b,c,d,e,f,g,h
    }


}
