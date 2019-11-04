package com.hackersanon.banqi.piece;

import com.hackersanon.banqi.board.Coordinate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    private static Piece redGeneral;
    private static Piece blackHorse;

    @BeforeEach
    void setUp() {
        redGeneral = new Piece(PieceAttributes.GENERAL, TeamColor.RED);
        blackHorse = new Piece(PieceAttributes.HORSE, TeamColor.BLACK);
    }

    @Test
    void getPieceType() {
        assertEquals(PieceAttributes.GENERAL, redGeneral.getPieceType());
        assertEquals(PieceAttributes.HORSE, blackHorse.getPieceType());
    }

    @Test
    void getTeam() {
        assertEquals(TeamColor.RED, redGeneral.getTeam());
        assertEquals(TeamColor.BLACK, blackHorse.getTeam());
    }

    @Test
    void flipPiece() {
        assertTrue(redGeneral.flipPiece());
        assertTrue(blackHorse.flipPiece());
    }

    @Test
    void isValidMove() {
        Coordinate origin = new Coordinate(3, 4);
        Coordinate destination = new Coordinate(3, 5);

        assertTrue(redGeneral.isValidMove(origin, destination));
    }

    @Test
    void isInvalidMove() {
        Coordinate origin = new Coordinate(3, 4);
        Coordinate destination = new Coordinate(4, 4);

        assertFalse(blackHorse.isValidMove(origin, destination));
    }

    @Test
    void toStringTest() {
        redGeneral.flipPiece();
        blackHorse.flipPiece();
        assertEquals("REDGENERAL", redGeneral.toString());
        assertEquals("BLACKHORSE", blackHorse.toString());
    }
}