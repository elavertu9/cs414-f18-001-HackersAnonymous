package com.hackersanon.banqi.model.board;

import java.util.ArrayList;
import java.util.Collection;

public class BoardBuilder
{
	public Board buildBoard(int row, int column, ArrayList<Piece> orderedPieceList){
		Board board = new Board();
		board.setColDimension(column);
		board.setRowDimension(row);
		board.setBoard(prepareBoard(row, column, orderedPieceList));
		return board;
	}
	
	private Collection<Square> prepareBoard(int row, int column, ArrayList<Piece> orderedPieceList){
		Collection<Square> board = new ArrayList<>();
		for (int i = 0; i<row;++i){
			for(int j = 0; j<column;++j){
				board.add(new Square(orderedPieceList.remove(0), new Coordinate(i, j)));
			}
		}
		return board;
	}
}
