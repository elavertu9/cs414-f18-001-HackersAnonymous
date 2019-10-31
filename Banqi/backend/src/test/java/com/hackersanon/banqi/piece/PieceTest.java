package com.hackersanon.banqi.piece;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    private static Piece redGeneral;
    private static Piece blackHorse;

    @BeforeAll
    static void setUp() {
        redGeneral = new Piece(PieceAttributes.GENERAL, TeamColor.RED);
        blackHorse = new Piece(PieceAttributes.HORSE, TeamColor.BLACK);
    }

    @Test
    void getPieceType() {
        assertEquals("GENERAL", redGeneral.getPieceType());
        assertEquals("HORSE", blackHorse.getPieceType());
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
    }

    @Test
    void toStringTest() {

    }
}