package com.hackersanon.banqi.board;

import com.hackersanon.banqi.piece.Piece;
import com.hackersanon.banqi.piece.PieceAttributes;
import com.hackersanon.banqi.piece.TeamColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    private Square square;
    private Square emptySquare;
    private Piece blackCannon;

    @BeforeEach
    void setUp() {
        blackCannon = new Piece(PieceAttributes.CANNON, TeamColor.BLACK);
        square = new Square(new Coordinate(0, 0), blackCannon);
        emptySquare = new Square(new Coordinate(0, 0), new Piece(PieceAttributes.EMPTY,TeamColor.NEUTRAL));
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
    void occupySquare() {
        Piece redChariot = new Piece(PieceAttributes.CHARIOT, TeamColor.RED);
        emptySquare.occupySquare(redChariot);
        assertEquals(emptySquare.toString(), "REDCHARIOT");
    }

    @Test
    void occupiedSquare() {
        Piece redSoldier = new Piece(PieceAttributes.SOLDIER, TeamColor.RED);
        assertEquals(blackCannon, square.occupySquare(redSoldier));
    }

}