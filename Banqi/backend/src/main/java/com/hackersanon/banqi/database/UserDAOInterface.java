package com.hackersanon.banqi.database;

import com.hackersanon.banqi.database.entity.UsersEntity;
import com.hackersanon.banqi.user.UserProfile;

import java.util.List;

public interface UserDAOInterface
{
	public void addUser(UsersEntity usersEntity);
	public void updateUser(UsersEntity usersEntity);
	public List<UsersEntity> listUsers();
	public UserProfile getUser(int userID);
	public void removeUser(int userID);
}
