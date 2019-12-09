package com.hackersanon.banqi.model.board;


import com.hackersanon.banqi.exception.InvalidCoordinateException;
import com.hackersanon.banqi.model.piece.Piece;
import com.hackersanon.banqi.model.piece.TeamColor;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.*;

import static com.hackersanon.banqi.model.piece.PieceAttributes.*;


@Embeddable
public class Board
{
    @ElementCollection
	private Collection<Square> board = new ArrayList<>();

	private int colDimension = 8;

	private int rowDimension = 4;


	public Board(){
		initialize();
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

	private void initialize(){
		ArrayList<Piece> allPiece = initAllPieces();
		for (int i = 0; i<rowDimension;++i){
			for(int j = 0; j<colDimension;++j){
				this.board.add(new Square(allPiece.remove(0), new Coordinate(i, j) ));
			}
		}
	}

	private static ArrayList<Piece> initAllPieces(){
		ArrayList<Piece> allPiece = new ArrayList<>(initTeamPieces(TeamColor.RED));
		allPiece.addAll(initTeamPieces(TeamColor.BLACK));
		for(int i=0;i<5;++i){
			Collections.shuffle(allPiece);
		}
		return allPiece;
	}

	private static ArrayList<Piece> initTeamPieces(TeamColor color){
		return new ArrayList<>(Arrays.asList( new Piece(GENERAL, color),
				new Piece(CHARIOT, color), new Piece(CHARIOT, color),
				new Piece(HORSE, color), new Piece(HORSE, color),
				new Piece(CANNON, color), new Piece(CANNON, color),
				new Piece(ADVISOR, color), new Piece(ADVISOR, color),
				new Piece(MINSTER, color), new Piece(MINSTER, color),
				new Piece(SOLDIER, color), new Piece(SOLDIER, color),
				new Piece(SOLDIER, color), new Piece(SOLDIER, color),new Piece(SOLDIER, color)));
	}

}
