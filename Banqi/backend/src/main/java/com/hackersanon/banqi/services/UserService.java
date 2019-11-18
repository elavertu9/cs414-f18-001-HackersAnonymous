package com.hackersanon.banqi.services;

import com.hackersanon.banqi.database.UserDAO;
import com.hackersanon.banqi.database.entity.UsersEntity;
import com.hackersanon.banqi.user.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements UserServiceInterface
{
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	@Transactional
	public void addUser(UsersEntity user)
	{
			this.userDAO.addUser(user);
	}
	
	@Override
	@Transactional
	public void updateUser(UsersEntity usersEntity)
	{
		this.userDAO.updateUser(usersEntity);
	}
	
	@Override
	@Transactional
	public List<UsersEntity> listUsers()
	{
		return null;
	}
	
	@Override
	@Transactional
	public User getUser(int id)
	{
		return null;
	}
	
	@Override
	@Transactional
	public void removeUser(int id)
	{
	
	}
}
