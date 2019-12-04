package com.hackersanon.banqi.piece;

import com.hackersanon.banqi.board.CoordinateFunctions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PieceFunctionsAttributesTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void toStringTest() {
        String[] pieceTypes = {"GENERAL", "CHARIOT", "HORSE", "CANNON", "ADVISOR", "MINSTER", "SOLDIER", "EMPTY"};
        for(PieceAttributes pieceType : PieceAttributes.values()) {
            assertTrue(Arrays.asList(pieceTypes).contains(pieceType.name()));
        }
    }

    @Test
    void isValidMove() {
        CoordinateFunctions origin = new CoordinateFunctions(2,2);
        CoordinateFunctions destUp = new CoordinateFunctions(3,2);
        CoordinateFunctions destDown = new CoordinateFunctions(1, 2);
        CoordinateFunctions destLeft = new CoordinateFunctions(2, 1);
        CoordinateFunctions destRight = new CoordinateFunctions(2, 3);

        for(PieceAttributes pieceType : PieceAttributes.values()) {
            assertTrue(pieceType.isValidMove(origin, destUp));
            assertTrue(pieceType.isValidMove(origin, destDown));
            assertTrue(pieceType.isValidMove(origin, destLeft));
            assertTrue(pieceType.isValidMove(origin, destRight));
        }
    }
}