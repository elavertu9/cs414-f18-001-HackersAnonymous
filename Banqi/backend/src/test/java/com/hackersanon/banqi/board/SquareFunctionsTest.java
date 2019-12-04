package com.hackersanon.banqi.board;

import com.hackersanon.banqi.piece.PieceFunctions;
import com.hackersanon.banqi.piece.PieceAttributes;
import com.hackersanon.banqi.piece.TeamColor;
import org.junit.jupiter.api.BeforeEach;

class SquareFunctionsTest {

    private SquareFunctions squareFunctions;
    private SquareFunctions emptySquareFunctions;
    private PieceFunctions blackCannon;

    @BeforeEach
    void setUp() {
        blackCannon = new PieceFunctions(PieceAttributes.CANNON, TeamColor.BLACK);
        squareFunctions = new SquareFunctions(new CoordinateFunctions(0, 0), blackCannon);
        emptySquareFunctions = new SquareFunctions(new CoordinateFunctions(0, 0), new PieceFunctions(PieceAttributes.EMPTY,TeamColor.NEUTRAL));
    }

//    @Test
//    void getStoredPiece() {
//        assertEquals(blackCannon, squareFunctions.getStoredPiece());
//    }
//
//    @Test
//    void getCoordinate() {
//        assertEquals(new Coordinate(0, 0), squareFunctions.getCoordinate());
//    }
//
//    @Test
//    void toStringTest() {
//        squareFunctions.getStoredPiece().flipPiece();
//        assertEquals("BLACKCANNON", squareFunctions.toString());
//    }
//
//    @Test
//    void occupySquare() {
//        Piece redChariot = new Piece(PieceAttributes.CHARIOT, TeamColor.RED);
//        emptySquareFunctions.occupySquare(redChariot);
//        emptySquareFunctions.getStoredPiece().flipPiece();
//        assertEquals(emptySquareFunctions.toString(), "REDCHARIOT");
//    }
//
//    @Test
//    void occupiedSquare() {
//        Piece redSoldier = new Piece(PieceAttributes.SOLDIER, TeamColor.RED);
//        assertEquals(blackCannon, squareFunctions.occupySquare(redSoldier));
//    }

}