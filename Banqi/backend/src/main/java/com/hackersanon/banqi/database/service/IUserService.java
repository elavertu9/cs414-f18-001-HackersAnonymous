package com.hackersanon.banqi.database.service;

import com.hackersanon.banqi.database.model.User;

public interface IUserService extends IService<User>
{
    User createUser(User user);
}
