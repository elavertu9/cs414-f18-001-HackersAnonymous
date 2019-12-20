package com.hackersanon.banqi.service;

import com.hackersanon.banqi.dao.GameDAO;
import com.hackersanon.banqi.model.game.Game;
import com.hackersanon.banqi.model.game.GameBuilder;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.when;

public class GameServiceTest
{
    @Mock
    private GameDAO gameDAO;

    @Mock
    private Game game;
    
    @Mock
    private GameBuilder gameBuilder;

    private IGameService gameService;
    private Long id = 1L;
    private Long p1id = 21L;
    private Long p2id = 22L;
    private String username;



    @Before
    public void before(){
        username = "testUsername";
        MockitoAnnotations.initMocks(this);
        gameService = new GameService(gameDAO);
        when(gameDAO.findById(id)).thenReturn(Optional.of(game));
        when(gameDAO.save(ArgumentMatchers.any(Game.class))).then(returnsFirstArg());
        when(gameDAO.findGamesByPlayerTwoIdOrPlayerOneId(p1id, p2id)).thenReturn(Lists.newArrayList(game));
        when(gameService.findAllExistingGames()).thenReturn(Lists.newArrayList(game));
    }


    @After
    public void after(){
        gameService = null;
    }

    @Test
    public void testCreateGame(){

        Game testGame = gameService.createGame(p1id,p2id);

        assertEquals(p1id, testGame.getPlayerOneId());
    }

    @Test
    public void testCreateGameNoParam(){
        Game testGame = gameService.createGame();
        assertEquals(game.getPlayerOneId(),game.getPlayerOneId());
    }

    @Test
    public void testFindById(){
        assertEquals(game, gameService.findById(id));
    }


    @Test
    public void testFindAllExistingGames(){
        assertEquals(Lists.newArrayList(game), gameService.findAllExistingGames());
    }



}
