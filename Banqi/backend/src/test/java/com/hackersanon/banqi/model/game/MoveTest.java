package com.hackersanon.banqi.model.game;

import com.hackersanon.banqi.exception.InvalidCoordinateException;
import com.hackersanon.banqi.exception.InvalidMoveException;
import com.hackersanon.banqi.model.board.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MoveTest
{
    private Coordinate origin;
    private Coordinate destination;
    private Coordinate farDestination;
    private Coordinate invalCoord;
    private Board board;
    private Move move;
    private Long userId;
    private Piece friendly;
    private Piece foe;

    @Before
    public void before(){
        origin = new Coordinate(0,0);
        destination = new Coordinate(0,1);
        farDestination = new Coordinate(6,3);

        invalCoord = new Coordinate(9,0);
        board = new Board();
        move = new Move();
        userId = 1234L;
        friendly = new Piece(PieceAttributes.GENERAL, TeamColor.BLACK);
        foe = new Piece(PieceAttributes.CHARIOT, TeamColor.RED);
        friendly.setFaceUp(true);
        foe.setFaceUp(true);
    }

    @After
    public void after(){
        move = null;
    }

    @Test
    public void testAttemptMove(){
        move.setOrigin(origin);
        move.setDestination(origin);
        try {
            move.attemptMove(board,userId);
        } catch (InvalidMoveException ignored) {}
        Assertions.assertEquals(MoveType.FLIP,move.getMoveType());
    }

    @Test
    public void testAttemptMoveInvalid(){
        move.setOrigin(origin);
        move.setDestination(invalCoord);
        Assertions.assertThrows(InvalidMoveException.class ,() -> move.attemptMove(board,userId));
    }

    @Test
    public void testExecuteMove(){
        move.setOrigin(origin);
        move.setDestination(destination);
        try {
            board.getSquare(origin).occupySquare(friendly);
            board.getSquare(destination).occupySquare(foe);
        } catch (InvalidCoordinateException e) {
            Assertions.fail();
        }
        try {
            move.attemptMove(board, userId);
        } catch (InvalidMoveException e) {
            Assertions.fail();
        }
        Assertions.assertEquals(MoveType.CAPTURE, move.getMoveType());

    }



}
