package com.hackersanon.banqi.game;

import com.hackersanon.banqi.board.Coordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void start() {
        game.start();
        assertNotNull(game.getBanqiBoard().getPieceAt(new Coordinate(0, 0)));
    }

    @Disabled("Waiting for implementation")
    @Test
    void isGameOver() {
    }

    @Disabled("Waiting for implementation")
    @Test
    void undoMove() {
    }

    @Test
    void getValidMoves() {
    }

    @Test
    void getBanqiBoard() {
        assertNotNull(game.getBanqiBoard());
    }

    @Test
    void getPlayers() {
        assertNotNull(game.getPlayers());
    }

    @Test
    void getMoveHistory() {
        assertNotNull(game.getMoveHistory());
    }
}