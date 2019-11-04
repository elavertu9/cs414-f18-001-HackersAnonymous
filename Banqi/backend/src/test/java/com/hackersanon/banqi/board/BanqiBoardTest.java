package com.hackersanon.banqi.board;

import com.hackersanon.banqi.piece.Piece;
import com.hackersanon.banqi.piece.PieceAttributes;
import com.hackersanon.banqi.piece.TeamColor;
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
    void getPieceAtNullSquare() {
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

        for(PieceAttributes piece: PieceAttributes.values()){

        }

    }

    private Map<String, Integer> generatePieceTotalList() {
        Map<String, Integer> pieceTotals = new HashMap<>();
        String[] pieceNames = {"REDGENERAL", "REDCHARIOT", "REDHORSE", "REDCANNON", "REDADVISOR", "REDMINSTER", "REDSOLDIER",
                "BLACKGENERAL", "BLACKCHARIOT", "BLACKHORSE", "BLACKCANNON", "BLACKADVISOR", "BLACKMINSTER", "BLACKSOLDIER"};

        for (Piece piece : banqiBoard.initAllPieces()) {
            pieceTotals.put(piece.toString(), 0);
        }

        return pieceTotals;
    }

    @Test
    void toStringTest() {
    }
}