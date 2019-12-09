package com.hackersanon.banqi.model.board;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PieceAttributesTest
{
    private Piece general;
    private Piece soldier;
    private Piece chariot;
    private Piece empty;


    private Coordinate origin;
    private Coordinate destination;
    private Coordinate badMove;

    @Before
    public void before(){
        general = new Piece(PieceAttributes.GENERAL,TeamColor.RED);
        soldier = new Piece(PieceAttributes.SOLDIER, TeamColor.BLACK);
        chariot = new Piece(PieceAttributes.CHARIOT, TeamColor.RED);
        empty = new Piece(PieceAttributes.EMPTY, TeamColor.NEUTRAL);
        origin = new Coordinate(0,0);
        destination = new Coordinate(0,1);
        badMove = new Coordinate(4,1);
    }

    @Test
    public void testCanCapture(){
        Assertions.assertFalse(general.getType().canCapture(soldier));
        Assertions.assertTrue(soldier.getType().canCapture(general));
        Assertions.assertTrue(soldier.getType().canCapture(empty));
        Assertions.assertTrue(soldier.getType().canCapture(soldier));
        Assertions.assertTrue(chariot.getType().canCapture(soldier));

    }

    @Test
    public void testIsValidMove(){
        Assertions.assertTrue(soldier.getType().isValidMove(origin,destination));
        Assertions.assertFalse(soldier.getType().isValidMove(origin, badMove));
    }

    @Test
    public void testToString(){
        Assertions.assertEquals("SOLDIER", soldier.getType().toString());
    }

}
