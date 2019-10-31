package com.hackersanon.banqi;

import com.hackersanon.banqi.board.BanqiBoard;
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
	}
}