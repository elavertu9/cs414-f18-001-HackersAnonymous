package com.hackersanon.banqi.database.service;

import com.hackersanon.banqi.game.Game;

public interface IGameService extends IService<Game>
{
	Game createGame();
}