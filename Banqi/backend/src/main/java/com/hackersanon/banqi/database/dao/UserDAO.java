package com.hackersanon.banqi.database.dao;

import com.hackersanon.banqi.database.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends IBaseRepository<User, Long>
{
    User findUserByUsername(String username);
}
