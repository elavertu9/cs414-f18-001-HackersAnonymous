package com.hackersanon.banqi.database.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Embeddable
public class Board
{
	@ElementCollection
	private Collection<Square> board = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int colDimension = 8;
	private int rowDimension = 4;
	private boolean gameOver = false;

	public Board(){
	}

	public Board(Collection<Square> board){
		this.board = board;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
	
	public Long getId()
	{
		return id;
	}


	public void setBoard(Collection<Square> board)
	{
		this.board = board;
	}

	public Collection<Square> getBoard()
	{
		return board;
	}
}
