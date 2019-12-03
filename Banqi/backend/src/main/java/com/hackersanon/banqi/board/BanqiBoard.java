package com.hackersanon.banqi.board;

import com.hackersanon.banqi.game.Move;
import com.hackersanon.banqi.piece.Piece;
import com.hackersanon.banqi.piece.TeamColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.hackersanon.banqi.game.Move.Actions.*;
import static com.hackersanon.banqi.piece.PieceAttributes.*;

public class BanqiBoard
{
    private List<Square> board;
    
    
    private int colDimension = 8;
    private int rowDimension = 4;
    private boolean gameOver;


    public BanqiBoard(){
        this.board = new ArrayList<>();
    }

    public void initialize(){
        initSquares(initAllPieces());
    }

    private void initSquares(ArrayList<Piece> allPieces){
        
        for (int i = 0; i<rowDimension;++i){
            for(int j = 0; j<colDimension;++j){
                board.add(new Square(new Coordinate(i, j), allPieces.remove(0)));
            }
        }
    }

    public ArrayList<Piece> initAllPieces(){
        ArrayList<Piece> allPieces = new ArrayList<>(initTeamPieces(TeamColor.RED));
        allPieces.addAll(initTeamPieces(TeamColor.BLACK));
        for(int i=0;i<5;++i){
            Collections.shuffle(allPieces);
        }
        return allPieces;
    }

    private ArrayList<Piece> initTeamPieces(TeamColor color){
        return new ArrayList<>(Arrays.asList( new Piece(GENERAL, color),
                new Piece(CHARIOT, color), new Piece(CHARIOT, color),
                new Piece(HORSE, color), new Piece(HORSE, color),
                new Piece(CANNON, color), new Piece(CANNON, color),
                new Piece(ADVISOR, color), new Piece(ADVISOR, color),
                new Piece(MINSTER, color), new Piece(MINSTER, color),
                new Piece(SOLDIER, color), new Piece(SOLDIER, color),
                new Piece(SOLDIER, color), new Piece(SOLDIER, color),new Piece(SOLDIER, color)));
    }

    
    public List<Square> getBoard() {
        return board;
    }

    public int getColDimension() {
        return colDimension;
    }

    public int getRowDimension() {
        return rowDimension;
    }

    public Square getSquare(Coordinate coordinate){
        if(coordinate.isValid()){
            return board.get(coordinate.getRow()*rowDimension+coordinate.getColumn());
        }else{
            return null; //TODO throw new exception?
        }
    }

    public Piece getPieceAt(Coordinate coordinate){
        if (this.getSquare(coordinate) != null) {
            return this.getSquare(coordinate).getStoredPiece();
        }
        else {
            return null;
        }
    }


    public Move makeMove(Move newMove){
        return makeMove(getSquare(newMove.getOrigin()),getSquare(newMove.getDestination()));
    }

    public Move makeMove(Square origin, Square destination){
        Move newMove = new Move(this, origin,destination);
        if(newMove.getActionType() == TRAVEL || newMove.getActionType() == CAPTURE){
            return newMove.executeMove(this);
        }else if(newMove.getActionType() == FLIP){
            return newMove.executeFlip(this);
        }
        return newMove;
    }

}
