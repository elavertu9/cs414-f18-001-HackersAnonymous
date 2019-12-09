package com.hackersanon.banqi.controller;

import com.hackersanon.banqi.exception.InvalidCoordinateException;
import com.hackersanon.banqi.exception.InvalidMoveException;
import com.hackersanon.banqi.model.board.Coordinate;
import com.hackersanon.banqi.model.game.Game;
import com.hackersanon.banqi.model.game.Move;
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
@RequestMapping("/api/game")
@CrossOrigin(origins = {"http://localhost:8081"})
public class GameController
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
    
    
    
    @GetMapping(value = "/hello")
    public ResponseEntity sayHello()
    {
        return ResponseEntity.accepted().body("Hello from the backend!");
    }
    
    @GetMapping(value = "/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable Long gameId){
        return ResponseEntity.accepted().body(gameService.findById(gameId));
    }
    
    @GetMapping(value = "/{gameId}/board")
    public ResponseEntity getBoard(@PathVariable Long gameId)
    {
        Game game = gameService.findById(gameId);
        return ResponseEntity.accepted().body(game.getBoard());
    }
    
    @GetMapping(value = "/create")
    public ResponseEntity createGame(){
        return ResponseEntity.accepted().body(gameService.createGame());
    }
    
    @GetMapping(value = "/create/{p1id}/{p2id}")
    public ResponseEntity createGame(@PathVariable Long p1id,@PathVariable Long p2id)
    {
        return ResponseEntity.accepted().body(gameService.createGame(p1id,p2id));
    }
    
    @GetMapping(value = "/list/{userId}")
    public ResponseEntity<List<Game>> listGamesById(@PathVariable Long userId){
        return ResponseEntity.accepted().body(gameService.findGamesByPlayerId(userId));
    }
    
    @GetMapping(value = "/admin/game/list/all")
    public ResponseEntity<List<Game>> listAllExistingGames(){
        return ResponseEntity.accepted().body(gameService.findAllExistingGames());
    }
    
    @GetMapping(value = "/{gameId}/delete")
    public ResponseEntity deleteGameById(@PathVariable Long gameId){
        gameService.deleteGameById(gameId);
        return ResponseEntity.accepted().body("Game Associated with GameId: " + gameId + "Has Been Deleted.");
    }
    
    @PostMapping(value = "/{gameId}/executeMove/{userId}")
    public ResponseEntity executeMove(@PathVariable Long gameId,@PathVariable Long userId,@RequestBody Move move){
        try {
            move = gameService.executeMoveOnGame(gameId, userId, move);
        } catch (InvalidMoveException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid Move Exception");
        }
        return ResponseEntity.accepted().body(move);
    }
    
    @PostMapping(value = "/{gameId}/validMoves")
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
    
    @GetMapping(value = "/{gameId}/moveHistory")
    public ResponseEntity<? extends Object> getMoveHistory(@PathVariable Long gameId){
        Game game = getGame(gameId).getBody();
        Collection<Move> moves = game.getMoveHistory();
        if(moves.isEmpty()){
            return ResponseEntity.accepted().body("No Move History Yet");
        }else{
            return ResponseEntity.accepted().body(moves);
        }
    }
    
    @GetMapping(value = "/{gameId}/{userId}/forfeit")
    public ResponseEntity forfeitGame(@PathVariable Long gameId, @PathVariable Long userId)
    {
        String username = userService.getUsername(userId);
        gameService.forfeitGame(gameId,username);
        return ResponseEntity.accepted().body(username+" FORFEITS");
    }
}