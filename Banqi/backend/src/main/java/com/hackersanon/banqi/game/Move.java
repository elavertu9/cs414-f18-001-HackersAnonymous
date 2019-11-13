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
    private String gameID;



    Move(BanqiBoard gameBoard, Coordinate origin, Coordinate destination, String gameID){
        this.trip = new HashMap<>();
        this.trip.put("origin", origin);
        this.trip.put("destination", destination);
        this.attacker = gameBoard.getPieceAt(origin);
        this.captured = gameBoard.getPieceAt(destination);
        this.actionType = Actions.translateToAction(gameBoard.getSquare(origin),
                                                            gameBoard.getSquare(destination));
        this.gameID = gameID;
    }

    public Move(BanqiBoard gameBoard, Square origin, Square destination, String gameID){
        this(gameBoard,origin.getCoordinate(),destination.getCoordinate(), gameID);
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
    
    public String getGameID(){
        return gameID;
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

    private void setExecuted() {
        this.executed = true;
    }

    private Piece getAttacker() {
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
    
            @Override public Move executeMove(BanqiBoard banqiBoard, Move move)
            {
                banqiBoard.getSquare(move.getDestination()).occupySquare(move.getAttacker());
                banqiBoard.getSquare(move.getOrigin()).vacateSquare();
                move.setExecuted();
                return move;
            }
        },CAPTURE(){
            @Override
            public boolean calculateMoveType(Square origin, Square destination) {
                return ((origin.isOccupied()&& origin.getStoredPiece().isFaceUp()) &&
                        (destination.isOccupied() && destination.getStoredPiece().isFaceUp()) &&
                        origin.getStoredPiece().canCapture(destination.getStoredPiece()));
            }
        
            @Override public Move executeMove(BanqiBoard banqiBoard, Move move)
            {
                if(banqiBoard.getSquare(move.getOrigin()).getStoredPiece().canCapture(banqiBoard.getSquare(move.getDestination()).getStoredPiece())){
                    banqiBoard.getSquare(move.getDestination()).occupySquare(move.getAttacker());
                    banqiBoard.getSquare(move.getOrigin()).vacateSquare();
                    move.setExecuted();
                    return move;
                }else{
                    return null; //TODO replace null return
                }
            }
        },FLIP(){
            @Override
            public boolean calculateMoveType(Square origin, Square destination) {
                return ( origin.isOccupied() && !origin.getStoredPiece().isFaceUp() ) &&
                        ( destination.getCoordinate().equals(origin.getCoordinate()) &&
                                !destination.getStoredPiece().isFaceUp() );
            }
        
            @Override public Move executeMove(BanqiBoard banqiBoard, Move move)
            {
                banqiBoard.getSquare(move.getOrigin()).getStoredPiece().flipPiece();
                move.setExecuted();
                return move;
            }
        }, INVALID() {
            @Override
            public boolean calculateMoveType(Square origin, Square destination) {
                return !TRAVEL.calculateMoveType(origin,destination) && !CAPTURE.calculateMoveType(origin,destination)
                        && !FLIP.calculateMoveType(origin,destination);
            }
        
            @Override public Move executeMove(BanqiBoard banqiBoard, Move move)
            {
                return null;
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
        
        public Move executeMove(BanqiBoard banqiBoard, Move move)
        {
            return null;
        }
    }
}
