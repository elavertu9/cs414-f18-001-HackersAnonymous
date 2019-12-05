package com.hackersanon.banqi.game;

import com.hackersanon.banqi.board.CoordinateFunctions;
import com.hackersanon.banqi.piece.PieceFunctions;

import java.util.Map;

public class Move {
    private Map<String, CoordinateFunctions> trip;
    private PieceFunctions attacker;
    private PieceFunctions captured;
//    private Actions actionType;
    private boolean executed;



//    public Move(BanqiBoard gameBoard, CoordinateFunctions origin, CoordinateFunctions destination){
//        this.trip = new HashMap<>();
//        this.trip.put("origin", origin);
//        this.trip.put("destination", destination);
//        this.attacker = gameBoard.getPieceAt(origin);
//        this.captured = gameBoard.getPieceAt(destination);
//        this.actionType = Actions.translateToAction(gameBoard.getSquare(origin),
//                                                            gameBoard.getSquare(destination));
//    }
//
//    public Move(BanqiBoard gameBoard, SquareFunctions origin, SquareFunctions destination){
//        this(gameBoard,origin.getCoordinate(),destination.getCoordinate());
//        this.attacker = origin.getStoredPiece();
//        this.captured = destination.getStoredPiece();
//        this.actionType = Actions.translateToAction(origin, destination);
//    }
//
//    public Move executeMove(BanqiBoard board){
//        board.getSquare(getDestination()).occupySquare(getAttacker());
//        board.getSquare(getOrigin()).vacateSquare();
//        this.setExecuted();
//        return this;
//    }
//
//    public Move executeFlip(BanqiBoard board){
//        board.getSquare(getOrigin()).getStoredPiece().flipPiece();
//        this.setExecuted();
//        return this;
//    }
//
//    public Actions getActionType() {
//        return actionType;
//    }
//
//    public void setActionType(Actions actionType) {
//        this.actionType = actionType;
//    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted() {
        this.executed = true;
    }

    public PieceFunctions getAttacker() {
        return attacker;
    }

    public PieceFunctions getCaptured() {
        return captured;
    }

    public Map<String, CoordinateFunctions> getTrip() {
        return trip;
    }

    public CoordinateFunctions getOrigin(){
        return trip.get("origin");
    }

    public CoordinateFunctions getDestination(){
        return trip.get("destination");
    }
//
//    public enum Actions {
//        TRAVEL(){
//            @Override
//            public boolean calculateMoveType(SquareFunctions origin, SquareFunctions destination) {
//                return (origin.checkOccupied() && origin.getStoredPiece().isFaceUp()) &&
//                        (!destination.checkOccupied());
//            }
//        },CAPTURE(){
//            @Override
//            public boolean calculateMoveType(SquareFunctions origin, SquareFunctions destination) {
//                return ((origin.checkOccupied()&& origin.getStoredPiece().isFaceUp()) &&
//                        (destination.checkOccupied() && destination.getStoredPiece().isFaceUp()) &&
//                        origin.getStoredPiece().canCapture(destination.getStoredPiece()));
//            }
//        },FLIP(){
//            @Override
//            public boolean calculateMoveType(SquareFunctions origin, SquareFunctions destination) {
//                return ( origin.checkOccupied() && !origin.getStoredPiece().isFaceUp() ) &&
//                        ( destination.getCoordinate().equals(origin.getCoordinate()) &&
//                                !destination.getStoredPiece().isFaceUp() );
//            }
//        }, INVALID() {
//            @Override
//            public boolean calculateMoveType(SquareFunctions origin, SquareFunctions destination) {
//                return !TRAVEL.calculateMoveType(origin,destination) && !CAPTURE.calculateMoveType(origin,destination)
//                        && !FLIP.calculateMoveType(origin,destination);
//            }
//        };
//        Actions(){}
//
//        public static Actions translateToAction (SquareFunctions origin, SquareFunctions destination){
//            for (Actions action : Actions.values()) {
//                if (action.calculateMoveType(origin, destination)) {
//                    return action;
//                }
//            }
//            return INVALID;
//        }
//
//        abstract boolean calculateMoveType(SquareFunctions origin, SquareFunctions destination);
//    }
}
