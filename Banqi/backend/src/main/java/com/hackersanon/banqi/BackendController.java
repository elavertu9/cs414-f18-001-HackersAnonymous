package com.hackersanon.banqi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackersanon.banqi.game.Game;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {
    ObjectMapper mapper = new ObjectMapper();
    @CrossOrigin(origins = {"http://localhost:8081"})
    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello from the backend!";
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
    public String executeMove() {//TODO JSON converter: Move Object to JSON?
        
        return null;
    }
}