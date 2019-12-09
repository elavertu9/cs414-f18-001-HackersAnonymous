package com.hackersanon.banqi.service;

import com.hackersanon.banqi.model.user.User;

import java.util.List;

public interface IUserService extends IService<User>
{
    User createUser(User user);
    List listAllUsers();
    User findByUsername(String username);
    void deleteUserById(Long id);
    User updateUser(User user);
	
	String getUsername(Long userId);
}
