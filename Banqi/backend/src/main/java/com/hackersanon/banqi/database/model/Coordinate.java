package com.hackersanon.banqi.database.model;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.HashMap;
import java.util.Map;

@Embeddable
public class Coordinate {
    @ElementCollection
    private Map<String, Integer> coordinate;

    public Coordinate(){
    }

    public Coordinate(int row, int column) {
       this.setCoordinate(row,column);
    }

    public void setCoordinate(Map<String, Integer> coordinate){
        this.coordinate = coordinate;
    }

    public Map<String, Integer> getCoordinate(){
        return this.coordinate;
    }

    private void setCoordinate(int row, int column){
        this.coordinate = new HashMap<>();
        this.coordinate.put("row", row);
        this.coordinate.put("column", column);
    }

}
