package com.hackersanon.banqi;

import com.hackersanon.banqi.exception.InvalidCoordinateException;
import com.hackersanon.banqi.exception.InvalidMoveException;
import com.hackersanon.banqi.model.board.Coordinate;
import com.hackersanon.banqi.model.game.Game;
import com.hackersanon.banqi.model.game.Move;
import com.hackersanon.banqi.model.user.User;
import com.hackersanon.banqi.service.GameService;
import com.hackersanon.banqi.service.IGameService;
import com.hackersanon.banqi.service.IUserService;
import com.hackersanon.banqi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
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
    
    @Autowired
    public void setGameService(GameService gameService){
        this.gameService = gameService;
    }
    
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }
    
    
    
    @GetMapping(value = "/game/hello")
    public ResponseEntity sayHello()
    {
        return ResponseEntity.accepted().body("Hello from the backend!");
    }
    
    @GetMapping(value = "/game/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable Long gameId){
        return ResponseEntity.accepted().body(gameService.findById(gameId));
    }
    
    @GetMapping(value = "/game/{gameId}/board")
    public ResponseEntity getBoard(@PathVariable Long gameId)
    {
        Game game = gameService.findById(gameId);
        return ResponseEntity.accepted().body(game.getBoard());
    }
    
    @GetMapping(value = "/game/create")
    public ResponseEntity createGame(){
        return ResponseEntity.accepted().body(gameService.createGame());
    }
    
    @GetMapping(value = "/game/create/{p1id}/{p2id}")
    public ResponseEntity createGame(@PathVariable Long p1id,@PathVariable Long p2id)
    {
        return ResponseEntity.accepted().body(gameService.createGame(p1id,p2id));
    }
    
    @GetMapping(value = "/game/list/{userId}")
    public ResponseEntity<List<Game>> listGamesById(@PathVariable Long userId){
        return ResponseEntity.accepted().body(gameService.findGamesByPlayerId(userId));
    }
    
    @GetMapping(value = "/admin/game/list/all")
    public ResponseEntity<List<Game>> listAllExistingGames(){
        return ResponseEntity.accepted().body(gameService.findAllExistingGames());
    }
    
    @GetMapping(value = "/game/{gameId}/delete")
    public ResponseEntity deleteGameById(@PathVariable Long gameId){
        gameService.deleteGameById(gameId);
        return ResponseEntity.accepted().body("Game Associated with GameId: " + gameId + "Has Been Deleted.");
    }
    
    @PostMapping(value = "/game/{gameId}/executeMove/{userId}")
    public ResponseEntity executeMove(@PathVariable Long gameId,@PathVariable Long userId,@RequestBody Move move){
        try {
            move = gameService.executeMoveOnGame(gameId, userId, move);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid Move Exception");
        }
        return ResponseEntity.accepted().body(move);
    }
    
    @PostMapping(value = "/game/{gameId}/validMoves")
    public ResponseEntity<? extends Serializable> getValidMoves(@PathVariable Long gameId, @RequestBody Coordinate coordinate){
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
        Game game = getGame(gameId).getBody();
        Collection moves = game.getMoveHistory();
        if(moves.isEmpty()){
            return ResponseEntity.accepted().body("No Move History Yet");
        }else{
            return ResponseEntity.accepted().body(moves);
        }
    }
    
    @GetMapping(value = "/game/{gameId}/{userId}/forfeit")
    public ResponseEntity forfeitGame(@PathVariable Long gameId, @PathVariable Long userId)
    {
        String username = userService.getUsername(userId);
        gameService.forfeitGame(gameId,username);
        return ResponseEntity.accepted().body(username+" FORFEITS");
    }
    
    
    @RequestMapping(value = "/user/add", consumes = "application/Json", produces = "application/Json")
    public ResponseEntity createUser(@RequestBody User user) {
        return ResponseEntity.accepted().body(userService.createUser(user));
    }

    @GetMapping(value = "/user/{userId}", produces = "application/Json")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){
        return ResponseEntity.accepted().body(userService.findById(userId));
    }

    @GetMapping(value = "/user/byUsername/{username}", produces = "application/Json")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        return ResponseEntity.accepted().body(userService.findByUsername(username));
    }

    @GetMapping(value = "/user/list")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.accepted().body(userService.listAllUsers());
    }

    @GetMapping(value = "/user/{userId}/delete", produces = "application/Json")
    public ResponseEntity deleteUserById(@PathVariable Long userId){

        userService.deleteUserById(userId);
        gameService.deleteGameByUserId(userId);
        return ResponseEntity.accepted().body("User Corresponding To Id: "+userId+" Has Been Deleted.");
    }

    @PostMapping(value = "/user/edit", consumes = "application/Json", produces = "application/Json")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }


    @RequestMapping(value="*")
    public ResponseEntity fallbackPage() {
        return ResponseEntity.badRequest().body("Couldn't find the page you are looking for.");
    }
}