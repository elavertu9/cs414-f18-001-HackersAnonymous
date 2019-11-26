package com.hackersanon.banqi.services;

import com.hackersanon.banqi.board.BanqiBoard;
import com.hackersanon.banqi.database.entity.GameEntity;
import com.hackersanon.banqi.database.entity.UserEntity;
import com.hackersanon.banqi.game.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGameService
{
	BanqiBoard getBoard(int gameId);
	List<UserEntity> getPlayersByGameId(int gameId);
	List<Integer> listAllGamesByUserId(int userID);
	Game getGame(int gameId);
	void saveGame(GameEntity game);
}
