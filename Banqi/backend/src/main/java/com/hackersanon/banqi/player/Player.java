package com.hackersanon.banqi.player;

import com.hackersanon.banqi.piece.TeamColor;

public class Player {
    private TeamColor team;
    private boolean turn = false;
    public Player(TeamColor color){
        this.team = color;
    }

    public boolean isTurn(){
        return turn;
    }

    public void toggleTurn(){
        turn = !turn;
    }
    public TeamColor getPlayerTeam(){
        return team;
    }
}
