package com.hackersanon.banqi.dao;

import com.hackersanon.banqi.model.game.Game;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameDAO extends IBaseRepository<Game, Long>
{
    @Override
    List<Game> findAll();
    List<Game> findGamesByPlayerOneId(Long id);
    List<Game> findGamesByPlayerTwoId(Long id);
    List<Game> findGamesByPlayerTwoIdOrPlayerOneId(Long p1id, Long p2id);
}
