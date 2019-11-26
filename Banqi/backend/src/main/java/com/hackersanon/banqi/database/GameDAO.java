package com.hackersanon.banqi.database;

import com.hackersanon.banqi.database.entity.GameEntity;
import org.hibernate.SessionFactory;

public class GameDAO implements IGameDAO
{
	private SessionFactory sessionFactory;
	
	
	public void save(GameEntity gameEntity)
	{
		sessionFactory.getCurrentSession().save(gameEntity);
	}
	
	
}
