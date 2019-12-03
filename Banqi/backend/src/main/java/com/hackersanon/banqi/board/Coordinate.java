package com.hackersanon.banqi.board;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


public class Coordinate implements Serializable
{

    private Map<String, Integer> coordinate;

    public Coordinate(int row, int column){
        coordinate = new HashMap<>();
        coordinate.put("row", row);
        coordinate.put("column", column);
    }
    
    public Coordinate()
    {
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

    public void setColumn(int column){
        boolean validity = isColumnValid(column);
        if(validity){
            this.coordinate.replace("column", column);
        }
    }

    public void setRow(int row){
        boolean validity = isRowValid(row);
        if(validity){
            coordinate.replace("row",row);
        }
    }

    private String stringPosition(){
        return columnLetters.values()[coordinate.get("column")].name()+coordinate.get("row");
    }

    public static Coordinate convertANtoCoord(String origin){
        if(Pattern.matches("[a-h][1-4]", origin)){
           return new Coordinate(Integer.parseInt(origin.substring(1,2))-1, columnLetters.valueOf(origin.substring(0,1)).ordinal());
        }else{
            throw new IndexOutOfBoundsException();
        }
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
