package com.hackersanon.banqi.user;

import com.hackersanon.banqi.database.Database;
import com.hackersanon.banqi.database.entities.UserEntity;
import org.springframework.beans.BeanUtils;

public class UserEngine
{
	private Database database;
	
	public UserProfile saveUser(UserProfile userProfile){
		UserProfile tempUser = null;
		
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(userProfile, userEntity);
		try{
			this.database.openConnection();
			UserEntity storedUser = this.database.saveProfile(userEntity);
			if(storedUser != null && storedUser.getId()>0){
				tempUser = new UserProfile();
				BeanUtils.copyProperties(storedUser, tempUser);
			}
		}finally {
			this.database.closeConnection();
		}
		return tempUser;
	}
}
