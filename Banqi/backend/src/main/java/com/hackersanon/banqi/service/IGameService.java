package com.hackersanon.banqi.service;


import com.hackersanon.banqi.exception.InvalidCoordinateException;
import com.hackersanon.banqi.exception.InvalidMoveException;
import com.hackersanon.banqi.model.board.Coordinate;
import com.hackersanon.banqi.model.game.Game;
import com.hackersanon.banqi.model.game.Move;

import java.util.ArrayList;
import java.util.List;

public interface IGameService extends IService<Game>
{
    Game createGame(Long p1id, Long p2id);
    Game createGame();
	
	Move executeMoveOnGame(Long gameId, Long userId, Move move) throws InvalidMoveException;
	
	void forfeitGame(Long gameId, String username);
	
	ArrayList<Coordinate> validMoves(Long gameId, Coordinate coordinate) throws InvalidCoordinateException;

    List<Game> findGamesByPlayerId(Long id);

    List<Game> findAllExistingGames();

    void deleteGameById(Long gameId);

    void deleteGameByUserId(Long userId);
}