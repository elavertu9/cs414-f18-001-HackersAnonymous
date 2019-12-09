package com.hackersanon.banqi;

import com.hackersanon.banqi.board.InvalidCoordinateException;
import com.hackersanon.banqi.board.InvalidMoveException;
import com.hackersanon.banqi.database.model.*;
import com.hackersanon.banqi.database.service.GameService;
import com.hackersanon.banqi.database.service.IGameService;
import com.hackersanon.banqi.database.service.IUserService;
import com.hackersanon.banqi.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
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

    @GetMapping(value = "/game/list/{userId}")
    public List listGamesById(@PathVariable long userId){
        return gameService.findGamesByPlayerId(userId);
    }

    @GetMapping(value = "/admin/game/list/all")
    public List listAllExistingGames(){
        return gameService.findAllExistingGames();
    }

    @GetMapping(value = "/game/{gameId}/delete")
    public String deleteGameById(@PathVariable Long gameId){
        gameService.deleteGameById(gameId);
        return "Game Associated with GameId: " + gameId + "Has Been Deleted.";
    }

    @PostMapping(value = "/game/{gameId}/executeMove/{userId}")
    public Move executeMove(@PathVariable Long gameId,@PathVariable Long userId,@RequestBody Move move){
        try {
            move = gameService.executeMoveOnGame(gameId, userId, move);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        return move;
    }

    @PostMapping(value = "/game/{gameId}/validMoves")
    public ResponseEntity getValidMoves(@PathVariable Long gameId, @RequestBody Coordinate coordinate){
        ArrayList<Coordinate> moves;
        try {
            moves = gameService.validMoves(gameId, coordinate);
        } catch (InvalidCoordinateException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new InvalidCoordinateException());
        }
        if(moves.isEmpty()){
            return ResponseEntity.accepted().body("No Valid Moves Found");
        }else {
            return ResponseEntity.accepted().body(moves);
        }
    }

    @GetMapping(value = "/game/{gameId}/moveHistory")
    public ResponseEntity getMoveHistory(@PathVariable Long gameId){
        Game game = getGame(gameId);
        Collection moves = game.getMoveHistory();
        if(moves.isEmpty()){
            return ResponseEntity.accepted().body("No Move History Yet");
        }else{
            return ResponseEntity.accepted().body(moves);
        }
    }

    @Autowired
    public void setGameService(GameService gameService){
        this.gameService = gameService;
    }


    @RequestMapping(value = "/user/add", consumes = "application/Json")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping(value = "/user/{userId}")
    public User getUserById(@PathVariable long userId){
        return userService.findById(userId);
    }

    @GetMapping(value = "/user/byUsername/{username}")
    public User getUserByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @GetMapping(value = "/user/list")
    public List getAllUsers(){
        return userService.listAllUsers();
    }

    @GetMapping(value = "/user/{userId}/delete")
    public String deleteUserById(@PathVariable Long userId){

        userService.deleteUserById(userId);
        gameService.deleteGameByUserId(userId);
        return "User Corresponding To Id: "+userId+" Has Been Deleted.";
    }

    @PostMapping(value = "/user/edit", consumes = "application/Json")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
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