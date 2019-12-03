package com.hackersanon.banqi.controller;

import com.hackersanon.banqi.board.BanqiBoard;
import com.hackersanon.banqi.database.service.IGameService;
import com.hackersanon.banqi.database.service.IUserService;
import com.hackersanon.banqi.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
@CrossOrigin(origins = {"http://localhost:8081"})
public class BackendController
{
    @Autowired
    private IGameService gameService;
    
    @Autowired
    private IUserService userService;
    
    @GetMapping("hello")
    public String sayHello()
    {
        return "Hello from the backend!";
    }
    
    @GetMapping("/game/{gameId}/board")
    public BanqiBoard getBoard(@PathVariable Long gameId)
    {
        return gameService.findById(gameId).getBanqiBoard();
    }
    
    @GetMapping("/game/create")
    public Game createGame()
    {
        return gameService.createGame();
    }
    

}