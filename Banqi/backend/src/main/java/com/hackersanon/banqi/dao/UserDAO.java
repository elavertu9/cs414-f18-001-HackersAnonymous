package com.hackersanon.banqi.dao;

import com.hackersanon.banqi.model.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends IBaseRepository<User, Long>
{
    User findUserByUsername(String username);
}
