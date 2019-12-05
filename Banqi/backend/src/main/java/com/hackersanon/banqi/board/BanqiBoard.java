package com.hackersanon.banqi.board;

import com.hackersanon.banqi.database.model.Coordinate;
import com.hackersanon.banqi.database.model.Piece;
import com.hackersanon.banqi.database.model.Square;
import com.hackersanon.banqi.piece.TeamColor;

import java.util.*;

import static com.hackersanon.banqi.piece.PieceAttributes.*;

public class BanqiBoard
{
    private static int colDimension = 8;
    private static int rowDimension = 4;

    public BanqiBoard(){
    }

    public static Collection<Square> initialize(){
        return initSquares();
    }

    private static List<Square> initSquares(){
        ArrayList<Piece> allPiece = initAllPieces();
        List<com.hackersanon.banqi.database.model.Square> board = new ArrayList<>();
        for (int i = 0; i<rowDimension;++i){
            for(int j = 0; j<colDimension;++j){
                board.add(new com.hackersanon.banqi.database.model.Square(allPiece.remove(0), new Coordinate(i, j) ));
            }
        }
        return board;
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

//    public Square getSquare(Coordinate coordinate){
//        if(coordinate.isValid()){
//            return board.get(coordinate.getRow()*rowDimension+coordinate.getColumn());
//        }else{
//            return null; //TODO throw new exception?
//        }
//    }
//
//    public Piece getPieceAt(Coordinate coordinate){
//        if (this.getSquare(coordinate) != null) {
//            return this.getSquare(coordinate).getStoredPiece();
//        }
//        else {
//            return null;
//        }
//    }


//    public Move makeMove(Move newMove){
//        return makeMove(getSquare(newMove.getOrigin()),getSquare(newMove.getDestination()));
//    }
//
//    public Move makeMove(SquareFunctions origin, SquareFunctions destination){
//        Move newMove = new Move(this, origin,destination);
//        if(newMove.getActionType() == TRAVEL || newMove.getActionType() == CAPTURE){
//            return newMove.executeMove(this);
//        }else if(newMove.getActionType() == FLIP){
//            return newMove.executeFlip(this);
//        }
//        return newMove;
//    }

}
