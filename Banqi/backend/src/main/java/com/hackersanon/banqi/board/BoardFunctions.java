package com.hackersanon.banqi.board;

import com.hackersanon.banqi.database.model.*;
import com.hackersanon.banqi.piece.TeamColor;

import java.util.*;

import static com.hackersanon.banqi.game.MoveType.*;
import static com.hackersanon.banqi.piece.PieceAttributes.*;

public class BoardFunctions
{
    private static int colDimension = 8;
    private static int rowDimension = 4;

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

    public static Square getSquare(Board boardObject, Coordinate coordinate) throws InvalidCoordinateException{
        if(CoordinateFunctions.isValid(coordinate)){
            ArrayList<Square> board1 = (ArrayList<Square>) boardObject.getBoard();
            return board1.get(coordinate.getRow()*rowDimension+coordinate.getColumn());
        }else{
            throw new InvalidCoordinateException();
        }
    }

    public Move makeMove(Board boardObject, Move newMove) throws InvalidMoveException{
        try {
            return makeMove(boardObject, getSquare(boardObject,newMove.getOrigin()), getSquare(boardObject,newMove.getDestination()));
        } catch (InvalidCoordinateException e) {
            throw new InvalidMoveException();
        }
    }

    public Move makeMove(Board boardObject, Square origin, Square destination) throws InvalidMoveException {
        Move newMove = new Move();
        if(newMove.getMoveType() == TRAVEL || newMove.getMoveType() == CAPTURE){
            try {
                return newMove.executeMove(boardObject);
            } catch (InvalidCoordinateException e) {
                e.printStackTrace();
                throw new InvalidMoveException();
            }
        }else if(newMove.getMoveType() == FLIP){
            return newMove.executeFlip(boardObject);
        }
        return newMove;
    }

}
