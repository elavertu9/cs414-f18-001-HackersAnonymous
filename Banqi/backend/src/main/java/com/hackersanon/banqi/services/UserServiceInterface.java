package com.hackersanon.banqi.services;

import com.hackersanon.banqi.database.entity.UsersEntity;
import com.hackersanon.banqi.user.UserProfile;

import java.util.List;

public interface UserServiceInterface
{
	public void addUser(UsersEntity usersEntity);
	
	public void updateUser(UsersEntity usersEntity);
	
	public List<UsersEntity> listUsers();
	public UserProfile getUser(int id);
	public void removeUser(int id);
}
