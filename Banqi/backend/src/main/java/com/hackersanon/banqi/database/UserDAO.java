package com.hackersanon.banqi.database;

import com.hackersanon.banqi.database.entity.UsersEntity;
import com.hackersanon.banqi.user.UserProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAO implements UserDAOInterface
{
	private SessionFactory sessionFactory;
	
	@Override public void addUser(UsersEntity usersEntity)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(usersEntity);
		
	}
	
	@Override public void updateUser(UsersEntity usersEntity)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.update(usersEntity);
	}
	
	@Override public List<UsersEntity> listUsers()
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<UsersEntity> userList = session.createQuery("from UsersEntity").list();

		return userList;
	}
	
	@Override public UserProfile getUser(int userID)
	{
		Session session = this.sessionFactory.getCurrentSession();
		return session.load(UserProfile.class, userID);
	}
	
	@Override public void removeUser(int userID)
	{
		Session session = this.sessionFactory.getCurrentSession();
		UsersEntity usersEntity = session.load(UsersEntity.class, userID);
		if (usersEntity != null) {
			session.delete(usersEntity);
		}
	}
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
}
