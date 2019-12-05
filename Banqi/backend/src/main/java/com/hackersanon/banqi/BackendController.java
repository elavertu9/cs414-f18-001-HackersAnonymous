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

import java.util.List;

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

    @GetMapping(value = "/game/{gameId}")
    public Game getGame(@PathVariable Long gameId){
        return gameService.findById(gameId);
    }

    @GetMapping(value = "/game/{gameId}/board")
    public Board getBoard(@PathVariable Long gameId)
    {
        Game game = gameService.findById(gameId);
        return game.getBoard();
    }

    @GetMapping(value = "/game/create")
    public Game createGame(){
        return gameService.createGame();
    }

    @GetMapping(value = "/game/create/{p1id}/{p2id}")
    public Game createGame(@PathVariable long p1id,@PathVariable long p2id)
    {
        return gameService.createGame(p1id,p2id);
    }

    @RequestMapping(value = "/user/add", consumes = "application/Json")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping(value = "/user/list")
    public List getAllUsers(){
        return userService.listAllUsers();
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