package com.hackersanon.banqi.service;

import com.hackersanon.banqi.dao.UserDAO;
import com.hackersanon.banqi.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserService implements IUserService
{
	private UserDAO userDAO;
	
	@Override
	public User findById(Long id)
	{
		return userDAO.findById(id).orElse(null);
	}

	@Override
	public User createUser(User user){
		return userDAO.save(user);
	}

	@Override
	public List listAllUsers(){
		List list = new ArrayList();
		userDAO.findAll().forEach(list::add);
		return list;
	}

	@Override
	public User findByUsername(String username) {
		return userDAO.findUserByUsername(username);
	}

	@Override
	public void deleteUserById(Long id){
		userDAO.deleteById(id);
	}

	@Override
	public User updateUser(User updatedUser) {
		System.out.printf("HERE");
		return userDAO.save(updatedUser);
	}
	
	@Override
	public String getUsername(Long userId)
	{
		User user = findById(userId);
		return user.getUsername();
	}
	
	@Autowired
	public void setUserDAO(final UserDAO userDAO){
		this.userDAO = userDAO;
	}

}
