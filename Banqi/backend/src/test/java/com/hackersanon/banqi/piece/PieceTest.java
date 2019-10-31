package com.hackersanon.banqi.piece;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    private static Piece redGeneral;
    private static Piece blackGeneral;

    @BeforeAll
    static void setUp() {
        redGeneral = new Piece(PieceAttributes.GENERAL, TeamColor.RED);
        blackGeneral = new Piece(PieceAttributes.GENERAL, TeamColor.BLACK);
    }

    @Test
    void flipPiece() {
        assertTrue(redGeneral.flipPiece());
        assertTrue(blackGeneral.flipPiece());
    }

    @Test
    void getTeam() {
        assertEquals(TeamColor.RED, redGeneral.getTeam());
        assertEquals(TeamColor.BLACK, blackGeneral.getTeam());
    }

    @Test
    void toStringTest() {
    }

    @Test
    void setTeamColor() {
    }

    @Test
    void isValidMove() {
    }
}