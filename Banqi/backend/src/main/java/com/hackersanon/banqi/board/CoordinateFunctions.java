package com.hackersanon.banqi.board;

import com.hackersanon.banqi.database.model.Coordinate;

import java.util.regex.Pattern;


public class CoordinateFunctions
{

    public static boolean isValid(int row, int column){
        return isRowValid(row) && isColumnValid(column);
    }

    public static boolean isValid(Coordinate coordinate){
        return isRowValid(coordinate.getRow())&&isColumnValid(coordinate.getColumn());
    }

    private static String stringPosition(Coordinate coordinate){
        return columnLetters.values()[coordinate.getColumn()].name()+coordinate.getRow();
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



}
