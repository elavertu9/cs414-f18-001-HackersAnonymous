package com.hackersanon.banqi.board;

import com.hackersanon.banqi.piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BanqiBoardTest {
    private BanqiBoard banqiBoard;

    @BeforeEach
    void setUp() {
        banqiBoard = new BanqiBoard();
    }

    @Test
    void getBoard() {
        Square[][] board = banqiBoard.getBoard();
        assertEquals(board.length, banqiBoard.getRowDimension());
        assertEquals(board[0].length, banqiBoard.getColDimension());
    }

    @Test
    void getNullSquare() {
        assertNull(banqiBoard.getSquare(new Coordinate(0, 0)));
    }

    @Test
    void getNullPieceAt() {
        assertNull(banqiBoard.getPieceAt(new Coordinate(0, 0)));
    }

    @Test
    void initialize() {
        Map<String, Integer> pieceTotals = generatePieceTotalList();

        banqiBoard.initialize();

        for (int i = 0; i < banqiBoard.getRowDimension(); i++) {
            for (int j = 0; j < banqiBoard.getColDimension(); j++) {
                Piece piece;
                if ((piece = banqiBoard.getPieceAt(new Coordinate(i, j))) != null) {
                    pieceTotals.merge(piece.toString(), 1, Integer::sum);
                }
            }
        }

        assertEquals(1, pieceTotals.get("REDGENERAL"));
        assertEquals(2, pieceTotals.get("REDCHARIOT"));
        assertEquals(2, pieceTotals.get("REDHORSE"));
        assertEquals(2, pieceTotals.get("REDCANNON"));
        assertEquals(2, pieceTotals.get("REDADVISOR"));
        assertEquals(2, pieceTotals.get("REDMINSTER"));
        assertEquals(5, pieceTotals.get("REDSOLDIER"));
        assertEquals(1, pieceTotals.get("BLACKGENERAL"));
        assertEquals(2, pieceTotals.get("BLACKCHARIOT"));
        assertEquals(2, pieceTotals.get("BLACKHORSE"));
        assertEquals(2, pieceTotals.get("BLACKCANNON"));
        assertEquals(2, pieceTotals.get("BLACKADVISOR"));
        assertEquals(2, pieceTotals.get("BLACKMINSTER"));
        assertEquals(5, pieceTotals.get("BLACKSOLDIER"));

    }

    private Map<String, Integer> generatePieceTotalList() {
        Map<String, Integer> pieceTotals = new HashMap<>();
        String[] pieceNames = {"REDGENERAL", "REDCHARIOT", "REDHORSE", "REDCANNON", "REDADVISOR", "REDMINSTER", "REDSOLDIER",
                "BLACKGENERAL", "BLACKCHARIOT", "BLACKHORSE", "BLACKCANNON", "BLACKADVISOR", "BLACKMINSTER", "BLACKSOLDIER"};

        for (String pieceName : pieceNames) {
            pieceTotals.put(pieceName, 0);
        }

        return pieceTotals;
    }

    @Test
    void toStringTest() {
    }
}