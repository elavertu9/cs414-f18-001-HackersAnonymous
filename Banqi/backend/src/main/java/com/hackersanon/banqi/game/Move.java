package com.hackersanon.banqi.game;

import com.hackersanon.banqi.board.Coordinate;
import com.hackersanon.banqi.piece.Piece;

import java.util.Map;

public class Move {
    private Map<String, Coordinate> trip;
    private Piece attacker;
    private Piece captured;

    public Move(Map<String, Coordinate> newTrip, Piece attackerPiece, Piece capturedPiece){
        this.attacker = attackerPiece;
        this.captured = capturedPiece;
        this.trip = newTrip;
    }

    public Move(Map<String,Coordinate> newTrip, Piece attackerPiece){
       this(newTrip, attackerPiece, null);
    }

    public Piece getAttacker() {
        return attacker;
    }

    public Piece getCaptured() {
        return captured;
    }

    public Map<String, Coordinate> getTrip() {
        return trip;
    }

    public Coordinate getOrigin(){
        return trip.get("origin");
    }

    public Coordinate getDestination(){
        return trip.get("destination");
    }
}
