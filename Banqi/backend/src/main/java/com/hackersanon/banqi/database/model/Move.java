package com.hackersanon.banqi.database.model;

import com.hackersanon.banqi.board.BoardFunctions;
import com.hackersanon.banqi.board.InvalidCoordinateException;
import com.hackersanon.banqi.board.InvalidMoveException;
import com.hackersanon.banqi.board.SquareFunctions;
import com.hackersanon.banqi.game.MoveType;

import javax.persistence.*;

@Embeddable
public class Move {

    @Column
    private long gameId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "row",column = @Column(name = "oRow")),
            @AttributeOverride(name = "column", column = @Column(name = "oColumn"))
    })
    private Coordinate origin;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "row",column = @Column(name = "dRow")),
            @AttributeOverride(name = "column", column = @Column(name = "dColumn"))
    })
    private Coordinate destination;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "faceUp", column = @Column(name = "oFaceUp")),
            @AttributeOverride(name = "teamColor",column = @Column(name = "oTeamColor")),
            @AttributeOverride(name = "type", column = @Column(name = "oType"))
    })
    private Piece attacker;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "faceUp", column = @Column(name = "dFaceUp")),
            @AttributeOverride(name = "teamColor",column = @Column(name = "dTeamColor")),
            @AttributeOverride(name = "type", column = @Column(name = "dType"))
    })
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

    private void setExecuted() {
        this.executed = true;
    }


    public boolean isValidMove(){

        return this.attacker.getType().isValidMove(origin, destination);
    }

    public Move executeMove(Board board) throws InvalidMoveException {
        try {
            setAttacker(BoardFunctions.getSquare(board, origin).getPiece());
            setCaptured(SquareFunctions.occupySquare(BoardFunctions.getSquare(board,destination),attacker));
            SquareFunctions.vacateSquare(BoardFunctions.getSquare(board,getOrigin()));
        } catch (InvalidCoordinateException e) {
            e.printStackTrace();
            throw new InvalidMoveException();
        }
        this.setExecuted();
        return this;
    }

    public Move executeFlip(Board board) throws InvalidMoveException {
        try {
            BoardFunctions.getSquare(board,getOrigin()).getPiece().setFaceUp(true);
            this.setExecuted();
        } catch (InvalidCoordinateException e) {
            throw new InvalidMoveException();
        }
        return this;
    }

}
