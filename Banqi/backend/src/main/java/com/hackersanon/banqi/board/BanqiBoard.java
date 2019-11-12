package com.hackersanon.banqi.board;

import com.hackersanon.banqi.game.Move;
import com.hackersanon.banqi.piece.Piece;
import com.hackersanon.banqi.piece.TeamColor;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.hackersanon.banqi.game.Move.Actions.*;
import static com.hackersanon.banqi.piece.PieceAttributes.*;

public class BanqiBoard {
    private Square[][] board;
    private int colDimension = 8;
    private int rowDimension = 4;
    private boolean gameOver;


    public BanqiBoard(){
        this.board = new Square[rowDimension][colDimension];
    }

    public void initialize(){
        initSquares(initAllPieces());
    }

    private void initSquares(ArrayList<Piece> allPieces){
        for (int i = 0; i<board.length;++i){
            for(int j = 0; j<board[i].length;++j){
                board[i][j] = new Square(new Coordinate(i,j), allPieces.remove(0));
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

    public Square[][] getBoard() {
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
            return board[coordinate.getRow()][coordinate.getColumn()];
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

    public String toString(){
        StringBuilder boardString = new StringBuilder();
        for (int i = board.length-1; i>=0;--i) {
            for (int j = 0; j<board[i].length; ++j) {
                boardString.append("\t").append(board[i][j].toString()).append("\t"); // TODO format to print actual sized board with squares
            }
            boardString.append('\n');
        }
        return boardString.toString();
    }

    public void printBoard(){
        AsciiTable printBoard = new AsciiTable();
        for(int i = board.length-1; i>=0;--i){
            printBoard.addRule();
            printBoard.addRow(Arrays.asList(board[i])).setTextAlignment(TextAlignment.CENTER).setPaddingLeftRight(1,2);
        }
        printBoard.addRule();
        printBoard.getContext().setWidth(125);
        System.out.println(printBoard.render());
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


//    public String[][] getStringBoard() {
//        String[][] stringBoard = new String[rowDimension][colDimension];
//        int i=0,j = 0;
//        for(Square[] row: board){
//            for(Square square: row){
//                stringBoard[i++][j++] = square.;
//            }
//        }
//    }
}
