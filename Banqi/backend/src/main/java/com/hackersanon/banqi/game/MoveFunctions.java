package com.hackersanon.banqi.game;

import com.hackersanon.banqi.board.InvalidCoordinateException;
import com.hackersanon.banqi.board.InvalidMoveException;
import com.hackersanon.banqi.database.model.Board;
import com.hackersanon.banqi.database.model.Move;
import com.hackersanon.banqi.database.model.Square;

import static com.hackersanon.banqi.game.MoveType.*;

public class MoveFunctions {

    public static Move makeMove(Board boardObject, Move newMove) throws InvalidMoveException {
        try {
            return makeMove(boardObject, boardObject.getSquare(newMove.getOrigin()), boardObject.getSquare(newMove.getDestination()));
        } catch (InvalidCoordinateException e) {
            throw new InvalidMoveException();
        }
    }

    public static Move makeMove(Board boardObject, Square origin, Square destination) throws InvalidMoveException {
        Move newMove = new Move();
        newMove.setMoveType(MoveType.translateToMoveType(origin, destination));
        newMove.setOrigin(origin.getCoordinate());
        newMove.setDestination(destination.getCoordinate());
        newMove.setAttacker(origin.getPiece());
        newMove.setCaptured(destination.getPiece());
        if (newMove.getMoveType() == TRAVEL || newMove.getMoveType() == CAPTURE) {
            return newMove.executeMove(boardObject);
        } else if (newMove.getMoveType() == FLIP) {
            return newMove.executeFlip(boardObject);
        }
        return newMove;
    }
}
