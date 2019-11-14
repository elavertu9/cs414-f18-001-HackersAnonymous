package com.hackersanon.banqi.database;

import com.hackersanon.banqi.database.entities.UserEntity;

public interface Database
{
	public void openConnection();
	public void closeConnection();
	public UserEntity saveProfile(UserEntity userProfile);
}
