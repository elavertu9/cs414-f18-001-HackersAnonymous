package com.hackersanon.banqi;

import com.hackersanon.banqi.database.model.Board;
import com.hackersanon.banqi.database.model.Game;
import com.hackersanon.banqi.database.model.User;
import com.hackersanon.banqi.database.service.GameService;
import com.hackersanon.banqi.database.service.IGameService;
import com.hackersanon.banqi.database.service.IUserService;
import com.hackersanon.banqi.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8081"})
public class BackendController
{
    private IGameService gameService;

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

    @GetMapping("/user/add")
    public User createUser() {
        return null;
    }

    @Autowired
    public void setGameService(GameService gameService){
        this.gameService = gameService;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }


    @RequestMapping(value="*")
    public String fallbackPage() {
        return "Couldn't find the page you are looking for.";
    }
}