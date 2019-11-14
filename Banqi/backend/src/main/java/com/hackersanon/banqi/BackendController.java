package com.hackersanon.banqi;

import com.hackersanon.banqi.board.Square;
import com.hackersanon.banqi.game.Move;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class BackendController {

    @CrossOrigin(origins = {"http://localhost:8081"})
    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello from the backend!";
    }

    @CrossOrigin(origins = {"http://localhost:8081"})
    @GetMapping("/api/board")
    public Square[][] getBoard() {
        return null;
     }

    @CrossOrigin(origins = {"http://localhost:8081"})
    @GetMapping("/api/")
    public String executeMove() {//TODO JSON converter: Move Object to JSON?

        return null;
    }
}