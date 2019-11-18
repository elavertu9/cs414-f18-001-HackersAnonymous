package com.hackersanon.banqi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackersanon.banqi.database.DAO;
import com.hackersanon.banqi.game.Game;
import com.hackersanon.banqi.game.GameOverException;
import com.hackersanon.banqi.game.Move;
import com.hackersanon.banqi.user.User;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        Game currentGame = DAO.getGame(move.getGameID());
        try {
            assert currentGame != null;
            currentGame.attemptMove(move);
        }
        catch (GameOverException e) {
            System.out.println("Game OVER");
        }
        return move;
    }

    @GetMapping("/api/move-history")
    public ArrayList<Move> getMoveHistory(@RequestParam("gameID") String gameID){
        Game currentGame = DAO.getGame(gameID);

        assert currentGame != null;
        return currentGame.getMoveHistory();
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
    @RequestMapping("/api/register")
    public User registerUser(User user) {
        User returnValue = null;
        User tempProfile = new User();
        BeanUtils.copyProperties(user, tempProfile);
//        UserEngine userEngine = new UserEngine();
//        UserProfile storedCredentials = userEngine.saveUser(tempProfile);
//
//        if(storedCredentials != null && !storedCredentials.getFirstName().isEmpty()){
//            returnValue = new UserProfile();
//            BeanUtils.copyProperties(storedCredentials, returnValue);
//
//        }
//
        return user;

    }

     @CrossOrigin(origins = {"http://localhost:8081"})
    @GetMapping("/api/")
    public String executeMove() {
        
        return null;
    }
}