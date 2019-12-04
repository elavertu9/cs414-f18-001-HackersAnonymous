package com.hackersanon.banqi.database.model;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game extends ModelBase
{

	@Transient
	private static final long serialVersionUID = -3621010469526215357L;


	@Embedded
	private Board board;

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

	public void setPlayerOneId(Long playerOneId){
		this.playerOneId = playerOneId;
	}
	public Long getPlayerOneId(){
		return this.playerOneId;
	}

	public void setPlayerTwoId(Long playerTwoId){
		this.playerTwoId = playerTwoId;
	}

	public Long getPlayerTwoId(){
		return this.playerTwoId;
	}

}
