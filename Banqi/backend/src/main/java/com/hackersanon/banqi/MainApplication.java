package com.hackersanon.banqi;

import com.hackersanon.banqi.board.BanqiBoard;
import com.hackersanon.banqi.board.Coordinate;
import com.hackersanon.banqi.game.Game;
import com.hackersanon.banqi.game.Move;
import com.hackersanon.banqi.player.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);

        BanqiBoard banqiBoard = new BanqiBoard();
        banqiBoard.initialize();
		System.out.println(banqiBoard.toString());
		Game newGame = new Game();
		newGame.start();
		System.out.println(newGame.getBanqiBoard().toString());
		Move flip = new Move(newGame.getBanqiBoard(),
				newGame.getBanqiBoard().getSquare(new Coordinate(0,0)),
				newGame.getBanqiBoard().getSquare(new Coordinate(0,0)));
		Move flip2 = new Move(newGame.getBanqiBoard(), newGame.getBanqiBoard()
				.getSquare(new Coordinate(0,1)),
				newGame.getBanqiBoard().getSquare(new Coordinate(0,1)));

		newGame.attemptMove(flip);
		newGame.attemptMove(flip2);
		Move tempMove = new Move(newGame.getBanqiBoard(),new Coordinate(0,0),
				new Coordinate(0,1));
		newGame.attemptMove(tempMove);
		System.out.println(newGame.getBanqiBoard().toString());
	}
}