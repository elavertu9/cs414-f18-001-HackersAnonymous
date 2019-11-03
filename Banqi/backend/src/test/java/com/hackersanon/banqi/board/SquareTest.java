package com.hackersanon.banqi.board;

import com.hackersanon.banqi.piece.Piece;
import com.hackersanon.banqi.piece.PieceAttributes;
import com.hackersanon.banqi.piece.TeamColor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    private static Square square;
    private static Square emptySquare;
    private static Piece blackCannon;

    @BeforeAll
    static void setUp() {
        blackCannon = new Piece(PieceAttributes.CANNON, TeamColor.BLACK);
        square = new Square(new Coordinate(0, 0), blackCannon);
        emptySquare = new Square(new Coordinate(0, 0), null);
    }

    @Test
    void getStoredPiece() {
        assertEquals(blackCannon, square.getStoredPiece());
    }

    @Test
    void getCoordinate() {
        assertEquals(new Coordinate(0, 0), square.getCoordinate());
    }

    @Test
    void toStringTest() {
        assertEquals("BLACKCANNON", square.toString());
    }

    @Test
    void setStoredPiece() {
        Piece redChariot = new Piece(PieceAttributes.CHARIOT, TeamColor.RED);
        assertTrue(emptySquare.setStoredPiece(redChariot));
    }

    @Test
    void setStoredPieceOccupied() {
        Piece redSoldier = new Piece(PieceAttributes.SOLDIER, TeamColor.RED);
        assertFalse(square.setStoredPiece(redSoldier));
    }

}