package com.hackersanon.banqi.model.game;

import com.hackersanon.banqi.model.board.BoardBuilder;
import com.hackersanon.banqi.model.board.Piece;
import com.hackersanon.banqi.model.board.PieceFactory;
import com.hackersanon.banqi.model.board.TeamColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.hackersanon.banqi.model.board.PieceAttributes.*;
import static com.hackersanon.banqi.model.board.PieceAttributes.SOLDIER;

public class GameBuilder
{
	BoardBuilder boardBuilder;
	
	public GameBuilder()
	{
		boardBuilder = new BoardBuilder();
	}
	
	public Game createBanqiGame(){
		Game game = new Game();
		game.setBoard(boardBuilder.buildBoard(4,8, getBanqiPieceList()));
		return game;
	}
	
	public Game createBanqiGame(Long playerOneId, Long playerTwoId)
	{
		Game game = createBanqiGame();
		game.setPlayerOneId(playerOneId);
		game.setPlayerTwoId(playerTwoId);
		return game;
	}
	
	private static ArrayList<Piece> getBanqiPieceList(){
		ArrayList<Piece> allPiece = initTeamPieces(TeamColor.RED);
		allPiece.addAll(initTeamPieces(TeamColor.BLACK));
		for(int i=0;i<5;++i){
			Collections.shuffle(allPiece);
		}
		return allPiece;
	}
	
	private static ArrayList<Piece> initTeamPieces(TeamColor color){
		
		return new ArrayList<>(Arrays.asList(PieceFactory.getPiece(GENERAL, color),
											 PieceFactory.getPiece(CHARIOT, color), PieceFactory.getPiece(CHARIOT, color),
											 PieceFactory.getPiece(HORSE, color), PieceFactory.getPiece(HORSE, color),
											 PieceFactory.getPiece(CANNON, color), PieceFactory.getPiece(CANNON, color),
											 PieceFactory.getPiece(ADVISOR, color), PieceFactory.getPiece(ADVISOR, color),
											 PieceFactory.getPiece(MINSTER, color), PieceFactory.getPiece(MINSTER, color),
											 PieceFactory.getPiece(SOLDIER, color), PieceFactory.getPiece(SOLDIER, color),
											 PieceFactory.getPiece(SOLDIER, color), PieceFactory.getPiece(SOLDIER, color), PieceFactory.getPiece(SOLDIER, color)));
	}
}
