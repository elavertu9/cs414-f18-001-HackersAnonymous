package com.hackersanon.banqi.database;

import com.hackersanon.banqi.database.entities.UserEntity;
import com.hackersanon.banqi.game.Game;
import org.hibernate.Session;

public class DAO implements Database
{
	Session session;
	public static Game getGame(String gameID)
	{
		return null;
	}
	
	
	
    public void openConnection()
	{
		this.session = DaoSessionFactory.getSessionFactory().openSession();
	}
	
	public void closeConnection()
	{
		this.session.close();
	}
	
	public UserEntity saveProfile(UserEntity userProfile)
	{
		this.session.beginTransaction();
		this.session.save(userProfile);
		this.session.getTransaction().commit();
		return userProfile;
	}
	

}
