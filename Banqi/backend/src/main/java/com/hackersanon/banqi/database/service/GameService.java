package com.hackersanon.banqi.database.service;

import com.hackersanon.banqi.board.InvalidMoveException;
import com.hackersanon.banqi.database.dao.GameDAO;
import com.hackersanon.banqi.database.model.Board;
import com.hackersanon.banqi.database.model.Game;
import com.hackersanon.banqi.database.model.Move;
import com.hackersanon.banqi.game.MoveFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class GameService implements IGameService
{

	private GameDAO gameDAO;
	
	
	@Override
	public Game findById(Long id)
	{
		return gameDAO.findById(id).orElse(null);
	}

	@Override
	public Game createGame() {
		Game game = new Game();
		game.setBoard(new Board());
		return gameDAO.save(game);
	}

	@Override
	public Game createGame(Long p1id, Long p2id)
	{
		Game game = new Game();
		game.setPlayerOneId(p1id);
		game.setPlayerTwoId(p2id);
		game.setBoard(new Board());
		return gameDAO.save(game);
	}

	@Override
	public Move executeMoveOnGame(Long gameId, Move move) throws InvalidMoveException {
		assert gameDAO.findById(gameId).isPresent();
		Game game = gameDAO.findById(gameId).get();
		Board board = game.getBoard();
		return MoveFunctions.makeMove(board,move);

	}

	@Override
	public List<Game> findGamesByPlayerId(Long id){
		return gameDAO.findGamesByPlayerTwoIdOrPlayerOneId(id,id);
	}

	@Override
	public List<Game> findAllExistingGames(){
		return gameDAO.findAll();
	}

	@Override
	public void deleteGameById(Long gameId){
		gameDAO.deleteById(gameId);
	}

	@Autowired
	public void setGameDAO(final GameDAO gameDAO){
		this.gameDAO = gameDAO;
	}
	
}
