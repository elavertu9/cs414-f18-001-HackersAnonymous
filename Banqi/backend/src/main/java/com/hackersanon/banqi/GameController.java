package com.hackersanon.banqi;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackersanon.banqi.board.BanqiBoard;
import com.hackersanon.banqi.database.entity.GameEntity;
import com.hackersanon.banqi.game.Game;
import com.hackersanon.banqi.services.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = {"http://localhost:8081"})
public class GameController
{
	@Autowired
	private IGameService gameService;
	
	@GetMapping("new")
	public Game newGame()
	{
		Game newGame = new Game();
		newGame.start();
		GameEntity gameEntity = new GameEntity();
		try {
			gameEntity.setGameObject(new ObjectMapper().writeValueAsString(newGame));
			gameService.saveGame(gameEntity);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return newGame;
	}
	
	@GetMapping("board")
	public BanqiBoard getBoard(@RequestAttribute(name = "gameId") int gameId)
	{
		return gameService.getBoard(gameId);
	}
}
