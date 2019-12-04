package com.hackersanon.banqi.database.model;


import javax.persistence.Embeddable;


@Embeddable
public class Board
{
//	@ElementCollection
//	private Collection<Square> board = new ArrayList<>();


	private int colDimension = 8;
	private int rowDimension = 4;
	private boolean gameOver = false;

	public Board(){
	}



//	public void setBoard(Collection<Square> board)
//	{
//		this.board = board;
//	}
//
//	public Collection<Square> getBoard()
//	{
//		return board;
//	}
}
