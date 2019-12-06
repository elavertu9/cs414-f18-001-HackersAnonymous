package com.hackersanon.banqi.database.model;

import com.hackersanon.banqi.board.BoardFunctions;
import com.hackersanon.banqi.board.InvalidCoordinateException;
import com.hackersanon.banqi.board.InvalidMoveException;
import com.hackersanon.banqi.board.SquareFunctions;
import com.hackersanon.banqi.game.MoveType;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Move extends ModelBase {

    @Column
    private long gameId;
    @Embedded
    private Coordinate origin;
    @Embedded
    private Coordinate destination;
    @Embedded
    private Piece attacker;
    @Embedded
    private Piece captured;
    private MoveType moveType;

    private boolean executed;
    public Coordinate getOrigin() {
        return origin;
    }

    public void setOrigin(Coordinate origin) {
        this.origin = origin;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public Coordinate getDestination() {
        return destination;
    }

    public void setDestination(Coordinate destination) {
        this.destination = destination;
    }

    public Piece getAttacker() {
        return attacker;
    }

    public void setAttacker(Piece attacker) {
        this.attacker = attacker;
    }

    public Piece getCaptured() {
        return captured;
    }

    public void setCaptured(Piece captured) {
        this.captured = captured;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }


    public boolean isValidMove(){

        return this.attacker.getType().isValidMove(origin, destination);
    }

    public Move executeMove(Board board) throws InvalidCoordinateException {
        setAttacker(BoardFunctions.getSquare(board, origin).getPiece());
        setCaptured(SquareFunctions.occupySquare(BoardFunctions.getSquare(board,destination),attacker));
        SquareFunctions.vacateSquare(BoardFunctions.getSquare(board,getOrigin()));
        this.setExecuted(true);
        return this;
    }

    public Move executeFlip(Board board) throws InvalidMoveException {
        try {
            BoardFunctions.getSquare(board,getOrigin()).getPiece().setFaceUp(true);
            this.setExecuted(true);
        } catch (InvalidCoordinateException e) {
            throw new InvalidMoveException();
        }
        return this;
    }

}
