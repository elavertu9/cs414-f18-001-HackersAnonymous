package com.hackersanon.banqi.services;

import com.hackersanon.banqi.database.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceInterface
{
	void saveUser(UserEntity usersEntity);
	List getAllUsers();
	UserEntity getUser(int id);
	void removeUser(int id);
}
