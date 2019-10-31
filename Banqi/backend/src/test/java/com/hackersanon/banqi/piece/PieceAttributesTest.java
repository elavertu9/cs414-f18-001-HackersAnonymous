package com.hackersanon.banqi.piece;

import com.hackersanon.banqi.board.Coordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceAttributesTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void toStringTest() {
    }

    @Test
    void isValidMove() {
        Coordinate origin = new Coordinate(2,2);
        Coordinate destUp = new Coordinate(3,2);
        Coordinate destDown = new Coordinate(1, 2);
        Coordinate destLeft = new Coordinate(2, 1);
        Coordinate destRight = new Coordinate(2, 3);

        for(PieceAttributes pieceType : PieceAttributes.values())
        {
            assertTrue(pieceType.isValidMove(origin, destUp));
            assertTrue(pieceType.isValidMove(origin, destDown));
            assertTrue(pieceType.isValidMove(origin, destLeft));
            assertTrue(pieceType.isValidMove(origin, destRight));
        }
    }
}