package com.hackersanon.banqi.player;

import com.hackersanon.banqi.piece.TeamColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player redPlayer;
    private Player blackPlayer;

    @BeforeEach
    void setUp() {
        redPlayer = new Player(TeamColor.RED);
        blackPlayer = new Player(TeamColor.BLACK);
    }

    @Test
    void isTurn() {
        assertFalse(redPlayer.isTurn());
        assertFalse(blackPlayer.isTurn());
    }

    @Test
    void toggleTurn() {
    }

    @Test
    void getPlayerTeam() {
    }
}