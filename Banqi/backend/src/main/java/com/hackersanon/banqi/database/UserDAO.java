package com.hackersanon.banqi.database;

import com.hackersanon.banqi.database.entity.GameEntity;
import com.hackersanon.banqi.database.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDAO implements UserDAOInterface
{
	@Autowired
	private SessionFactory sessionFactory;
	

	public void save(UserEntity userEntity)
	{
		sessionFactory.getCurrentSession().save(userEntity);
	}
	
	public void saveGame(GameEntity gameEntity){
		sessionFactory.getCurrentSession().save(gameEntity);
	}
	
	public void updateGame(GameEntity gameEntity)
	{
	
	}
	
	public void updateUser(UserEntity userEntity)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.update(userEntity);
	}
	

	public List<UserEntity> findAll()
	{
		@SuppressWarnings("unchecked")
		TypedQuery<UserEntity> userList = sessionFactory.getCurrentSession().createQuery("from UserEntity");
		return userList.getResultList();
	}
	
	public UserEntity findById(int userID)
	{
		Session session = this.sessionFactory.getCurrentSession();
		return session.load(UserEntity.class, userID);
	}
	
	 public void deleteById(int userID)
	{
		Session session = this.sessionFactory.getCurrentSession();
		UserEntity userEntity = session.load(UserEntity.class, userID);
		if (userEntity != null) {
			session.delete(userEntity);
		}
	}
	
	public GameEntity findGameById(long gameId)
	{
		Session session = this.sessionFactory.getCurrentSession();
		GameEntity gameEntity = session.load(GameEntity.class, gameId);
		return gameEntity;
	}

}
