package com.hackersanon.banqi;

import com.hackersanon.banqi.board.BanqiBoard;
import com.hackersanon.banqi.game.Game;
import com.hackersanon.banqi.game.Move;
import com.hackersanon.banqi.services.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8081"})
public class BackendController {

    @Autowired
    private IGameService gameService;

    @GetMapping("hello")
    public String sayHello() {
        return "Hello from the backend!";
    }

    @GetMapping("/retrieve/{gameId}")
    public Game retrieveGame(@RequestParam("gameId") String gameId){
        return null;
    }

    @RequestMapping("/api/move")
    public Move receiveMove( Move move){
//        Game currentGame = DAO.getGame(move.getGameID());
//        try {
//            assert currentGame != null;
//            currentGame.attemptMove(move);
//        }
//        catch (GameOverException e) {
//            System.out.println("Game OVER");
//        }
//        return move;
        return null;
    }

    @GetMapping("/api/move-history")
    public ArrayList<Move> getMoveHistory(@RequestParam("gameID") String gameID){
//        Game currentGame = DAO.getGame(gameID);
//
//        assert currentGame != null;
//        return currentGame.getMoveHistory();
        return null;
    }


    @GetMapping("/api/board")
    public BanqiBoard getBoard() {
        Game game = new Game();
        return game.getBanqiBoard();
    }


//    @CrossOrigin(origins = {"http://localhost:8081"})
//    @RequestMapping("/api/register")
//    public User registerUser(User user) {
//        User returnValue = null;
//        User tempProfile = new User();
//        BeanUtils.copyProperties(user, tempProfile);
////        UserEngine userEngine = new UserEngine();
////        UserProfile storedCredentials = userEngine.saveUser(tempProfile);
////
////        if(storedCredentials != null && !storedCredentials.getFirstName().isEmpty()){
////            returnValue = new UserProfile();
////            BeanUtils.copyProperties(storedCredentials, returnValue);
////
////        }
////
//        return user;
//
//    }

    @GetMapping("/api/")
    public String executeMove() {
        return null;
    }


    @RequestMapping(value="*")
    public String fallbackPage() {
        return "Couldn't find the page you are looking for.";
    }
}