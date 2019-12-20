package com.hackersanon.banqi.model.board;


import com.sun.tools.javac.util.Pair;

import java.util.HashMap;

public class PieceFactory
{
	private static final HashMap<Pair<String, String>, Piece> pieceMap = new HashMap<>();
	
	public static Piece getPiece(PieceAttributes pieceType, TeamColor teamColor){
		Pair<String, String> pieceKey = Pair.of(pieceType.name(), teamColor.name());
		Piece piece = pieceMap.get(pieceKey);
		if(piece == null){
			piece = new Piece(pieceType, teamColor);
			pieceMap.put(pieceKey, piece);
		}
		return piece;
	}
}
