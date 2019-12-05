package com.hackersanon.banqi.database.service;

import com.hackersanon.banqi.database.model.User;

import java.util.List;

public interface IUserService extends IService<User>
{
    User createUser(User user);
    List listAllUsers();
}
