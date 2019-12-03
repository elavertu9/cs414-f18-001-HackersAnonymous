package com.hackersanon.banqi.game;

import com.hackersanon.banqi.board.BanqiBoard;
import com.hackersanon.banqi.board.Coordinate;
import com.hackersanon.banqi.database.model.ModelBase;

import javax.persistence.ElementCollection;
import java.util.ArrayList;


public class Game extends ModelBase
{
   @ElementCollection
    private BanqiBoard banqiBoard;
    
    private long id;
    
    public Game(){
        banqiBoard = new BanqiBoard();
    }
    
    public void start(){
        banqiBoard.initialize();
    }
    
    public boolean isGameOver(){
        return false; //TODO need to implement isGameOver()
    }
    
    public ArrayList<Coordinate> getValidMoves(Coordinate origin){
        return banqiBoard.getSquare(origin).getStoredPiece().getValidMoveList(origin);
    }
    
    public void attemptMove(Move newMove) throws GameOverException {
        if(isGameOver()){
            throw new GameOverException();
        }
    }
    
    public void attemptMove(String origin, String destination) throws GameOverException {
        Move move = new Move(this.getBanqiBoard(), Coordinate.convertANtoCoord(origin), Coordinate.convertANtoCoord(destination));
        if (isGameOver()){
            throw new GameOverException();
        }
    }
    
    public BanqiBoard getBanqiBoard() {
        return banqiBoard;
    }
    
}
