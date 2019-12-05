package com.hackersanon.banqi.database.service;


import com.hackersanon.banqi.database.model.Game;

public interface IGameService extends IService<Game>
{
	Game createGame();
}