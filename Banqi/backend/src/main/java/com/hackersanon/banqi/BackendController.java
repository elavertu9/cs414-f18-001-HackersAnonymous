package com.hackersanon.banqi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackersanon.banqi.database.Database;
import com.hackersanon.banqi.game.Game;
import com.hackersanon.banqi.game.Move;
import org.springframework.web.bind.annotation.*;

@RestController
public class BackendController {
    private ObjectMapper mapper = new ObjectMapper();
    @CrossOrigin(origins = {"http://localhost:8081"})
    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello from the backend!";
    }
    
    @CrossOrigin(origins = {"http://localhost:8081"})
    @GetMapping("/api/create")
    public String startGame() {

        try {
            return mapper.writeValueAsString(new Game());
        }
        catch (JsonProcessingException e) {
            System.out.println("Java to JSON conversion fail.");
        }
        return "";
        
    }
    
    @RequestMapping("/api/move")
    public Move receiveMove(@RequestParam("move") Move move){
        Game currentGame = Database.getGame(move.getGameID());
        return move;
    }
    
    @CrossOrigin(origins = {"http://localhost:8081"})
    @GetMapping("/api/board")
    public String getBoard() {
        Game game = new Game();
        game.start();

        try {
            return mapper.writeValueAsString(game.getClientBoard());
        } catch (JsonProcessingException e) {
            System.out.println("Java to JSON conversion fail.");
        }
        return "";
    }

     @CrossOrigin(origins = {"http://localhost:8081"})
    @GetMapping("/api/")
    public String executeMove() {
        
        return null;
    }
}