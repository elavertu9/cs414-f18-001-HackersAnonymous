package com.hackersanon.banqi.database.dao;

import com.hackersanon.banqi.database.model.Game;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDAO extends IBaseRepository<Game, Long>
{
}
