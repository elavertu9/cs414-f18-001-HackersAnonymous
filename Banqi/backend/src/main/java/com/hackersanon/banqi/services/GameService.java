package com.hackersanon.banqi.services;

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
	
	@Override public BanqiBoard getBoard(int gameId)
	{
		return null;
	}
	
	@Override public List<UserEntity> getPlayersByGameId(int gameId)
	{
		return null;
	}
	
	@Override public List<Integer> listAllGamesByUserId(int userID)
	{
		return null;
	}
	
	@Override public Game getGame(int gameId)
	{
		return null;
	}
	
	@Override public void saveGame(GameEntity game)
	{
		this.userDAO.saveGame(game);
	}

	
}
