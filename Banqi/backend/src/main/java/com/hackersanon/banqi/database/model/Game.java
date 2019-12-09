package com.hackersanon.banqi.database.model;

import com.hackersanon.banqi.piece.TeamColor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "game")
public class Game extends ModelBase
{

	@Transient
	private static final long serialVersionUID = -3621010469526215357L;

	@Embedded
	private Board board;

	private boolean gameOver = false;
	private boolean forfeit = false;
	private String quitter;
	private boolean turn = false;
	
	
	public String getQuitter()
	{
		return quitter;
	}
	
	public void setQuitter(String quitter)
	{
		this.quitter = quitter;
	}
	
	public boolean getForfeit()
	{
		return forfeit;
	}
	
	public void setForfeit(boolean forfeit)
	{
		this.forfeit = forfeit;
	}
	
	public boolean isGameOver() {
		return this.gameOver;
	}

	public void setGameOver(boolean gameOver) {
		List<TeamColor> teamOnBoard = new ArrayList<>();
		board.getBoard().forEach(square -> {
			if (square.getPiece().getTeamColor() == TeamColor.RED) {
				teamOnBoard.add(TeamColor.RED);
			}
			if (square.getPiece().getTeamColor() == TeamColor.BLACK) {
				teamOnBoard.add(TeamColor.BLACK);
			}
		});
		if (!(teamOnBoard.contains(TeamColor.RED) && teamOnBoard.contains(TeamColor.BLACK))) {
			this.gameOver = true;
		}
	}

	@ElementCollection
	@AttributeOverride(name = "valid", column = @Column(name = "validCoord"))
	private Collection<Move> moveHistory = new ArrayList<>();

	@Column
	private Long playerOneId;

	@Column
	private Long playerTwoId;

	public Game(){
	}

	public Game(Board board, Long playerOneId, Long playerTwoId){
		this.board = board;
		this.playerOneId = playerOneId;
		this.playerTwoId = playerTwoId;
	}

	public void setBoard(Board board){
		this.board = board;
	}

	public Board getBoard(){
		return this.board;
	}

	public Collection<Move> getMoveHistory() {
		return moveHistory;
	}

	public void setMoveHistory(Collection<Move> moveHistory) {
		this.moveHistory = moveHistory;
	}

	public void setPlayerOneId(Long playerOneId){
		this.playerOneId = playerOneId;
	}

	public Long getPlayerOneId(){
		return this.playerOneId;
	}
	public void setPlayerTwoId(Long playerTwoId){
		this.playerTwoId = playerTwoId;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public Long getPlayerTwoId(){
		return this.playerTwoId;
	}

}
