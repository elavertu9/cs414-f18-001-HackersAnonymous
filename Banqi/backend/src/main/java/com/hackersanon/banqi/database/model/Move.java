package com.hackersanon.banqi.database.model;

import com.hackersanon.banqi.game.MoveType;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Move extends ModelBase {

    @Column
    private long gameId;
    @Embedded
    private Square origin;
    @Embedded
    private Square destination;
    @Embedded
    private Piece attacker;
    @Embedded
    private Piece captured;
    private MoveType action;

    private boolean executed;
    public Square getOrigin() {
        return origin;
    }

    public void setOrigin(Square origin) {
        this.origin = origin;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public Square getDestination() {
        return destination;
    }

    public void setDestination(Square destination) {
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

    public MoveType getAction() {
        return action;
    }

    public void setAction(MoveType action) {
        this.action = action;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }
}
