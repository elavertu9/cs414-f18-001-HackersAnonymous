package com.hackersanon.banqi.board;

import com.hackersanon.banqi.piece.PieceFunctions;

public class SquareFunctions
{
    SquareFunctions(CoordinateFunctions coordinate, PieceFunctions pieceFunctions){
    }

    protected SquareFunctions(CoordinateFunctions coordinate){
        this(coordinate,null);
    }
	
	public SquareFunctions()
	{
	
	}
	
//	public Piece getStoredPiece(){
//        return storedPiece;
//    }
//
//	public void setStoredPiece(Piece piece)
//	{
//		this.storedPiece = piece;
//	}
//
//    public Coordinate getCoordinate(){
//        return coordinate;
//    }
//
//	public void setCoordinate(Coordinate coordinate)
//	{
//		this.coordinate = coordinate;
//	}
//
//    public Piece occupySquare(Piece newPiece){
//        Piece captured = null;
//        if(checkOccupied()) {
//            captured = this.storedPiece;
//        }
//        this.storedPiece = newPiece;
//        return captured;
//    }
//
//    public void vacateSquare(){
//        this.storedPiece = new Piece(EMPTY, NEUTRAL);
//    }
//
//   public boolean checkOccupied(){
//        return (storedPiece.getPieceType() != EMPTY);
//   }
//
//    public String toString(){
//        return storedPiece.toString();
//    }
}
