package com.hackersanon.banqi.database.service;


import com.hackersanon.banqi.database.model.Game;
import com.hackersanon.banqi.database.model.Move;

import java.util.List;

public interface IGameService extends IService<Game>
{
    Game createGame(Long p1id, Long p2id);
    Game createGame();
    Move newMoveOnGame(Move move);
    List<Game> findGamesByPlayerId(Long id);

    List<Game> findAllExistingGames();

    void deleteGameById(Long gameId);
}