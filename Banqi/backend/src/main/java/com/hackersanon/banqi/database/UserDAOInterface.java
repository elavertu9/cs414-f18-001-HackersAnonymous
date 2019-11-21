package com.hackersanon.banqi.database;

import com.hackersanon.banqi.database.entity.UserEntity;

import java.util.List;

public interface UserDAOInterface
{
	void save(UserEntity usersEntity);
	void updateUser(UserEntity usersEntity);
	List<UserEntity> findAll();
	UserEntity findById(int id);
	void deleteById(int userID);
}
