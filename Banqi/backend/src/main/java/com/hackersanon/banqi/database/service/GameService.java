package com.hackersanon.banqi.database.service;

import com.hackersanon.banqi.database.dao.GameDAO;
import com.hackersanon.banqi.database.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class GameService implements IGameService
{

	private GameDAO gameDAO;
	
	
	@Override
	public Game findById(Long id)
	{
		return gameDAO.findById(id).orElse(null);
	}
	
	
	@Override
	public Game createGame()
	{
		Game game = new Game();
		return gameDAO.save(game);
	}

	@Autowired
	public void setGameDAO(final GameDAO gameDAO){
		this.gameDAO = gameDAO;
	}
	
}
