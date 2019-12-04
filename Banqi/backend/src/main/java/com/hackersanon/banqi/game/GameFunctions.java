package com.hackersanon.banqi.game;

import com.hackersanon.banqi.board.BanqiBoard;


public class GameFunctions
{
    private BanqiBoard banqiBoard;


    public GameFunctions(){
        banqiBoard = new BanqiBoard();
    }
    
    public void start(){
        banqiBoard.initialize();
    }
    
    public boolean isGameOver(){
        return false; //TODO need to implement isGameOver()
    }
//
//    public ArrayList<Coordinate> getValidMoves(Coordinate origin){
//        return banqiBoard.getSquare(origin).getStoredPiece().getValidMoveList(origin);
//    }
    
    public void attemptMove(Move newMove) throws GameOverException {
        if(isGameOver()){
            throw new GameOverException();
        }
    }
//
//    public void attemptMove(String origin, String destination) throws GameOverException {
//        Move move = new Move(this.getBanqiBoard(), CoordinateFunctions.convertANtoCoord(origin), CoordinateFunctions.convertANtoCoord(destination));
//        if (isGameOver()){
//            throw new GameOverException();
//        }
//    }
    
    public BanqiBoard getBanqiBoard() {
        return banqiBoard;
    }
    
}
