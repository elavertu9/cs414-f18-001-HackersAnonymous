package com.hackersanon.banqi.game;

import com.hackersanon.banqi.board.BanqiBoard;
import com.hackersanon.banqi.board.Coordinate;
import com.hackersanon.banqi.board.Square;
import com.hackersanon.banqi.piece.Piece;

import java.util.HashMap;
import java.util.Map;

public class Move {
    private Map<String, Coordinate> trip;
    private Piece attacker;
    private Piece captured;
    private Actions actionType;
    private boolean executed;



    public Move(BanqiBoard gameBoard, Coordinate origin, Coordinate destination){
        this.trip = new HashMap<>();
        this.trip.put("origin", origin);
        this.trip.put("destination", destination);
        this.attacker = gameBoard.getPieceAt(origin);
        this.captured = gameBoard.getPieceAt(destination);
        this.actionType = Actions.translateToAction(gameBoard.getSquare(origin),
                                                            gameBoard.getSquare(destination));
    }

    public Move(BanqiBoard gameBoard, Square origin, Square destination){
        this(gameBoard,origin.getCoordinate(),destination.getCoordinate());
        this.attacker = origin.getStoredPiece();
        this.captured = destination.getStoredPiece();
        this.actionType = Actions.translateToAction(origin, destination);
    }

    public Move executeMove(BanqiBoard board){
        board.getSquare(getDestination()).occupySquare(getAttacker());
        board.getSquare(getOrigin()).vacateSquare();
        this.setExecuted();
        return this;
    }

    public Move executeFlip(BanqiBoard board){
        board.getSquare(getOrigin()).getStoredPiece().flipPiece();
        this.setExecuted();
        return this;
    }

    public Actions getActionType() {
        return actionType;
    }

    public void setActionType(Actions actionType) {
        this.actionType = actionType;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted() {
        this.executed = true;
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

    public enum Actions {
        TRAVEL(){
            @Override
            public boolean calculateMoveType(Square origin, Square destination) {
                return (origin.isOccupied() && origin.getStoredPiece().isFaceUp()) &&
                        (!destination.isOccupied());
            }
        },CAPTURE(){
            @Override
            public boolean calculateMoveType(Square origin, Square destination) {
                return ((origin.isOccupied()&& origin.getStoredPiece().isFaceUp()) &&
                        (destination.isOccupied() && destination.getStoredPiece().isFaceUp()) &&
                        origin.getStoredPiece().canCapture(destination.getStoredPiece()));
            }
        },FLIP(){
            @Override
            public boolean calculateMoveType(Square origin, Square destination) {
                return ( origin.isOccupied() && !origin.getStoredPiece().isFaceUp() ) &&
                        ( destination.getCoordinate().equals(origin.getCoordinate()) &&
                                !destination.getStoredPiece().isFaceUp() );
            }
        }, INVALID() {
            @Override
            public boolean calculateMoveType(Square origin, Square destination) {
                return !TRAVEL.calculateMoveType(origin,destination) && !CAPTURE.calculateMoveType(origin,destination)
                        && !FLIP.calculateMoveType(origin,destination);
            }
        };
        Actions(){}

        public static Actions translateToAction (Square origin, Square destination){
            for (Actions action : Actions.values()) {
                if (action.calculateMoveType(origin, destination)) {
                    return action;
                }
            }
            return INVALID;
        }

        abstract boolean calculateMoveType(Square origin, Square destination);
    }
}
