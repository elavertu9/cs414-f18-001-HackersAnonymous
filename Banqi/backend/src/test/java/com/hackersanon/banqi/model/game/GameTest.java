package com.hackersanon.banqi.model.game;

import com.hackersanon.banqi.model.board.Board;
import com.hackersanon.banqi.model.board.Coordinate;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest
{
    private Game game;
    private Coordinate origin;
    private Coordinate destination;
    private String quitter;
    private Board board;

    @Before
    public void before(){
        game = new Game();
        board = new Board();
        origin = new Coordinate(0,0);
        destination = new Coordinate(0,1);
        String quitter = "quitter";
    }

    @Test
    public void testSetGameOver(){
        game.setBoard(board);
        game.setGameOver(true);
        Assertions.assertTrue(game.isGameOver());
        game.setGameOver(false);
        Assertions.assertFalse(game.isGameOver());
    }

    @Test
    public void testSetQuitter(){
        game.setQuitter(quitter);
        Assertions.assertEquals(quitter, game.getQuitter());
    }

    @Test
    public void testSetBoard(){
        game.setBoard(board);
        Assertions.assertEquals(board,game.getBoard());
    }

}
