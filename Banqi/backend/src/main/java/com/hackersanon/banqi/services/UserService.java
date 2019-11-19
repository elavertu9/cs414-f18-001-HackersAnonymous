package com.hackersanon.banqi.services;

import com.hackersanon.banqi.database.UserRepository;
import com.hackersanon.banqi.database.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value="userService")
@Transactional
public class UserService implements UserServiceInterface
{
	private UserRepository userRepository;

	public UserService() {
	}

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	public boolean saveUser(UserEntity usersEntity) {
		try{
			userRepository.save(usersEntity);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	public List getAllUsers() {
		List list = new ArrayList();
		userRepository.findAll().forEach(list::add);
		return list;
	}

	public UserEntity getUser(int id)
	{
		return this.userRepository.findById(id).get();
	}

	public boolean removeUser(int id)
	{
		try{
			this.userRepository.deleteById(id);
			return true;
		}catch (Exception e){
			return false;
		}
	}
}
