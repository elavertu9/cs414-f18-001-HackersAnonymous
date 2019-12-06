package com.hackersanon.banqi.board;

import com.hackersanon.banqi.database.model.Board;
import com.hackersanon.banqi.database.model.Coordinate;
import com.hackersanon.banqi.database.model.Piece;
import com.hackersanon.banqi.database.model.Square;
import com.hackersanon.banqi.piece.TeamColor;

import java.util.*;

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
            ArrayList<Square> board1 = new ArrayList<>(boardObject.getBoard());
            return board1.get(coordinate.getRow()*colDimension+coordinate.getColumn());
        }else{
            throw new InvalidCoordinateException();
        }
    }

}
