package com.hackersanon.banqi.board;

import com.hackersanon.banqi.piece.Piece;

import java.io.Serializable;

import static com.hackersanon.banqi.piece.PieceAttributes.EMPTY;
import static com.hackersanon.banqi.piece.TeamColor.NEUTRAL;

public class Square implements Serializable
{
    private Piece storedPiece;
    
    private Coordinate coordinate;

    Square(Coordinate coordinate, Piece piece){
        this.coordinate = coordinate;
        this.storedPiece = piece;
    }

    protected Square(Coordinate coordinate){
        this(coordinate,null);
    }
	
	public Square()
	{
	
	}
	
	public Piece getStoredPiece(){
        return storedPiece;
    }
	
	public void setStoredPiece(Piece piece)
	{
		this.storedPiece = piece;
	}

    public Coordinate getCoordinate(){
        return coordinate;
    }
	
	public void setCoordinate(Coordinate coordinate)
	{
		this.coordinate = coordinate;
	}

    public Piece occupySquare(Piece newPiece){
        Piece captured = null;
        if(checkOccupied()) {
            captured = this.storedPiece;
        }
        this.storedPiece = newPiece;
        return captured;
    }

    public void vacateSquare(){
        this.storedPiece = new Piece(EMPTY, NEUTRAL);
    }

   public boolean checkOccupied(){
        return (storedPiece.getPieceType() != EMPTY);
   }

    public String toString(){
        return storedPiece.toString();
    }
}
