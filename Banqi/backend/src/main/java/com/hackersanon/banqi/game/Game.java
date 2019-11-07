package com.hackersanon.banqi.game;

import com.hackersanon.banqi.board.BanqiBoard;
import com.hackersanon.banqi.board.Coordinate;
import com.hackersanon.banqi.player.Player;
import java.util.ArrayList;


public class Game {
    private BanqiBoard banqiBoard;
    private ArrayList<Player> players;
    private ArrayList<Move> moveHistory;

    public Game(){
        banqiBoard = new BanqiBoard();
        moveHistory = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void start(){
        banqiBoard.initialize();
    }

    private boolean isGameOver(){
        return false; //TODO need to implement isGameOver()
    }

    public boolean undoMove(){
        return false; //TODO implement undoMove()
    }

    public ArrayList<Coordinate> getValidMoves(Coordinate origin){
        return banqiBoard.getSquare(origin).getStoredPiece().getValidMoveList(origin);
    }

    public void attemptMove(Move newMove) throws GameOverException {
        moveHistory.add(banqiBoard.makeMove(newMove));
        if(isGameOver()){
            throw new GameOverException();
        }
    }

    public void attemptMove(String origin, String destination) throws GameOverException {
        Move move = new Move(this.getBanqiBoard(), Coordinate.convertANtoCoord(origin), Coordinate.convertANtoCoord(destination));
        attemptMove(move);
    }

    public BanqiBoard getBanqiBoard() {
        return banqiBoard;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }


}
