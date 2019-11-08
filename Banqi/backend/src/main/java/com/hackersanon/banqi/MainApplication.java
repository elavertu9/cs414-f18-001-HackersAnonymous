package com.hackersanon.banqi;

import com.hackersanon.banqi.board.BanqiBoard;
import com.hackersanon.banqi.board.Coordinate;
import com.hackersanon.banqi.game.Game;
import com.hackersanon.banqi.game.GameOverException;
import com.hackersanon.banqi.game.Move;
import com.hackersanon.banqi.player.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

        Game newGame = new Game();
        newGame.start();
        Scanner sc = new Scanner(System.in).useDelimiter("\\s");
        try {
            while(!(true == false) && (false == false)){
                newGame.getBanqiBoard().printBoard();
                System.out.println("Command Format:\n move a2 a3\nflip a2\n");
                System.out.print("Enter your move:\n>");

                String inputMoveType = sc.next();
                if(inputMoveType.equalsIgnoreCase("exit")){
                    break;
                }
                String inputOrigin,inputDestination;
                inputOrigin = sc.next();
                if(inputMoveType.equalsIgnoreCase("move")){
                    inputDestination = sc.next();
                    newGame.attemptMove(inputOrigin, inputDestination);
                }else{
                    newGame.attemptMove(inputOrigin,inputOrigin);
                }
            }
        } catch (GameOverException e){
            System.out.println("Game Over!");
        }
        System.exit(0);
    }
}