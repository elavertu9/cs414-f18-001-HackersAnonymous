package com.hackersanon.banqi.model.game;

import com.hackersanon.banqi.model.board.Board;
import com.hackersanon.banqi.model.board.Coordinate;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest
{
    private Game game;
    private Game game2;
    private Coordinate origin;
    private Coordinate destination;
    private String quitter;
    private Board board;
    private Long p1id;
    private Long p2id;

    @Before
    public void before(){
        game = new Game();
        board = new Board();
        origin = new Coordinate(0,0);
        destination = new Coordinate(0,1);
        quitter = "quitter";
        p1id = 1234L;
        p2id = 4321L;
        game2 = new Game(board, p1id,p2id);
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

    @Test
    public void testCalculateGameOver(){
        game.setBoard(board);
        game.calculateGameOver();
        Assertions.assertFalse(game.isGameOver());
    }

    @Test
    public void testSetForfeit(){
        game.setForfeit(true);
        Assertions.assertTrue(game.isForfeit());
    }

    @Test
    public void testGetPlayerId(){
        game.setPlayerOneId(p1id);
        game.setPlayerTwoId(p2id);
        Assertions.assertEquals(p1id, game.getPlayerOneId());
        Assertions.assertEquals(p2id, game.getPlayerTwoId());
        Assertions.assertEquals(p1id, game2.getPlayerOneId());
        Assertions.assertEquals(p2id, game2.getPlayerTwoId());
    }
}
