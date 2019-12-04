package com.hackersanon.banqi.database.model;


import com.hackersanon.banqi.board.BanqiBoard;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.Collection;


@Embeddable
public class Board
{
    @ElementCollection
	private Collection<Square> board = new ArrayList<>();

	private int colDimension = 8;

	private int rowDimension = 4;
    private boolean gameOver = false;

	public Board(){
		this.board = BanqiBoard.initialize();
	}


	public int getColDimension() {
		return colDimension;
	}

	public void setColDimension(int colDimension) {
		this.colDimension = colDimension;
	}

	public int getRowDimension() {
		return rowDimension;
	}

	public void setRowDimension(int rowDimension) {
		this.rowDimension = rowDimension;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
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
