package com.hackersanon.banqi.game;

import com.google.common.collect.Multimaps;
import com.hackersanon.banqi.board.BanqiBoard;
import com.hackersanon.banqi.board.Coordinate;
import com.hackersanon.banqi.piece.Piece;
import com.hackersanon.banqi.piece.PieceAttributes;
import com.hackersanon.banqi.player.Player;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private BanqiBoard banqiBoard;
    private ArrayList<Player> players;
    private Multimap< PieceAttributes, Multimap<Coordinate,Coordinate> > validMoveArchive;
    private ArrayList<Move> moveHistory;

    public Game(){
        banqiBoard = new BanqiBoard();
        moveHistory = new ArrayList<>();
        validMoveArchive = ArrayListMultimap.create(ArrayListMultimap.create());
        players = new ArrayList<>();
    }

    public void start(){
        banqiBoard.initialize();
    }

    public boolean isGameOver(){
        return false; //TODO need to implement isGameOver()
    }

    public boolean undoMove(){
        return false; //TODO implement undoMove()
    }

    public ArrayList<Coordinate> getValidMoves(Coordinate origin){
        Piece pieceAtOrigin = banqiBoard.getPieceAt(origin);
//        if(validMoveArchive.containsKey(pieceAtOrigin.getPieceType())&&validMoveArchive.get(pieceAtOrigin.getPieceType()).contains(origin)) {
//            Multimap<Coordinate, Coordinate> tempMap = (Multimap<Coordinate, Coordinate>) validMoveArchive.get(pieceAtOrigin.getPieceType());
//        }
        return banqiBoard.getSquare(origin).getStoredPiece().getValidMoveList(origin);
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
