package com.hackersanon.banqi.database.service;

import com.hackersanon.banqi.database.dao.UserDAO;
import com.hackersanon.banqi.database.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserService implements IUserService
{
	@Autowired
	public UserDAO userDAO;
	
	@Override
	public User findById(Long id)
	{
		return userDAO.findById(id).orElse(null);
	}
}