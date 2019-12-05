package com.hackersanon.banqi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackersanon.banqi.board.BanqiBoard;
import com.hackersanon.banqi.database.UserDAO;
import com.hackersanon.banqi.database.entity.GameEntity;
import com.hackersanon.banqi.database.entity.UserEntity;
import com.hackersanon.banqi.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class GameService implements IGameService
{
	@Autowired
	private UserDAO userDAO;
	
	@Override public BanqiBoard getBoard(long gameId)
	{
		Game currentGame = getGame(gameId);
		return currentGame.getBanqiBoard();
	}
	
	@Override public List<UserEntity> getPlayersByGameId(long gameId)
	{
		return null;
	}
	
	@Override public List<Integer> listAllGamesByUserId(int userID)
	{
		return null;
	}
	
	@Override public Game getGame(long gameId)
	{
		GameEntity gameEntity = userDAO.findGameById(gameId);
		try {
			Game currentGame = new ObjectMapper().readValue(gameEntity.getGameObject(), Game.class);
			return currentGame;
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
			System.err.println("GameEntity conversion to Game Failed...");
		}
		return null;
	}
	
	@Override public void saveGame(GameEntity game)
	{
		this.userDAO.saveGame(game);
	}

	
}
