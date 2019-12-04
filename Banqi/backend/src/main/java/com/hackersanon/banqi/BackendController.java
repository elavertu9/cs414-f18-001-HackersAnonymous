package com.hackersanon.banqi;

import com.hackersanon.banqi.database.model.Board;
import com.hackersanon.banqi.database.model.Game;
import com.hackersanon.banqi.database.service.IGameService;
import com.hackersanon.banqi.database.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8081"})
public class BackendController
{
    @Autowired
    private IGameService gameService;
    
    @Autowired
    private IUserService userService;
    
    @GetMapping(value = "/game/hello")
    public String sayHello()
    {
        return "Hello from the backend!";
    }

    @GetMapping("/game/{gameId}")
    public Game getGame(@PathVariable Long gameId){
        return gameService.findById(gameId);
    }
    
    @GetMapping("/game/{gameId}/board")
    public Board getBoard(@PathVariable Long gameId)
    {
        return gameService.findById(gameId).getBoard();
    }
    
    @GetMapping("/game/create")
    public Game createGame()
    {
        return gameService.createGame();
    }
    

}