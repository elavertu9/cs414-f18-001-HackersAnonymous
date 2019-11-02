package com.hackersanon.banqi.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void toStringTest() {
    }
}