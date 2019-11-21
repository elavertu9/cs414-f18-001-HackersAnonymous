package com.hackersanon.banqi.services;

import com.hackersanon.banqi.database.UserDAO;
import com.hackersanon.banqi.database.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserService implements UserServiceInterface
{
	@Autowired
	private UserDAO userDAO;

	public void saveUser(UserEntity usersEntity) {
			userDAO.save(usersEntity);
	}

	public List getAllUsers() {
		List list = new ArrayList();
		userDAO.findAll().forEach(list::add);
		return list;
	}

	public UserEntity getUser(int id)
	{
		return this.userDAO.findById(id);
	}

	public void removeUser(int id)
	{
			this.userDAO.deleteById(id);
	}
}
