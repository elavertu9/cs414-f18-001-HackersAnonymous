package com.hackersanon.banqi.database;

import com.hackersanon.banqi.database.entity.GameEntity;

public interface IGameDAO
{
	void save(GameEntity gameEntity);
}
