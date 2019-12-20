package com.hackersanon.banqi.model.board;


import com.hackersanon.banqi.exception.InvalidCoordinateException;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.Collection;


@Embeddable
public class Board
{
    @ElementCollection
	private Collection<Square> board = new ArrayList<>();

	private int colDimension;

	private int rowDimension;

	public Board(){}
	
	public Board(int x, int y){
		this.colDimension = x;
		this.rowDimension = y;
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

	public void setBoard(Collection<Square> board)
	{
		this.board = board;
	}

	public Collection<Square> getBoard()
	{
		return board;
	}

	public Square getSquare(Coordinate coordinate) throws InvalidCoordinateException
	{
		if(coordinate.valid()){
			ArrayList<Square> board1 = new ArrayList<>(this.getBoard());
			return board1.get(coordinate.getRow()*colDimension+coordinate.getColumn());
		}else{
			throw new InvalidCoordinateException();
		}
	}


}
